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

	private BlockState grass ; 
	private BlockState stone ; 
	private BlockState defaultFluid ; 
	private BlockState whitesand ; 
	private int sandLevelBottom ; 
	private int sandLevelTop ; 
	private int moutainLevelBottom ; 
	private int seaLevel ;
	
	public DeepTopLayerSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		//SurfaceBuilderConfig config2 = SurfaceBuilder.GRASS_DIRT_SAND_CONFIG ;
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);			

		
		int maxH ; 
		
		if (noise >= 0D) {

			this.seaLevel = seaLevel ;
			this.defaultFluid = defaultFluid ;  
			stone =  Blocks.STONE.getDefaultState() ; 
			grass =  Blocks.GRASS_BLOCK.getDefaultState() ; 
			whitesand =  BlockInit.WHITE_SAND.get().getDefaultState() ; 			
						
	        BlockState blockstate = config.getTop() ; ;
	        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	        int k = x & 15;
	        int l = z & 15;

	        sandLevelBottom = seaLevel -4 ;
	        sandLevelTop = seaLevel +1 ;
	        moutainLevelBottom = 105 ; 
	        
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
			} else if(noise <= 0.75D) {
				maxH = 13  ; 
				v = 1 ; 
			} else if(noise <= 1.0D) {
				maxH = 14  ; 
				v = 1 ; 
			} else if(noise <= 1.25D) {
				maxH = 15  ; 
				v = 2 ; 
			} else if(noise <= 1.5D) {
				maxH = 16  ; 
				v = 2 ; 
			} else if(noise <= 1.75D) {
				maxH = 17  ; 
				v = 2 ; 
			} else if(noise <= 2.0D) {
				maxH = 18  ; 
				v = 2 ; 
			} else if(noise <= 2.25D) {
				maxH = 19  ; 
				v = 2 ; 
			} else if(noise <= 2.50D) {
				maxH = 20  ; 
				v = 2 ; 
			} else if(noise <= 2.75D) {
				maxH = 21 ; 
				v = 2 ; 
			} else if(noise <= 3.0D) {
				maxH = 22 ; 
				v = 2 ; 
			} else if(noise <= 3.25D) {
				maxH = 24  ; 
				v = 4 ; 
			} else if(noise <= 3.50D) {
				maxH = 38  ; 
				v = 5 ; 
			} else if(noise <= 3.75D) {
				maxH = 40  ; 
				v = 5 ; 
			} else if(noise <= 4.0D) {
				maxH = 48  ; 
				v = 5 ; 
			} else {
				maxH = 55  ; 
				v = 2 ; 
			}

			maxH += random.nextInt(v);
			
			
			
			
	        
	        for(int i1 = 5; i1 <= seaLevel; i1++) {
	            blockpos$mutableblockpos.setPos(k, i1, l);            
	            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
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
	        				if(setBottom && random.nextInt(5) == 0) {
        						int nx = random.nextInt(h - i2 + 1)  ; 
        						if(nx > 0)
        							addExtraFourColumns(chunkIn, k, hx, l, nx) ;         		        								        						
	        						
	        					setBottom = false ; 
	        				}
	                	} else {
	                		
	        				if(setTop && random.nextInt(5) == 0) {
        						int nx = random.nextInt(h - i2 + 1)  ; 
        						if(nx > 0)
        							addExtraFourColumns(chunkIn, k, hx - random.nextInt(2) - 3, l, nx) ;         		        								        						

        						setTop = false ; 
	        				}
	        				
	                	}	        				

        			}
        			


        			
        			break ; 
            	}
	        }
		}

		

	}
	
	private void addExtraFourColumns(IChunk chunkIn, int x, int y, int z, int n ) {
		
		if(x-1 >= 0)
			this.addExtraColumn(chunkIn, x-1, y, z, n) ; 

		if(x+1 <= 15)
			this.addExtraColumn(chunkIn, x+1, y, z, n) ; 

		if(z-1 >= 0)
			this.addExtraColumn(chunkIn, x, y, z-1, n) ; 

		if(z+1 <= 15)
			this.addExtraColumn(chunkIn, x, y, z+1, n) ; 

	}
	
		
	private void addExtraColumn(IChunk chunkIn, int x, int y, int z, int n ) {
				
		if(canAdd(chunkIn, x, y, z, n) == false)
			return ; 		
		
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        BlockState blockstate ; 
        
        int yh = y + n ; 
        
		for(int y2 = 0 ; y2 <= n ; y2++) {
	        int y3 = y2+y ; 

	        blockstate = stone ; 
	        if(y2 > 0) {
				if(y2 == n) {
					if (y3 >= sandLevelBottom && y3 <= sandLevelTop) {
						blockstate = whitesand ;	        			
					} else if (y3 > sandLevelTop && y3 < moutainLevelBottom){
						blockstate = grass ; 
					}
				} else {
					if (y3 >= sandLevelBottom && y3 <= sandLevelTop && yh <= sandLevelTop) {
						blockstate = whitesand ;	        			
					}
				}	        	
	        }
	        
	        blockpos$mutableblockpos.setPos(x, y3, z);  
        	chunkIn.setBlockState(blockpos$mutableblockpos, blockstate, false);        				

	        
		}
	}
	
	private boolean canAdd(IChunk chunkIn, int x, int y, int z, int n) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        blockpos$mutableblockpos.setPos(x, y, z);   
        BlockState blockstate = chunkIn.getBlockState(blockpos$mutableblockpos.down());

        if (blockstate != Blocks.AIR.getDefaultState() && blockstate != defaultFluid) {
        	return false ;
        }

        blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
        
        for(int y2 = 1 ; y2 <= n ; y2++) {
            
	        if (blockstate != Blocks.AIR.getDefaultState() && blockstate != defaultFluid) {
	        	return false ;
	        }
            
	        blockpos$mutableblockpos.setPos(x, y+y2, z);   
            blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
		}
		
		return true ; 
	}
	
	

}
