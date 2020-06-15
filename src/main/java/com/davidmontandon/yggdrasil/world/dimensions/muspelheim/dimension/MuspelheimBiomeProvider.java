package com.davidmontandon.yggdrasil.world.dimensions.muspelheim.dimension;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.davidmontandon.yggdrasil.init.BiomeInit;
import com.davidmontandon.yggdrasil.world.gen.noise.VoronoiGenerator;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class MuspelheimBiomeProvider extends BiomeProvider {


	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.MUSPELHEIM.get(), 
			BiomeInit.MUSPELHEIM_CLIFF_BIOME.get(), 
			BiomeInit.MUSPELHEIM_OCEAN_BIOME.get(), 
			BiomeInit.MUSPELHEIM_ASH_PLAINS.get(), 
			BiomeInit.MUSPELHEIM_PLAINS.get());

	private VoronoiGenerator biomeNoise;
	double biomeSize = 32.0d;  
	
	public MuspelheimBiomeProvider() {
		super(biomeList);
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) 122121 );
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