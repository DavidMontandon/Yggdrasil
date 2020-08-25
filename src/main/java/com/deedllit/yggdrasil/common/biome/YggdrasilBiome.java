package com.deedllit.yggdrasil.common.biome;

import net.minecraft.world.biome.Biome;

/*
 * Strongly inspirated by Biomes O' Plenty : https://github.com/Glitchfiend/BiomesOPlenty
 */


public class YggdrasilBiome extends Biome {

	public boolean canSpawnInBiome;
	
	protected YggdrasilBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;	
	}

		
}
