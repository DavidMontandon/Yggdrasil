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

public class HolesSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public HolesSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
	    int i = x & 15;
	    int j = z & 15;
	    
	   // int k = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D); 
	    
	    BlockState blockstate = Blocks.STONE.getDefaultState() ; 
	    BlockState blockstate1 = biomeIn.getSurfaceBuilderConfig().getUnder();

	    
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        if (flag) {
		    for(int j1 = startHeight; j1 >= 0; --j1) {
		    			    	
	            //BlockState blockstate3;
	            if (j1 >= 65 && j1 <= 70) {
            	   blockstate = Blocks.AIR.getDefaultState() ; 
	            }
	
	            chunkIn.setBlockState(blockpos$mutable, blockstate, false);
		    }
	    }

	    
		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);		
	}

}
