package com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension;

import javax.annotation.Nullable;

import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.biomes.SvartalvheimBiomeProvider;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.generator.SvartalvheimCaveGenSettings;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.generator.SvartalvheimChunkGenerator;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SvartalvheimDimension extends Dimension {
	   private static final Vec3d field_227177_f_ = new Vec3d((double)0.2F, (double)0.03F, (double)0.03F);

	   public SvartalvheimDimension(World worldIn, DimensionType typeIn) {
	      super(worldIn, typeIn, 0.1F);
	      this.doesWaterVaporize = false;
	      this.nether = true;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public Vec3d getFogColor(float celestialAngle, float partialTicks) {
	      return field_227177_f_;
	   }

	   public ChunkGenerator<?> createChunkGenerator() {
		 
		  SvartalvheimCaveGenSettings genSettings = new SvartalvheimCaveGenSettings() ;
		  genSettings.setDefaultBlock(BlockInit.SVARTALVHEIM_STONE.get().getDefaultState());
		  genSettings.setDefaultFluid(Blocks.WATER.getDefaultState());
		  
		  return new SvartalvheimChunkGenerator( world, new SvartalvheimBiomeProvider(), genSettings ) ;

	      
	   }

	   public boolean isSurfaceWorld() {
	      return false;
	   }

	   @Nullable
	   public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
	      return null;
	   }

	   @Nullable
	   public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
	      return null;
	   }

	   public float calculateCelestialAngle(long worldTime, float partialTicks) {
	      return 0.5F;
	   }

	   public boolean canRespawnHere() {
	      return false;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public boolean doesXZShowFog(int x, int z) {
	      return true;
	   }

	   public WorldBorder createWorldBorder() {
	      return new WorldBorder() {
	         public double getCenterX() {
	            return super.getCenterX() / 8.0D;
	         }

	         public double getCenterZ() {
	            return super.getCenterZ() / 8.0D;
	         }
	      };
	   }
}
