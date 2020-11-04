package com.deedllit.midgard.world.dimension.midgard.generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.*;
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
import net.minecraft.world.gen.layer.AddSnowLayer;
import net.minecraft.world.gen.layer.DeepOceanLayer;
import net.minecraft.world.gen.layer.EdgeLayer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.MixRiverLayer;
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
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_bamboo_jungle_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_beach_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_birch_forest_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_cold_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_dark_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_dark_forest_hill_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_cold_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_frozen_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_luke_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_deep_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_desert_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_desert_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_desert_lakes_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_eroded_badlands_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_flower_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_forest_biome")),			
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_frozen_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_frozen_river_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_giant_spruce_taiga_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_giant_spruce_taiga_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_giant_tree_taiga_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_giant_tree_taiga_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_gravelly_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_jungle_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_jungle_edge_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_jungle_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_luke_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_modified_bandlands_plateau_biome")),

			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_modified_gravelly_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_modified_jungle_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_modified_jungle_edge_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_modified_wooded_badlands_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_mountain_edge_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_mushroom_fields_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_mushroom_field_shore_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_river_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_savanna_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_savanna_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_shattered_savanna_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_shattered_savanna_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_beach_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_taiga_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_taiga_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_taiga_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_snowy_tundra_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_stone_shore_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_sunflower_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_swamp_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_swamp_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_taiga_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_taiga_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_taiga_mountains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_tall_birch_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_tall_birch_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_warm_ocean_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_wooded_badlands_plateau_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_wooded_hills_biome")),			
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":vanilla_wooded_mountains_biome")),

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
			BiomeInit.VANILLA_DESERT_BIOME.get(),
			BiomeInit.VANILLA_DESERT_HILLS_BIOME.get(),
			BiomeInit.VANILLA_DESERT_LAKES_BIOME.get(),
			BiomeInit.VANILLA_ERODED_BADLANDS_BIOME.get(),
			BiomeInit.VANILLA_FLOWER_FOREST_BIOME.get(),
			BiomeInit.VANILLA_FOREST_BIOME.get(),
			BiomeInit.VANILLA_FROZEN_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_FROZEN_RIVER_BIOME.get(),
			BiomeInit.VANILLA_GIANT_SPRUCE_TAIGA_BIOME.get(),
			BiomeInit.VANILLA_GIANT_SPRUCE_TAIGA_HILLS_BIOME.get(),
			BiomeInit.VANILLA_GIANT_TREE_TAIGA_BIOME.get(),
			BiomeInit.VANILLA_GIANT_TREE_TAIGA_HILLS_BIOME.get(),
			BiomeInit.VANILLA_GRAVELLY_MOUNTAINS_BIOME.get(),
			BiomeInit.VANILLA_JUNGLE_BIOME.get(),
			BiomeInit.VANILLA_JUNGLE_EDGE_BIOME.get(),
			BiomeInit.VANILLA_JUNGLE_HILLS_BIOME.get(),
			BiomeInit.VANILLA_LUKE_WARM_OCEAN_BIOME .get(),
			BiomeInit.VANILLA_MODIFIED_BADLANDS_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_MODIFIED_GRAVELLY_MOUNTAINS_BIOME.get(),
			BiomeInit.VANILLA_MODIFIED_JUNGLE_BIOME.get(),
			BiomeInit.VANILLA_MODIFIED_JUNGLE_EDGE_BIOME.get(),
			BiomeInit.VANILLA_MODIFIED_WOODED_BADLANDS_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_MOUNTAINS_BIOME.get(),
			BiomeInit.VANILLA_MOUNTAIN_EDGE_BIOME.get(),
			BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get(),
			BiomeInit.VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get(),
			BiomeInit.VANILLA_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_PLAINS_BIOME.get(),
			BiomeInit.VANILLA_RIVER_BIOME.get(),
			BiomeInit.VANILLA_SAVANNA_BIOME.get(),
			BiomeInit.VANILLA_SAVANNA_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_SHATTERED_SAVANNA_BIOME.get(),
			BiomeInit.VANILLA_SHATTERED_SAVANNA_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_BEACH_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_MOUNTAINS_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_TAIGA_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_TAIGA_HILLS_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_TAIGA_MOUNTAINS_BIOME.get(),
			BiomeInit.VANILLA_SNOWY_TUNDRA_BIOME.get(),
			BiomeInit.VANILLA_STONE_SHORE_BIOME.get(), 
			BiomeInit.VANILLA_SUNFLOWER_PLAINS_BIOME.get(), 
			BiomeInit.VANILLA_SWAMP_BIOME.get(), 
			BiomeInit.VANILLA_SWAMP_HILLS_BIOME.get(), 
			BiomeInit.VANILLA_TAIGA_BIOME.get(),
			BiomeInit.VANILLA_TAIGA_HILLS_BIOME.get(),
			BiomeInit.VANILLA_TAIGA_MOUNTAIN_BIOME.get(),
			BiomeInit.VANILLA_TALL_BIRCH_FOREST_BIOME.get(),
			BiomeInit.VANILLA_TALL_BIRCH_HILLS_BIOME.get(),
			BiomeInit.VANILLA_WARM_OCEAN_BIOME.get(),
			BiomeInit.VANILLA_WOODED_BADLANDS_PLATEAU_BIOME.get(),
			BiomeInit.VANILLA_WOODED_HILLS_BIOME.get(),
			BiomeInit.VANILLA_WOODED_MOUNTAINS_BIOME.get(),

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
			BiomeInit.MIDGARD_VOLCANIC_ISLAND_BIOME.get());

	private final Layer genBiomes;
	double biomeSize = 32.0d;

	public MidgardBiomeProvider(World world) {
		super(biomeList);

		Layer[] aLayer = buildWorld(world);
		this.genBiomes = aLayer[0];
		
		//this.genBiomes = buildWorld2(world);
		
	}

	private Layer buildWorld2(World world) {
		return MidgardLayerUtil.createWorld(world) ; 
	}

		
	private Layer[] buildWorld(World world) {
		
		
		long seed = world.getSeed() ; 
        int biomeSize = 4;
        int riverSize = 1;
		
        //LayerUtil
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);
		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> landSeaFactory = (new BiomeLayerUtils()).apply(contextFactory.apply(200), parentLayer);

		//LAND AND SEA 
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);	    
		landSeaFactory = MidgardRemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
		
		
		/*
		//OCEANS
		IAreaFactory<LazyArea> oceanBiomeFactory = OceanLayer.INSTANCE.apply(contextFactory.apply(2L));
		oceanBiomeFactory = MidgardLayerUtil.repeat(2001L, ZoomLayer.NORMAL, oceanBiomeFactory, 6, contextFactory);

	
		//ISLAND AND DEEP OCEAN
		landSeaFactory = MidgardAddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
		landSeaFactory = MidgardDeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
				
		
		//RIVER
		IAreaFactory<LazyArea> riverAndSubBiomesInitFactory = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), landSeaFactory);
		riverAndSubBiomesInitFactory = MidgardLayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 2, contextFactory);
		*/
	    //IAreaFactory<LazyArea> lvt_7_1_ = MidgardLayerUtil.repeat(1000L, ZoomLayer.NORMAL, landSeaFactory, 0, contextFactory);
	    //lvt_7_1_ = MidgardStartRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(100L), lvt_7_1_);
	    //IAreaFactory<LazyArea> lvt_8_1_ = world.getWorldType().getBiomeLayer(landSeaFactory, riverSize, contextFactory);

		
		
		landSeaFactory = MidgardBiomeEdgeLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory)  ; 		
		//landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2004L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2004L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2005L), landSeaFactory);
		
		
		
		/*
		//Rivers
        IAreaFactory<LazyArea> riversFactory = MidgardLayerUtil.repeat(1000L, ZoomLayer.NORMAL, landSeaFactory, riverSize, contextFactory);
        riversFactory = MidgardRiverLayer.INSTANCE.apply(contextFactory.apply(1L), riversFactory);
        riversFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), riversFactory);
        landSeaFactory = MidgardMixRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(100L), landSeaFactory, riversFactory);
		 */

		//LAND AND SEA
		
		/*
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1000L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1001L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(1002L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);
		landSeaFactory = MidgardRemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);

	    //IAreaFactory<LazyArea> oceanFactory = MidgardOceanLayer.INSTANCE.apply(contextFactory.apply(2L));
	    //oceanFactory = MidgardLayerUtil.repeat(2001L, ZoomLayer.NORMAL, oceanFactory, 6, contextFactory) ;
	    //landSeaFactory = MidgardAddSnowLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);

		landSeaFactory = MidgardEdgeLayer.CoolWarm.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardEdgeLayer.HeatIce.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
		landSeaFactory = MidgardEdgeLayer.Special.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);

		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
		landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
		landSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

		landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
		landSeaFactory = MidgardDeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
		*/
		
		
		
		
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10L), landSeaFactory);
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