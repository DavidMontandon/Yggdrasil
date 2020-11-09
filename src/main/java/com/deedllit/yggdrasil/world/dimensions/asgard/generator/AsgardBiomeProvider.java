package com.deedllit.yggdrasil.world.dimensions.asgard.generator;

import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardLayerUtil;
import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer.*;
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
import net.minecraft.world.gen.layer.EdgeLayer;
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
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_snowy_taiga_extreme_mountain_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_snowy_taiga_hills_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_snowy_taiga_mountain_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_snowy_taiga_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_small_islands_biome")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":asgard_snowy_tundra_biome")),
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
			BiomeInit.ASGARD_SNOWY_TAIGA_EXTREME_MOUNTAIN_BIOME.get(),
			BiomeInit.ASGARD_SNOWY_TAIGA_HILLS_BIOME.get(),
			BiomeInit.ASGARD_SNOWY_TAIGA_MOUNTAIN_BIOME.get(),
			BiomeInit.ASGARD_SNOWY_TAIGA_BIOME.get(),
			BiomeInit.ASGARD_SMALL_ISLANDS_BIOME.get(),
			BiomeInit.ASGARD_SNOWY_TUNDRA_BIOME.get(),
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
		
		this.genBiomes = buildWorld(world) ; 
		this.biomes = dimensionBiomes;

	}

	
	private Layer buildWorld(World world) {
		
		WorldType worldType = world.getWorldType() ;
		long seed = world.getSeed() ; 
        int biomeSize = 4;
        int riverSize = 1;
		        
        long size = 200 ;
        
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);
        IAreaFactory<LazyArea> earthSea = AsgardPlainsLayer.INSTANCE.apply(contextFactory.apply(1L));
		earthSea = ZoomLayer.FUZZY.apply(contextFactory.apply(10L), earthSea);
		earthSea = AsgardAddForest.INSTANCE.apply(contextFactory.apply(size), earthSea);
		earthSea = AsgardEdgeLayer.Mountains.INSTANCE.apply(contextFactory.apply(size), earthSea);
		earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(100L), earthSea);
		//earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), earthSea);

		//earthSea = AsgardLayerUtil.repeat(2001L, ZoomLayer.NORMAL, earthSea, 6, contextFactory);

	    //earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(101L), earthSea);
		//earthSea = AsgardEdgeLayer.HeatIce.INSTANCE.apply(contextFactory.apply(2L), earthSea);
	    //earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(102L), earthSea);		
		earthSea = AsgardMixLayer.INSTANCE.apply(contextFactory.apply(size), earthSea) ; 
		earthSea = AsgardBorderEdgeLayer.INSTANCE.apply(contextFactory.apply(size), earthSea);
		
		earthSea = AsgardLayerUtil.repeat(2000L, ZoomLayer.NORMAL, earthSea, 4, contextFactory);

	    
	    
		//earthSea = AsgardAddForest.INSTANCE.apply(contextFactory.apply(50L), earthSea);
		//earthSea = AsgardAddForest.INSTANCE.apply(contextFactory.apply(70L), earthSea);
	    return new Layer(earthSea) ;
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