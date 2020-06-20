package com.deedllit.yggdrasil.common.biome;

/*
 * Strongly inspired by The-MidNight Mod (https://github.com/Cryptic-Mushroom/The-Midnight)  
 */

public class BiomeLayers<T> {

	public final BiomeLayer<T> noise;
    public final BiomeLayer<T> block;

    BiomeLayers(BiomeLayer<T> noise, BiomeLayer<T> block) {
        this.noise = noise;
        this.block = block;
    }	
    
    
}
