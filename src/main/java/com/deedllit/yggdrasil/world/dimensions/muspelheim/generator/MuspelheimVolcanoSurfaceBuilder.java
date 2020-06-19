package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator;

import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class MuspelheimVolcanoSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public MuspelheimVolcanoSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		
		if (noise > 2.5F) {
			SurfaceBuilder.DEFAULT.buildSurface( random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, 
					MuspelheimDefaultBiomeFeatures.MAGMA_SURFACE ) ; 
		} else {
			MuspelheimDefaultBiomeFeatures.VOLCANO_TOP_LAYER_SURFACE_BUILDER.buildSurface( random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, 
					MuspelheimDefaultBiomeFeatures.MAGMA_SURFACE2 ) ; 

		}
	}
	
}