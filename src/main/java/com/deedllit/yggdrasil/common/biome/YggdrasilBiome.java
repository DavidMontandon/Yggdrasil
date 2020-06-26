package com.deedllit.yggdrasil.common.biome;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

/*
 * Strongly inspirated by Biomes O' Plenty : https://github.com/Glitchfiend/BiomesOPlenty
 */


public class YggdrasilBiome extends Biome {

	public boolean canSpawnInBiome;
	public int beachBiomeId = Registry.BIOME.getId(Biomes.BEACH);
	public int riverBiomeId = Registry.BIOME.getId(Biomes.RIVER);
	
	protected YggdrasilBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;	
	}

		
}
