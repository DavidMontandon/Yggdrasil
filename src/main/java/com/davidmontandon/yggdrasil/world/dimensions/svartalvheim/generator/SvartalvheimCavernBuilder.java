package com.davidmontandon.yggdrasil.world.dimensions.svartalvheim.generator;

import java.util.Random;
import java.util.function.Function;

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
	   private static final BlockState LAYER1 = Blocks.STONE.getDefaultState();
	   private static final BlockState LAYER2 = Blocks.GRAVEL.getDefaultState();
	   private static final BlockState LAYER3 = Blocks.IRON_BLOCK.getDefaultState();
	   private static final int HEIGHT = 255; //127 
	   protected long field_205552_a;
	   protected OctavesNoiseGenerator field_205553_b;
	   
	   
	   public SvartalvheimCavernBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51308_1_) {
	      super(p_i51308_1_);
	   }

	   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

			BlockState blockstate = LAYER1;
			BlockState blockstate1 = LAYER1;
			BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		   
			int i = seaLevel + 1;
			int j = x & 15;
			int k = z & 15;
			int i1 = -1;
		      
		      boolean flag =  noise * (double)x * 0.03125D + (double)z * 0.03125D +  0.75D *  random.nextDouble() > 0.0D;
		      boolean flag1 =  noise * (double)x * 0.03125D + (double)z * 0.03125D +  0.75D *  random.nextDouble() > 0.0D;
		      int l = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);

		      for(int j1 = HEIGHT; j1 >= 0; --j1) {
		    	  
		    	  
			         blockpos$mutable.setPos(j, j1, k);
			         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
			         if (blockstate2.getBlock() != null && !blockstate2.isAir()) {
			            if (blockstate2.getBlock() == defaultBlock.getBlock()) {
			               if (i1 == -1) {
			                  if (l <= 0) {
			                     blockstate = CAVE_AIR;
			                     blockstate1 = LAYER1;
			                  } else if (j1 >= i - 4 && j1 <= i + 1) {
			                     blockstate = LAYER1;
			                     blockstate1 = LAYER1;
			                     if (flag1) {
			                        blockstate = LAYER2;
			                        blockstate1 = LAYER1;
			                     }

			                     if (flag) {
			                        blockstate = LAYER3;
			                        blockstate1 = LAYER3;
			                     }
			                  }

			                  if (j1 < i && (blockstate == null || blockstate.isAir())) {
			                     blockstate = defaultFluid;
			                  }

			                  i1 = l;
			                  if (j1 >= i - 1) {
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
			            //i1 = -1;
			         }
		      }
		      
		      /*
		      for(int j1 = HEIGHT; j1 >= 0; --j1) {
		    	  
		    	  
			         blockpos$mutable.setPos(j, j1, k);
			         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
			         if (blockstate2.getBlock() != null && !blockstate2.isAir()) {
			            if (blockstate2.getBlock() == defaultBlock.getBlock()) {
			               if (i1 == -1) {
			                  if (l <= 0) {
			                     blockstate = CAVE_AIR;
			                     blockstate1 = LAYER1;
			                  } else if (j1 >= i - 4 && j1 <= i + 1) {
			                     blockstate = LAYER1;
			                     blockstate1 = LAYER1;
			                     if (flag1) {
			                        blockstate = LAYER2;
			                        blockstate1 = LAYER1;
			                     }

			                     if (flag) {
			                        blockstate = LAYER3;
			                        blockstate1 = LAYER3;
			                     }
			                  }

			                  if (j1 < i && (blockstate == null || blockstate.isAir())) {
			                     blockstate = defaultFluid;
			                  }

			                  i1 = l;
			                  if (j1 >= i - 1) {
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
			            //i1 = -1;
			         }
		      }
		      */
		      
		      /*
		      for(int j1 = HEIGHT; j1 >= 0; --j1) {
			         blockpos$mutable.setPos(j, j1, k);
			         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
			         chunkIn.setBlockState(blockpos$mutable, blockstate, false);
		      }
		      */

		      
		      
		   /*
		  noise = 1 - noise ; 
		   
		  int i = seaLevel + 1;
	      int j = x & 15;
	      int k = z & 15;
	      double d0 = 0.03125D;
	      boolean flag = this.field_205553_b.func_205563_a((double)x * 0.03125D, (double)z * 0.03125D, 0.0D) * 75.0D + random.nextDouble() > 0.0D;
	      boolean flag1 = this.field_205553_b.func_205563_a((double)x * 0.03125D, 109.0D, (double)z * 0.03125D) * 75.0D + random.nextDouble() > 0.0D;
	      int l = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
	      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
	      int i1 = -1;
	      BlockState blockstate = LAYER1;
	      BlockState blockstate1 = LAYER1;

	      for(int j1 = HEIGHT; j1 >= 0; --j1) {
	         blockpos$mutable.setPos(j, j1, k);
	         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
	         if (blockstate2.getBlock() != null && !blockstate2.isAir()) {
	            if (blockstate2.getBlock() == defaultBlock.getBlock()) {
	               if (i1 == -1) {
	                  if (l <= 0) {
	                     blockstate = CAVE_AIR;
	                     blockstate1 = LAYER1;
	                  } else if (j1 >= i - 4 && j1 <= i + 1) {
	                     blockstate = LAYER1;
	                     blockstate1 = LAYER1;
	                     if (flag1) {
	                        blockstate = LAYER2;
	                        blockstate1 = LAYER1;
	                     }

	                     if (flag) {
	                        blockstate = LAYER3;
	                        blockstate1 = LAYER3;
	                     }
	                  }

	                  if (j1 < i && (blockstate == null || blockstate.isAir())) {
	                     blockstate = defaultFluid;
	                  }

	                  i1 = l;
	                  if (j1 >= i - 1) {
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
		*/
	   }

	   public void setSeed(long seed) {
	      if (this.field_205552_a != seed || this.field_205553_b == null) {
	         this.field_205553_b = new OctavesNoiseGenerator(new SharedSeedRandom(seed), 3, 0);
	      }

	      this.field_205552_a = seed;
	   }
	}