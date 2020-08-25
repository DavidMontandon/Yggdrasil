package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FloatingIslandMoutainSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	private BlockState top  ; 
	private BlockState under  ; 
	
	public FloatingIslandMoutainSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		top = config.getTop() ; 
		under = config.getUnder() ; 
		
				
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        int k = x & 15;
        int l = z & 15;
        boolean found = false ;  
        
		int n = (int) (noise / 0.1) ; 
		
		if(n < 0) {
			n *= -1 ; 
			n += 40 ; 			
		}
		
        for(int i1 = 5; i1 <= 100; i1++) {
            blockpos$mutableblockpos.setPos(k, i1, l);            
            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
                    		
    		if (blockstateCur == Blocks.WATER.getDefaultState() || blockstateCur == Blocks.AIR.getDefaultState()) {
   				if(found) {
   	    			addExtraColumn(chunkIn, x,i1, z,n) ;  
   	    			addExtraFourColumns(chunkIn, x,i1, z,n) ;
   	    			break ; 
   				}
    		} else {
    			found = true ; 
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
				
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
                
		for(int y2 = 0 ; y2 <= n ; y2++) {
	        int y3 = y2+y ; 
	        
	        blockpos$mutableblockpos.setPos(x, y3, z);  
	        
	        if (y3 < 120)
	        	chunkIn.setBlockState(blockpos$mutableblockpos, top, false);        				
	        else
	        	chunkIn.setBlockState(blockpos$mutableblockpos, under, false);        				
	        	

	        
		}
	}
	
}
