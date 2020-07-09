package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SpookySurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public SpookySurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232136_1_) {
		super(p_i232136_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		
		double n = Math.abs(noise*1.15) * -1 ; 
		
		
		
		if(noise > 2.5D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, z, x, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG);
		} else if(noise > 1.2D) { 
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, n, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.SAND_CONFIG);			
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG);			
		}

		
	}

}
