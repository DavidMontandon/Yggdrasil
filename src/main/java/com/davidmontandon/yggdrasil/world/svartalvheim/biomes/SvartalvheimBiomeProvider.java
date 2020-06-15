package com.davidmontandon.yggdrasil.world.svartalvheim.biomes;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.davidmontandon.yggdrasil.init.BiomeInit;
import com.davidmontandon.yggdrasil.util.noise.VoronoiGenerator;
import com.davidmontandon.yggdrasil.world.biome.general.BiomeLayers;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class SvartalvheimBiomeProvider extends BiomeProvider {

    private final BiomeLayers<Biome> layers;
    private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.SVARTALVHEIM_CAVERN_BIOME.get())  ;
	
	private VoronoiGenerator biomeNoise = new VoronoiGenerator() ;
	
	double biomeSize = 32.0d;  
	int seed = 548317 ; 
	
	
	public SvartalvheimBiomeProvider() {
		super(biomeList);
		
		this.biomeNoise.setSeed( seed );
		this.layers = null  ;
	}

    public SvartalvheimBiomeProvider(BiomeLayers<Biome> layers) {
        super(biomeList);

        this.biomeNoise.setSeed( seed );
        this.layers = layers;
    }
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {		
		
		if(this.layers != null) {
			return this.layers.noise.sample(x, z);
		} else {
			return getBiome(new LinkedList<Biome>(biomeList),
					this.biomeNoise.getValue((double) x / this.biomeSize, (double) y / this.biomeSize, (double) z / this.biomeSize));			
		}
		

	}
	
	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}

}