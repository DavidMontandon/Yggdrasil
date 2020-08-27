package com.deedllit.yggdrasil.world.dimensions.midgard.config;

import java.util.Set;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;

public class MidgardBiomeProvider extends BiomeProvider {

	protected MidgardBiomeProvider(Set<Biome> biomesIn) {
		super(biomesIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	private final Layer genBiomes;
	
	protected MidgardBiomeProvider(Set<Biome> biomesIn) {
		super(biomesIn);
	}

	public MidgardBiomeProvider(World world) {
		this(world.getSeed(), world.getWorldInfo().getGenerator());
		MainBiomeLayer.setSeed(world.getSeed());
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.genBiomes.func_215738_a(x, z);
	}
*/
}
