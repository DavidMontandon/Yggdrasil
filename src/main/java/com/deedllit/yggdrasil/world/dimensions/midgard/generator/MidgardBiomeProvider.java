package com.deedllit.yggdrasil.world.dimensions.midgard.generator;

import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.mythologycraft.world.gen.DefaultBiomesFactory;
import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddBambooForestLayer;
import net.minecraft.world.gen.layer.AddIslandLayer;
import net.minecraft.world.gen.layer.AddMushroomIslandLayer;
import net.minecraft.world.gen.layer.DeepOceanLayer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.RareBiomeLayer;
import net.minecraft.world.gen.layer.RemoveTooMuchOceanLayer;
import net.minecraft.world.gen.layer.RiverLayer;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.StartRiverLayer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.registries.ForgeRegistries;

public class MidgardBiomeProvider extends BiomeProvider {


	public static Biome[] dimensionBiomes = new Biome[]{
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_badlands_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_badlands_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_bamboo_jungle_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_bamboo_jungle_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_beach_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_cold_ocean_biome")),

			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_sunflower_plains_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_river_biome")),
			
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_rainbow_plains")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_iron_wood")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_mangrove")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_mangrove_dryer")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_charparral_tropical")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_alpine_tundra")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_tropical_beach")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_rainbow_moutain")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_teak_forest")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_thousand_lakes")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_tropical_island")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_volcanic_island"))
			} ;
	
	
	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.VANILLA_BADLANDS_BIOME.get(),
			BiomeInit.VANILLA_BADLANDS_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_BAMBOO_JUNGLE_BIOME.get(),
			BiomeInit.VANILLA_BAMBOO_JUNGLE_HILLS_BIOME.get(),
			BiomeInit.VANILLA_BEACH_BIOME.get(),
			BiomeInit.VANILLA_BIRCH_FOREST_BIOME.get(),
			BiomeInit.VANILLA_BIRCH_FOREST_HILLS_BIOME.get(),
			BiomeInit.VANILLA_COLD_OCEAN_BIOME.get(),

			BiomeInit.VANILLA_SUNFLOWER_PLAINS_BIOME.get(),
			BiomeInit.VANILLA_PLAINS_BIOME.get(),
			BiomeInit.VANILLA_RIVER_BIOME.get(),
			
			BiomeInit.MIDGARD_RAINBOW_PLAINS_BIOME.get(),
			BiomeInit.MIDGARD_IRON_WOOD_BIOME.get(), 
			BiomeInit.MIDGARD_MANGROVE_BIOME.get(),
			BiomeInit.MIDGARD_MANGROVE_DRYER_BIOME.get(),		
			BiomeInit.MIDGARD_CHARPARRAL_TROPICAL_BIOME.get(),
			BiomeInit.MIDGARD_ALPINE_TUNDRA_BIOME.get(),
			BiomeInit.MIDGARD_TROPICAL_BEACH_BIOME.get(),			
			BiomeInit.MIDGARD_RAINBOW_MOUTAIN_BIOME.get(),			
			BiomeInit.MIDGARD_TEAK_FOREST_BIOME.get(),			
			BiomeInit.MIDGARD_THOUSAND_LAKES_BIOME.get(),			
			BiomeInit.MIDGARD_TROPICAL_ISLAND_BIOME.get(),			
			BiomeInit.MIDGARD_VOLCANIC_ISLAND_BIOME.get()			
			);
	
	private final Layer genBiomes;
	private final Biome[] biomes;
	
	public MidgardBiomeProvider(World world) {
		super(biomeList);
		
		Layer[] aLayer = DefaultBiomesFactory.getDefaultBiomesFactory(world.getSeed(), dimensionBiomes, 6, 1) ; 
	
		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;

	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.genBiomes.func_215738_a(x, z);
	}
	
	
	

	
	
}