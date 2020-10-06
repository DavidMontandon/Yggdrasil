package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator;

import java.util.Set;
import java.util.function.LongFunction;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddIslandLayer;
import net.minecraft.world.gen.layer.IslandLayer;
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
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_volcano")),
			ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_river"))
			} ;

	private static final Set<Biome> biomeList = ImmutableSet.of(
			BiomeInit.MUSPELHEIM.get(), 
			BiomeInit.MUSPELHEIM_PLAINS.get(), 
			BiomeInit.MUSPELHEIM_ASH_PLAINS.get(), 
			BiomeInit.MUSPELHEIM_CLIFF_BIOME.get(), 
			BiomeInit.MUSPELHEIM_OCEAN_BIOME.get(), 
			BiomeInit.MUSPELHEIM_VOLCANO_BIOME.get(),
			BiomeInit.MUSPELHEIM_RIVER_BIOME.get()
			);

	private final Layer genBiomes;
	private final Biome[] biomes;
	
	public MuspelheimBiomeProvider(World world) {
		super(biomeList);
		
		Layer[] aLayer = buildWorld(world.getSeed()) ; 
		
		this.genBiomes = aLayer[0];
		this.biomes = dimensionBiomes;
		
	}

	private Layer[] buildWorld(long seed) {
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