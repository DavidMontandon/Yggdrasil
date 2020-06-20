package com.deedllit.yggdrasil.common.biome;

import java.util.Set;

import net.minecraft.world.biome.Biome;

public class BiomesHolder {

	private Set<Biome> biomes = null; 
	
	public void addBiome(Biome biome) {
		biomes.add( biome ) ; 
	}
	
	public Set<Biome> getBiomes() {
		return biomes ;
	}
	
	
}
