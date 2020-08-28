package com.deedllit.yggdrasil.world.feature.midgard.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MidgardIslandFeature extends Feature<NoFeatureConfig> {

	public MidgardIslandFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		if(rand.nextInt(100) > 40)
			return false ; 
		
		int h = rand.nextInt(80) + 65 ; 

		float f = (float)(rand.nextInt(5) + 7);
	    int c = 0 ; 
	     
	    
	    int mirror = rand.nextInt(25) ; 
	    /*
	    if(mirror == 0)
	    */
	    	mirror = rand.nextInt(3) ; 
	    	
	    BlockState[] bs = {Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()} ;
	    
	    for(int i = 0; f > 0.5F; --i) {

	        for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
	    		for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
	    			if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
	            	   
	    				if(c == 0) {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[0]);	    					
	    				}
	    				else if(c == 1) {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[1]);	
	    					if(c < mirror)
		    					this.setBlockState(worldIn, pos.add(j, i+h+c, k), bs[0]);	    					
	    				}
	    				else {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[2]);	    					
	    					if(c <= mirror)
		    					this.setBlockState(worldIn, pos.add(j, i+h+c, k), bs[0]);	    					
	    				}
	    			}
	            }
	        }

	        c++ ; 
	    	f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
	         
	    }

	    return true;

	}
}
	

 
