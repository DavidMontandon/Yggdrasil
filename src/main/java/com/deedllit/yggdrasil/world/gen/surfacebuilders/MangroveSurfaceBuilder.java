package com.deedllit.yggdrasil.world.gen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MangroveSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public MangroveSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232136_1_) {
		super(p_i232136_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		
		//double d = noise * random.nextDouble() ; 
		double d = biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.225D, false);
		
		if (d <= 0.0D) {
			int i = x & 15 ; 
			int j = z & 15 ; 
			
			BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
			
			for(int k = startHeight; k >= 0; --k) {
				blockpos$mutableblockpos.setPos(i, k, j);
				if (!chunkIn.getBlockState(blockpos$mutableblockpos).isAir()) {
					if (k == 62 && chunkIn.getBlockState(blockpos$mutableblockpos).getBlock() != defaultFluid.getBlock()) {
						chunkIn.setBlockState(blockpos$mutableblockpos, defaultFluid, false);
					}
					break;
				}
			}
			
		}
		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}


}
