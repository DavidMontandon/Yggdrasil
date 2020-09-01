package com.deedllit.yggdrasil.common.biome;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.util.registry.Registry;

public class MythologycraftBiome extends Biome {

	public boolean canSpawnInBiome;
	protected Map<MythologycraftClimates, Integer> weightMap = new HashMap<MythologycraftClimates, Integer>();
	@SuppressWarnings("deprecation")
	public int beachBiomeId = Registry.BIOME.getId(Biomes.BEACH);
	@SuppressWarnings("deprecation")
	public int riverBiomeId = Registry.BIOME.getId(Biomes.RIVER);
	
	protected MythologycraftBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;	
	}

    public void addWeight(MythologycraftClimates climate, int weight) {
        this.weightMap.put(climate, weight);
    }
	
    @SuppressWarnings("deprecation")
	public void setRiverBiome(Biome biome) {
        if (biome != null)
            this.riverBiomeId = Registry.BIOME.getId(biome);
        else
            this.riverBiomeId = -1;
    }	

    @SuppressWarnings("deprecation")
	public void setBeachBiome(Biome biome) {
        if (biome != null)
            this.beachBiomeId = Registry.BIOME.getId(biome);
        else
            this.beachBiomeId = -1;
    }
    
}
