package com.davidmontandon.yggdrasil.world.biome.general;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;
import com.mojang.datafixers.Dynamic;

public class LayeredSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    private final int minSurfaceLayer;
    private final int maxSurfaceLayer;
    
    private int maxY = 255 ; 
    
    public LayeredSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> deserialize, int minSurfaceLayer, int maxSurfaceLayer) {
        super(deserialize);
        this.minSurfaceLayer = minSurfaceLayer;
        this.maxSurfaceLayer = maxSurfaceLayer;
    }
	
    public LayeredSurfaceBuilder withMaxY(int maxY) {
        this.maxY = maxY;
        return this;
    }

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
	}
    
}
