package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.SurfaceBuilderInit;
import com.deedllit.yggdrasil.world.gen.surfacebuilders.subbuilders.TropicalIsland;
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

		TropicalIsland tropicalIslandBuilder = new TropicalIsland() ;
		tropicalIslandBuilder.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config,
				-4, 1, 95,
				Blocks.STONE.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState(), BlockInit.WHITE_SAND.get().getDefaultState());

	}

	
	

}
