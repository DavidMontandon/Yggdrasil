package com.deedllit.yggdrasil.world.dimensions.asgard.dimension;


import com.deedllit.yggdrasil.common.world.YggdrasilSurfaceDimension;
import com.deedllit.yggdrasil.world.dimensions.asgard.generator.AsgardBiomeProvider;
import com.deedllit.yggdrasil.world.dimensions.asgard.generator.AsgardGenSettings;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AsgardDimension extends YggdrasilSurfaceDimension {
	

	public static final BlockPos SPAWN = new BlockPos(100, 50, 0);
	
	public AsgardDimension(World world, DimensionType type) {		
		super(world, type, 0.0f);
		
		for (int i = 0; i <= 15; ++i) {
			this.lightBrightnessTable[i] = i / 15F;
		}
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
      return ChunkGeneratorType.FLOATING_ISLANDS.create(this.world, 
    		  new AsgardBiomeProvider(this.getWorld()), 
    		  new AsgardGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
	      for(int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
	          for(int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
	             BlockPos blockpos = this.findSpawn(i, j, checkValid);
	             if (blockpos != null) {
	                return blockpos;
	             }
	          }
	       }

	       return null;
	}
	
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
	      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(posX, 0, posZ);
	      Biome biome = this.world.getBiome(blockpos$mutable);
	      BlockState blockstate = biome.getSurfaceBuilderConfig().getTop();
	      if (checkValid && !blockstate.getBlock().isIn(BlockTags.VALID_SPAWN)) {
	         return null;
	      } else {
	         Chunk chunk = this.world.getChunk(posX >> 4, posZ >> 4);
	         int i = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, posX & 15, posZ & 15);
	         if (i < 0) {
	            return null;
	         } else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, posX & 15, posZ & 15) > chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, posX & 15, posZ & 15)) {
	            return null;
	         } else {
	            for(int j = i + 1; j >= 0; --j) {
	               blockpos$mutable.setPos(posX, j, posZ);
	               BlockState blockstate1 = this.world.getBlockState(blockpos$mutable);
	               if (!blockstate1.getFluidState().isEmpty()) {
	                  break;
	               }

	               if (blockstate1.equals(blockstate)) {
	                  return blockpos$mutable.up().toImmutable();
	               }
	            }

	            return null;
	         }
	      }
	}


	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		int j = 6000;
		float f1 = (j + partialTicks) / 24000.0f - 0.25f;
		if (f1 < 0.0f) {
			f1 += 1.0f;
		}

		if (f1 > 1.0f) {
			f1 -= 1.0f;
		}

		float f2 = f1;
		f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
		f1 = f2 + (f1 - f2) / 3.0f;
		return f1;		
		
	}
	

	@Override
	@OnlyIn(Dist.CLIENT)
	public float getCloudHeight() {
		return 14.0F;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW ; 
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}
    
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.7529412F;
		float f2 = 0.84705883F;
		float f3 = 1.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d((double) f1, (double) f2, (double) f3);
		
	}
		
	public BlockPos getSpawnCoordinate() {
		return SPAWN;
	}
	
}
