package com.davidmontandon.yggdrasil.world.muspelheim.biomes;

import com.davidmontandon.yggdrasil.world.muspelheim.config.MuspelheimDefaultBiomeFeatures;

import net.minecraft.world.biome.Biome;

public class MuspelheimOceanBiome extends Biome {

	public MuspelheimOceanBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		
		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);		
	}
	
}
