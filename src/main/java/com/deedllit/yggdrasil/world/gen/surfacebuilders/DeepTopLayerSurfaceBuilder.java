package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.SurfaceBuilderInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DeepTopLayerSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public DeepTopLayerSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		//SurfaceBuilderConfig config2 = SurfaceBuilder.GRASS_DIRT_SAND_CONFIG ;

		int maxH ; 
		
		if (noise >= 0D) {

			BlockState stone =  Blocks.STONE.getDefaultState() ; 
			BlockState grass =  Blocks.GRASS_BLOCK.getDefaultState() ; 
			BlockState whitesand =  BlockInit.WHITE_SAND.get().getDefaultState() ; 
			BlockState top = config.getTop() ; 
			BlockState middle = config.getUnder() ; 
			BlockState bottom = config.getUnderWaterMaterial() ; 
			
						
	        BlockState blockstate = top;
	        BlockState blockstate1 = middle;
	        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	        int i = -1;
	        int k = x & 15;
	        int l = z & 15;

	        int sandLevelBottom = seaLevel -4 ;
	        int sandLevelTop = seaLevel +1 ;
	        int moutainLevelBottom = 105 ; 
	        
			double d = Biome.INFO_NOISE.noiseAt(x * 0.25D, z * 0.25D, false);		
			if(d > 0) {
				sandLevelTop += d * 1 ;
				moutainLevelBottom += d * 5 ;
			}

	        int h ; 
			int v = 2 ;
			
			if(noise <= 0.5D) {
				maxH = 12  ; 
				v = 1 ; 
			} else if(noise <= 1.0D) {
				maxH = 14  ; 
				v = 1 ; 
			} else if(noise <= 1.5D) {
				maxH = 15  ; 
				v = 2 ; 
			} else if(noise <= 2.0D) {
				maxH = 17  ; 
				v = 2 ; 
			} else if(noise <= 2.6D) {
				maxH = 18 ; 
				v = 2 ; 
			} else if(noise <= 3.2D) {
				maxH = 24  ; 
				v = 4 ; 
			} else if(noise <= 3.5D) {
				maxH = 38  ; 
				v = 5 ; 
			} else if(noise <= 3.8D) {
				maxH = 40  ; 
				v = 5 ; 
			} else {
				maxH = 48  ; 
				v = 2 ; 
			}

			maxH += random.nextInt(v);
			
			
			
			
	        
	        for(int i1 = 5; i1 <= seaLevel; i1++) {
	            blockpos$mutableblockpos.setPos(k, i1, l);            
	            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
	            BlockState blockstateDown = chunkIn.getBlockState(blockpos$mutableblockpos.down());
	            boolean setTop = true ;
	            boolean setBottom = true ;
	            
	        		
	        		if (blockstateCur == Blocks.WATER.getDefaultState() || blockstateCur == Blocks.AIR.getDefaultState()) {
	        			
	        			maxH = Math.max(maxH, i1) ; 

	        			h = maxH ;

	        			

	        			
	        			int fhx = i1 + h ; 
	        			
	        			for(int i2 = 0 ; i2 <= h ; i2++) {
	        				
	        				int hx = i2 + i1;
	        					        				
	        				blockstate = stone ; 
	        				
	        				if(i2 == h) {
	        					if (hx >= sandLevelBottom && hx <= sandLevelTop) {
	        						blockstate = whitesand ;	        						
	        					} else if (hx > sandLevelTop && hx < moutainLevelBottom){
	        						blockstate = grass ; 
	        					}
	        				} else {
	        					if (fhx >= sandLevelBottom && fhx <= sandLevelTop && hx >= sandLevelBottom) {
	        						blockstate = whitesand ;	        							        						
	        					}
	        				}
	        				
	        	            blockpos$mutableblockpos.setPos(k, i2 + i1, l);    
		                	chunkIn.setBlockState(blockpos$mutableblockpos, blockstate, false);        				
	        				
		                	if(hx < seaLevel) {
		        				if(setBottom && random.nextInt(15) == 0) {
		        					if(k-1 >= 0) {
		        						int nx = random.nextInt(h-6) - i2 ; 
		        						if(nx > 0)
		        							addExtraColumn(chunkIn, k-1, hx - random.nextInt(5), l, Blocks.DARK_OAK_LOG.getDefaultState(), Blocks.DARK_OAK_LOG.getDefaultState(), random.nextInt(nx), moutainLevelBottom) ;         		        								        						
		        						
		        					}
		        					setBottom = false ; 
		        				}
		                	} else {
		        				if(setTop && random.nextInt(15) == 0) {
		        					if(k-1 >= 0) {
		        						int nx = random.nextInt(h-6) - i2 ; 
		        						if(nx > 0)
		        							addExtraColumn(chunkIn, k-1, hx - random.nextInt(5), l, Blocks.ACACIA_PLANKS.getDefaultState(), Blocks.ACACIA_PLANKS.getDefaultState(), random.nextInt(nx), moutainLevelBottom) ;         		        								        						
		        					}
		        					setTop = false ; 
		        				}
		                	}

		        			/*
		        			//Add top
		                	if(hx < seaLevel) {
		        				if(setBottom && random.nextInt(30) == 0) {
		    	        			//other direction block ?
		        					
		        					if(k-1 >= 0) {
		        						int nx = random.nextInt(h-6-i2) ; 
		        						if(nx > 0)
		        							addExtraColumn(chunkIn, k-1, hx + random.nextInt(5) + 1, l, Blocks.DARK_OAK_LOG.getDefaultState(), Blocks.DARK_OAK_LOG.getDefaultState(), random.nextInt(h-6-i2), moutainLevelBottom) ;         		        						
		        					}
		    	        			setBottom = false ; 
		        				}		                		
		                	} else {
			        			//Add bottom
		        				if(setTop && random.nextInt(30)== 0) {
		    	        			//other direction block ?
		        					if(k-1 >= 0) {
		        						int nx = random.nextInt(h-6-i2) ; 
		        						if(nx > 0)
		        							addExtraColumn(chunkIn, k-1, hx - random.nextInt(5), l, Blocks.ACACIA_PLANKS.getDefaultState(), Blocks.ACACIA_PLANKS.getDefaultState(), nx, moutainLevelBottom) ;         							        						
		        					}
		    	        			setTop = false ; 
		        				}		                		
		                	}
		                	*/
		        				

	        			}
	        			


	        			
	        			break ; 
	            	}
	            //}
	        }
		}
		else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);			
		}
		
		
		//SurfaceBuilderInit.TROPICAL.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG);

		

	}
	
	
	private void addExtraColumn(IChunk chunkIn, int x, int y, int z, BlockState stone, BlockState grass, int n, int moutainLevelBottom) {
		
		if(canAdd(chunkIn, x, y, z, n) == false)
			return ; 
		
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

		
		for(int y2 = 0 ; y2 <= n ; y2++) {
	        int y3 = y2+y ; 

	        blockpos$mutableblockpos.setPos(x, y3, z);   
	        
	        
	        if(y2 == n) {
	        	if(y3 < moutainLevelBottom) {
	        		chunkIn.setBlockState(blockpos$mutableblockpos, grass, false);
	        	} else { 
	        		chunkIn.setBlockState(blockpos$mutableblockpos, stone, false);	
	        	}
	        } else {
	        	chunkIn.setBlockState(blockpos$mutableblockpos, stone, false);        					        	
	        }
	        
	        
		}
	}
	
	private boolean canAdd(IChunk chunkIn, int x, int y, int z, int n) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        blockpos$mutableblockpos.setPos(x, y, z);   
        BlockState blockstate = chunkIn.getBlockState(blockpos$mutableblockpos.down());

        if (blockstate != Blocks.AIR.getDefaultState()) {
        	return false ;
        }

        blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
        
        for(int y2 = 1 ; y2 <= n ; y2++) {
            
	        if (blockstate != Blocks.AIR.getDefaultState()) {
	        	return false ;
	        }
            
	        blockpos$mutableblockpos.setPos(x, y+y2, z);   
            blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
		}
		
		return true ; 
	}
	
	

}
