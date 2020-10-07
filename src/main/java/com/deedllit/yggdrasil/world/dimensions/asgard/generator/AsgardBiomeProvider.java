package com.deedllit.yggdrasil.world.dimensions.asgard.generator;

import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
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

public class AsgardBiomeProvider extends BiomeProvider {


	public static Biome[] dimensionBiomes = new Biome[]{
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_small_islands_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_lakes_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_desert_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_pink_mangenta_plains_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_hills_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_moutains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_sunflower_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_forest_plains_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_oak_forest_biome")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_birch_forest_biome"))
			} ;
	
	
	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.ASGARD_SMALL_ISLANDS_BIOME.get(),
			BiomeInit.ASGARD_LAKES_BIOME.get(),
			BiomeInit.ASGARD_DESERT_BIOME.get(),
			BiomeInit.ASGARD_PINK_MANGENTA_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_HILLS_BIOME.get(), 
			BiomeInit.ASGARD_MOUTAINS_BIOME.get(),
			BiomeInit.ASGARD_PLAINS_BIOME.get(),		
			BiomeInit.ASGARD_SUNFLOWER_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_FOREST_PLAINS_BIOME.get(),
			BiomeInit.ASGARD_OAK_FOREST_BIOME.get(),			
			BiomeInit.ASGARD_BIRCH_FOREST_BIOME.get()
			);
	
	private final Layer genBiomes;
	private final Biome[] biomes;
	
	public AsgardBiomeProvider(World world) {
		super(biomeList);
		
		Layer[] aLayer = buildWorld(world.getSeed()) ; 
		
		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;

	}

	
	private Layer[] buildWorld(long seed) {
		/*
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);
		IAreaFactory<LazyArea> parentLayer = IslandLayer.INSTANCE.apply(contextFactory.apply(1));
		IAreaFactory<LazyArea> biomeLayer = (new BiomeLayerUtils()).apply(contextFactory.apply(200), parentLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
		biomeLayer = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);
		biomeLayer = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), biomeLayer);
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomeLayer);
		return new Layer[]{new Layer(biomeLayer), new Layer(voronoizoom)};
		*/
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);		
		
        int biomeSize = 4;
        int riverSize = 1;
		

        biomeSize = LayerUtil.getModdedBiomeSize(WorldType.DEFAULT, biomeSize);

        
        IAreaFactory<LazyArea> landSeaFactory = IslandLayer.INSTANCE.apply(contextFactory.apply(1L));

		//INIT
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);
        landSeaFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        //ISLAND AND OCEAN
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        
        //ALLOCATE BIOME
		IAreaFactory<LazyArea> biomesFactory = (new BiomeLayerUtils()).apply(contextFactory.apply(200), landSeaFactory);

		//SET RIVER AND SUB BIOME 
        IAreaFactory<LazyArea> riverAndSubBiomesInitFactory = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), landSeaFactory);
        riverAndSubBiomesInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 2, contextFactory);
        IAreaFactory<LazyArea> riversInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, riverSize, contextFactory);
        riversInitFactory = RiverLayer.INSTANCE.apply(contextFactory.apply(1L), riversInitFactory);
        riversInitFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), riversInitFactory);

        
        //MIX BIOMES
        biomesFactory = RareBiomeLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);

		
        for (int i = 0; i < biomeSize; ++i)
        {
            biomesFactory = ZoomLayer.NORMAL.apply(contextFactory.apply((long)(1000 + i)), biomesFactory);
            if (i == 0) 
            	biomesFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), biomesFactory);
        }
		
        biomesFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), biomesFactory);

        biomesFactory = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);
        biomesFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomesFactory, 2, contextFactory);
		
                
        
        /*
        IAreaFactory<LazyArea> riverAndSubBiomesInitFactory = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), factory);
        riverAndSubBiomesInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 2, contextFactory);
        
        IAreaFactory<LazyArea> riversInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 4 , contextFactory);
        riversInitFactory = RiverLayer.INSTANCE.apply(contextFactory.apply(1L), riversInitFactory);
        riversInitFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), riversInitFactory);

        IAreaFactory<LazyArea> biomesFactory = createBiomeFactory(landSeaFactory, contextFactory);
        biomesFactory = RareBiomeLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);

		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1000), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1001), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1002), biomeLayer);
		biomeLayer = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1003), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1004), biomeLayer);
		biomeLayer = ZoomLayer.NORMAL.apply(contextFactory.apply(1005), biomeLayer);
		biomeLayer = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), biomeLayer);
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomesFactory);
		return new Layer[]{new Layer(biomesFactory), new Layer(voronoizoom)};

		*/
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomesFactory);
		return new Layer[]{new Layer(biomesFactory), new Layer(voronoizoom)};
		
		
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