package com.davidmontandon.yggdrasil.world.biome.general;

public class BiomeLayers<T> {
    public final BiomeLayer<T> noise;
    public final BiomeLayer<T> block;

    BiomeLayers(BiomeLayer<T> noise, BiomeLayer<T> block) {
        this.noise = noise;
        this.block = block;
    }
}
