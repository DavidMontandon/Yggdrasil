package com.deedllit.yggdrasil.world.dimensions.svartalvheim.generator;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.yggdrasil.init.BlockInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.OctavesNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SvartalvheimCavernBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	   private static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
	   private static final BlockState LAYER1 = BlockInit.SVARTALVHEIM_STONE.get().getDefaultState() ;
	   private static final BlockState LAYER2 = Blocks.ACACIA_PLANKS.getDefaultState();
	   private static final BlockState LAYER3 = Blocks.IRON_BLOCK.getDefaultState();
	   private static final BlockState LAYER4 = Blocks.DIAMOND_BLOCK.getDefaultState();
	   private static final int HEIGHT = 255; //127 
	   protected long field_205552_a;
	   protected OctavesNoiseGenerator field_205553_b;
	   
	   
	   public SvartalvheimCavernBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51308_1_) {
	      super(p_i51308_1_);
	   }


	   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		      int i = seaLevel + 1;
		      int x1 = x & 15;
		      int z1 = z & 15;
		      double d0 = 0.03125D;
		      boolean flag = this.field_205553_b.func_205563_a((double)x * 0.03125D, (double)z * 0.03125D, 0.0D) * 75.0D + random.nextDouble() >= 0.0D;
		      boolean flag1 = this.field_205553_b.func_205563_a((double)x * 0.03125D, 109.0D, (double)z * 0.03125D) * 75.0D + random.nextDouble() >= 0.0D;
		      boolean flag2 = this.field_205553_b.func_205563_a((double)x * 0.03125D, 115.0D, (double)z * 0.03125D) * 75.0D + random.nextDouble() > 0.0D;
		      int l = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		      int i1 = -1;
		      BlockState blockstate = LAYER1;
		      BlockState blockstate1 = LAYER1;

		      
		      i1 = -1;
		      
		      for(int y = HEIGHT; y >= 0; --y) {
		         blockpos$mutable.setPos(x1, y, z1);
		         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
		         if (blockstate2.getBlock() != null && !blockstate2.isAir()) {
		            if (blockstate2.getBlock() == defaultBlock.getBlock()) {
		               if (i1 == -1) {
		                  if (l <= 0) {
		                     blockstate1 = CAVE_AIR;
		                     blockstate = LAYER1;
		                  } else if (y >= i - 4 && y <= i + 1) {
		                     blockstate = LAYER1;
		                     blockstate1 = LAYER1;
		                     
		                     if(flag2) {
		                        blockstate1 = LAYER1;
		                        blockstate = LAYER4;		                    	 
		                     }
		                     
		                     if (flag1) {
		                        blockstate1 = LAYER2;
		                        blockstate = LAYER1;
		                     }

		                     if (flag) {
		                        blockstate = LAYER3;
		                        blockstate1 = LAYER3;
		                     }
		                  }

		                  if (y < i && (blockstate == null || blockstate.isAir())) {
		                     blockstate = defaultFluid;
		                  }

		                  i1 = l;
		                  if (y >= i - 1) {
		                     chunkIn.setBlockState(blockpos$mutable, blockstate, false);
		                  } else {
		                     chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
		                  }
		               } else if (i1 > 0) {
		                  --i1;
		                  chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
		               }
		            }
		         } else {
		            i1 = -1;
		         }
		      }

		   }


	   public void setSeed(long seed) {
	      if (this.field_205552_a != seed || this.field_205553_b == null) {
	         this.field_205553_b = new OctavesNoiseGenerator(new SharedSeedRandom(seed), 3, 0);
	      }

	      this.field_205552_a = seed;
	   }
	}