package com.deedllit.midgard.world.dimension.midgard.generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardAddIslandLayer;
import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardDeepOceanLayer;
import com.deedllit.mythologycraft.world.gen.DefaultBiomesFactory;
import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.gen.noise.VoronoiGenerator;
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
import net.minecraft.world.gen.layer.OceanLayer;
import net.minecraft.world.gen.layer.RareBiomeLayer;
import net.minecraft.world.gen.layer.RemoveTooMuchOceanLayer;
import net.minecraft.world.gen.layer.RiverLayer;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.StartRiverLayer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.registries.ForgeRegistries;

public class MidgardBiomeProvider extends BiomeProvider {

	public static Biome[] dimensionBiomes = new Biome[] {
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_badlands_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_badlands_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_bamboo_jungle_biome")),
			ForgeRegistries.BIOMES
					.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_bamboo_jungle_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_beach_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_biome")),
			ForgeRegistries.BIOMES
					.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_cold_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_dark_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_dark_forest_hill_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_cold_ocean_biome")),
			ForgeRegistries.BIOMES
					.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_frozen_ocean_biome")),
			ForgeRegistries.BIOMES
					.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_luke_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_warm_ocean_biome")),

			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_frozen_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_luke_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_warm_ocean_biome")),

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
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":midgard_volcanic_island")) };

	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.VANILLA_BADLANDS_BIOME.get(),
			BiomeInit.VANILLA_BADLANDS_PLATEAU_BIOME.get(), 
			BiomeInit.VANILLA_BAMBOO_JUNGLE_BIOME.get(),
			BiomeInit.VANILLA_BAMBOO_JUNGLE_HILLS_BIOME.get(),
			BiomeInit.VANILLA_BEACH_BIOME.get(),
			BiomeInit.VANILLA_BIRCH_FOREST_BIOME.get(),
			BiomeInit.VANILLA_BIRCH_FOREST_HILLS_BIOME.get(),
			BiomeInit.VANILLA_COLD_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_DARK_FOREST_BIOME.get(),
			BiomeInit.VANILLA_DARK_FOREST_HILL_BIOME.get(),
			BiomeInit.VANILLA_DEEP_COLD_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_DEEP_FROZEN_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_DEEP_OCEAN_BIOME.get(), 
			BiomeInit.VANILLA_DEEP_WARM_OCEAN_BIOME.get(),
			
			BiomeInit.VANILLA_FROZEN_OCEAN_BIOME .get(),
			BiomeInit.VANILLA_LUKE_WARM_OCEAN_BIOME .get(),
			BiomeInit.VANILLA_OCEAN_BIOME .get(),
			BiomeInit.VANILLA_WARM_OCEAN_BIOME .get(),

			BiomeInit.VANILLA_SUNFLOWER_PLAINS_BIOME.get(), 
			BiomeInit.VANILLA_PLAINS_BIOME.get(),
			BiomeInit.VANILLA_RIVER_BIOME.get(),

			BiomeInit.MIDGARD_RAINBOW_PLAINS_BIOME.get(), BiomeInit.MIDGARD_IRON_WOOD_BIOME.get(),
			BiomeInit.MIDGARD_MANGROVE_BIOME.get(), BiomeInit.MIDGARD_MANGROVE_DRYER_BIOME.get(),
			BiomeInit.MIDGARD_CHARPARRAL_TROPICAL_BIOME.get(), BiomeInit.MIDGARD_ALPINE_TUNDRA_BIOME.get(),
			BiomeInit.MIDGARD_TROPICAL_BEACH_BIOME.get(), BiomeInit.MIDGARD_RAINBOW_MOUTAIN_BIOME.get(),
			BiomeInit.MIDGARD_TEAK_FOREST_BIOME.get(), BiomeInit.MIDGARD_THOUSAND_LAKES_BIOME.get(),
			BiomeInit.MIDGARD_TROPICAL_ISLAND_BIOME.get(), BiomeInit.MIDGARD_VOLCANIC_ISLAND_BIOME.get());

	private final Layer genBiomes;
	private final Biome[] biomes;
	double biomeSize = 32.0d;
	private VoronoiGenerator biomeNoise;

	public MidgardBiomeProvider(World world) {
		super(biomeList);

		Layer[] aLayer = buildWorld(world.getSeed());

		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;

		/*
		 * super(biomeList);
		 * 
		 * this.genBiomes = null; this.biomes = null;
		 * 
		 * //Layer[] aLayer =
		 * DefaultBiomesFactory.getDefaultBiomesFactory(world.getSeed(),
		 * dimensionBiomes, 6, 1) ;
		 * 
		 * //Layer[] aLayer = buildWorld(world.getSeed()) ;
		 * 
		 * 
		 * //this.genBiomes = aLayer[0]; //this.biomes = dimensionBiomes;
		 * 
		 * this.biomeNoise = new VoronoiGenerator(); this.biomeNoise.setSeed((int)
		 * 122121 );
		 */
	}

	private Layer[] buildWorld(long seed) {
		
        int biomeSize = 4;
        int riverSize = 1;
		
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);
		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> landSeaFactory = (new BiomeLayerUtils()).apply(contextFactory.apply(200), parentLayer);

		//LAND AND SEA
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1000L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1001L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1002L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);
		landSeaFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

		landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
		landSeaFactory = MidgardDeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
				
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), landSeaFactory);
		return new Layer[] { new Layer(landSeaFactory), new Layer(voronoizoom) };
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return this.genBiomes.func_215738_a(x, z);
	}

	class BiomeLayerUtils implements IC0Transformer {
		@Override
		public int apply(INoiseRandom context, int value) {
			return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
		}

	}

}