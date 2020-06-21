package com.deedllit.yggdrasil.world.dimensions.nifelheim.generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.gen.noise.VoronoiGenerator;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;

public class NifelheimBiomeProvider extends BiomeProvider {

	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.NIFELHEIM_FROZEN_PLAIN_BIOME.get() );

	private VoronoiGenerator biomeNoise;
	double biomeSize = 32.0d;  
	
	public NifelheimBiomeProvider() {
		super(biomeList);
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) 155151 );
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {		
		return getBiome(new LinkedList<Biome>(biomeList),
				biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));

	}
	
	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}

}