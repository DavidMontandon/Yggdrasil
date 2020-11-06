package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator;

import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardAddSnowLayer;
import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardDeepOceanLayer;
import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardEdgeLayer;
import com.deedllit.mythologycraft.world.gen.DefaultBiomesFactory;
import com.deedllit.mythologycraft.world.layer.MythologycraftBiomeLayer;
import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer.*;
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
import net.minecraft.world.gen.layer.EdgeLayer;
import net.minecraft.world.gen.layer.Layer;


import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.registries.ForgeRegistries;

public class MuspelheimBiomeProvider extends BiomeProvider {

	public static Biome[] dimensionBiomes = new Biome[]{
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_extreme_hill")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_plains")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_ash_plains")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_cliff")), 
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_ocean")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_deep_ocean")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_volcano")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_river")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_beach"))
			} ;

	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.MUSPELHEIM.get(), 
			BiomeInit.MUSPELHEIM_PLAINS.get(), 
			BiomeInit.MUSPELHEIM_ASH_PLAINS.get(), 
			BiomeInit.MUSPELHEIM_CLIFF_BIOME.get(), 
			BiomeInit.MUSPELHEIM_OCEAN_BIOME.get(),
			BiomeInit.MUSPELHEIM_DEEP_OCEAN_BIOME.get(), 
			BiomeInit.MUSPELHEIM_VOLCANO_BIOME.get(),
			BiomeInit.MUSPELHEIM_RIVER_BIOME.get(),
			BiomeInit.MUSPELHEIM_BEACH_BIOME.get()
			);

	private final Layer genBiomes;
	private final Biome[] biomes;
	
	public MuspelheimBiomeProvider(World world) {
		super(biomeList);
		
		//Layer[] aLayer = DefaultBiomesFactory.getDefaultBiomesFactory(world.getSeed(), dimensionBiomes, 8, 1) ; 
		
		//Layer[] aLayer = buildWorld(world.getSeed()) ;
		//this.genBiomes = aLayer[0];
		this.genBiomes = buildWorld(world.getSeed()) ;
		this.biomes = dimensionBiomes;
		
	}

	private Layer buildWorld(long seed) {
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);		
		
        int biomeSize = 4;
        int riverSize = 1;
		
        IAreaFactory<LazyArea> earthSea = MuspelheimIslandLayer.INSTANCE.apply(contextFactory.apply(1L));
		earthSea = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), earthSea);
		earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), earthSea);
		earthSea = MuspelheimRemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), earthSea);
		earthSea = MuspelheimDeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), earthSea);

		earthSea = MuspelheimAddForestLayer.INSTANCE.apply(contextFactory.apply(2L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), earthSea);
		earthSea = MuspelheimEdgeLayer.Warm.INSTANCE.apply(contextFactory.apply(2L), earthSea);
		earthSea = MuspelheimEdgeLayer.Heat.INSTANCE.apply(contextFactory.apply(2L), earthSea);

		/*
		IAreaFactory<LazyArea> oceans = MuspelheimOceanLayer.INSTANCE.apply(contextFactory.apply(2L));
		oceans = MuspelheimLayerUtil.repeat(2001L, ZoomLayer.NORMAL, oceans, 6, contextFactory);
		 */

	    int i = biomeSize ;
	    
	    
	    for(int k = 0; k < i; ++k) {
	    	earthSea = ZoomLayer.NORMAL.apply((IExtendedNoiseRandom)contextFactory.apply((long)(1000 + k)), earthSea);
	    	if (k == 0) {
	    		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(3L), earthSea);
	    	}
	
	    	/*
	    	if (k == 1 || i == 1) {
	    		biomes = MidgardShoreLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), biomes);
	    	}
	    	*/
	    }

		
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), earthSea);
		earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), earthSea);
		earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), earthSea);
		earthSea = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), earthSea);
		//earthSea = MuspelheimAddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), earthSea);
				
		
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