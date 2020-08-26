package com.deedllit.yggdrasil.world.dimensions.vanilla.config;

import java.util.Set;

import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.gen.noise.VoronoiGenerator;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.layer.Layer;

public class VanillaMidgardBiomeProvider extends OverworldBiomeProvider {

	private final Layer noiseBiomeLayer;
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.ASGARD_PLAINS_BIOME.get(),		
			BiomeInit.ASGARD_LAKES_BIOME.get(),
			BiomeInit.ASGARD_DESERT_BIOME.get(),
			BiomeInit.ASGARD_PINK_MANGENTA_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_MOUTAINS_BIOME.get(),
			BiomeInit.ASGARD_SUNFLOWER_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_FOREST_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_BIRCH_FOREST_BIOME.get(),
			BiomeInit.ASGARD_OAK_FOREST_BIOME.get());

	private VoronoiGenerator biomeNoise;
	double biomeSize = 32.0d;  	
	
	public VanillaMidgardBiomeProvider(OverworldBiomeProviderSettings settingsProvider) {
		super(settingsProvider);

		this.noiseBiomeLayer = null;
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return super.getNoiseBiome(x, y, z);
	}


}
