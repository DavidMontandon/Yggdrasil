package com.davidmontandon.yggdrasil.world.dimensions.Muspelheim;

//import java.util.Random;
import java.util.Set;

import com.davidmontandon.yggdrasil.init.BiomeInit;
import com.google.common.collect.ImmutableSet;


import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
public class MuspelheimBiomeProvider extends BiomeProvider {

	//private Random rand;

	public MuspelheimBiomeProvider() {
		super(biomeList);
		//rand = new Random();
	}

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.MUSPELHEIM.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return BiomeInit.MUSPELHEIM.get();
	}

}