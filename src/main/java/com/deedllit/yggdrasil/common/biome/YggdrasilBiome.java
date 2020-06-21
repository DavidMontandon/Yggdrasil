package com.deedllit.yggdrasil.common.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Carving;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;

public class YggdrasilBiome extends Biome {

	public boolean canSpawnInBiome;
	
	protected YggdrasilBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;
		
		
	}


	
	
}
