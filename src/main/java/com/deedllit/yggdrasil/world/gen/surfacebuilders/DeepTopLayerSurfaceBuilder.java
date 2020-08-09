package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.yggdrasil.Yggdrasil;
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
			
			int v = 2 ;
			
			if(noise <= 0.5D) {
				maxH = 12  ; 
				v = 1 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 						
			} else if(noise <= 1.0D) {
				maxH = 14  ; 
				v = 1 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 			
			} else if(noise <= 1.5D) {
				maxH = 15  ; 
				v = 2 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 			
			} else if(noise <= 2.0D) {
				maxH = 17  ; 
				v = 2 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 
			} else if(noise <= 2.6D) {
				maxH = 18 ; 
				v = 2 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 
			} else if(noise <= 3.2D) {
				maxH = 24  ; 
				v = 4 ; 
				//stone =  Blocks.STONE.getDefaultState() ;
			} else if(noise <= 3.5D) {
				maxH = 38  ; 
				v = 5 ; 
				//stone =  Blocks.STONE.getDefaultState() ; 
			} else {
				maxH = 41  ; 
				//stone =  Blocks.STONE.getDefaultState() ; 					
			}

			maxH += random.nextInt(v);
			
			
			BlockState top = config.getTop() ; 
			BlockState middle = config.getUnder() ; 
			BlockState bottom = config.getUnderWaterMaterial() ; 
			
	        BlockState blockstate = top;
	        BlockState blockstate1 = middle;
	        //BlockState stone =  Blocks.STONE.getDefaultState() ; 
	        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	        int i = -1;
	        //int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
	        //boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;        
	        int k = x & 15;
	        int l = z & 15;

	        int h ; 
	        
	        for(int i1 = 5; i1 <= seaLevel; i1++) {
	            blockpos$mutableblockpos.setPos(k, i1, l);            
	            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
	            BlockState blockstateDown = chunkIn.getBlockState(blockpos$mutableblockpos.down());
	                        
	        	//if(j > 1.7 && flag) {	
	            
	        		//Yggdrasil.LOGGER.info(blockstateCur.toString());
	        		
	        		
	        		
	        		if (blockstateCur == Blocks.WATER.getDefaultState() || blockstateCur == Blocks.AIR.getDefaultState()) {

	        			maxH = Math.max(maxH, i1) ; 

	        			/*
	        			h = random.nextInt(2) ; 
	        			h = maxH + h ; 
	        			for(int i2 = i1 ; i2 < h ; i2++) {
	        	            blockpos$mutableblockpos.setPos(k, i2, l);            
	                		chunkIn.setBlockState(blockpos$mutableblockpos, stone, false);        				
	        				
	        			}
	        			
	        			*/
	        			h = maxH ;
	        			
	        			for(int i2 = 0 ; i2 <= h ; i2++) {
	        				
	        				int hx = i2 + i1;
	        				
	        	            blockpos$mutableblockpos.setPos(k, i2 + i1, l);    
		                	chunkIn.setBlockState(blockpos$mutableblockpos, stone, false);        				
	        				
	        			}
	        			
	        			break ; 
	            	}
	            //}
	        }
		}
		/*else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);			
		}
		*/
		
		SurfaceBuilderInit.TROPICAL.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG);

		

	}

}
