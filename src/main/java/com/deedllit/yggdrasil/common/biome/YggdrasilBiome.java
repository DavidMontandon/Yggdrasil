package com.deedllit.yggdrasil.common.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Carving;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;

public class YggdrasilBiome extends Biome {

	public boolean canSpawnInBiome;
	private int spwanWeight; 
	
	protected YggdrasilBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;	
		this.spwanWeight = 1 ; 
	}

	public void setSpwanWeight(int spwanWeight) {
		this.spwanWeight = spwanWeight ; 
	}
	
	public int getSpwanWeight() {
		return this.spwanWeight ; 
	}
		
}
