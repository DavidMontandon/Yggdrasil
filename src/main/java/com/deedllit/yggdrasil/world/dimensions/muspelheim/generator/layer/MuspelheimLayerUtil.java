package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import java.util.function.LongFunction;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardAddIslandLayer;
import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardRemoveTooMuchOceanLayer;
import com.deedllit.yggdrasil.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public class MuspelheimLayerUtil {

	public static final int OCEAN = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_OCEAN_BIOME.get());
	public static final int DEEP_OCEAN = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_DEEP_OCEAN_BIOME.get());

	public static final int RIVER = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_RIVER_BIOME.get());

	public static final int PLAINS = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_ASH_PLAINS.get());
	public static final int MOUTAINS = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_CLIFF_BIOME.get());
	public static final int FOREST = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_PLAINS.get());
	public static final int DESERT = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_VOLCANO_BIOME.get());
	
	
	
	public static IAreaFactory<LazyArea> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<LazyArea> targetFactory,
			int count, LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory) {

		IAreaFactory<LazyArea> iareafactory = targetFactory;

		for (int i = 0; i < count; ++i) {
			iareafactory = parent.apply(contextFactory.apply(seed + (long) i), iareafactory);
		}

	return iareafactory;
	}
	
	public static boolean isOcean(int biomeIn) {
		return biomeIn == OCEAN || biomeIn == DEEP_OCEAN;
	}

	public static boolean isShallowOcean(int biomeIn) {
		return  biomeIn == OCEAN ;
	}

	
}
