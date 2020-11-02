package com.deedllit.midgard.world.dimension.midgard.generator.layer;

import java.util.function.LongFunction;

import com.deedllit.yggdrasil.init.BiomeInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public class MidgardLayerUtil {

	public static final int COLD_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_COLD_OCEAN_BIOME.get());
	public static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_COLD_OCEAN_BIOME.get());
	public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_FROZEN_OCEAN_BIOME.get());
	public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get());
	public static final int DEEP_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_OCEAN_BIOME.get());
	public static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_WARM_OCEAN_BIOME.get());
	public static final int WARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_WARM_OCEAN_BIOME.get());
	public static final int OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_OCEAN_BIOME.get());
	public static final int LUKEWARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_LUKE_WARM_OCEAN_BIOME.get());
	public static final int FROZEN_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_FROZEN_OCEAN_BIOME.get());

	public static final int RIVER = Registry.BIOME.getId(BiomeInit.VANILLA_RIVER_BIOME.get());

	public static final int PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_PLAINS_BIOME.get());
	public static final int FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_FOREST_BIOME.get());
	public static final int MOUTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAINS_BIOME.get());

	public static final int FROZEN_RIVER = Registry.BIOME.getId(BiomeInit.VANILLA_FROZEN_RIVER_BIOME.get());
	public static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
	public static final int MUSHROOM_FIELDS = Registry.BIOME.getId(BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get());
	public static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(Biomes.MUSHROOM_FIELD_SHORE);
	
	
	public static IAreaFactory<LazyArea> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<LazyArea> targetFactory,
			int count, LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory) {

		IAreaFactory<LazyArea> iareafactory = targetFactory;

		for (int i = 0; i < count; ++i) {
			iareafactory = parent.apply(contextFactory.apply(seed + (long) i), iareafactory);
		}

	return iareafactory;
	}
	
	public static boolean isOcean(int biomeIn) {
		return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN
				|| biomeIn == FROZEN_OCEAN || biomeIn == DEEP_WARM_OCEAN || biomeIn == DEEP_LUKEWARM_OCEAN
				|| biomeIn == DEEP_OCEAN || biomeIn == DEEP_COLD_OCEAN || biomeIn == DEEP_FROZEN_OCEAN;
	}

	public static boolean isShallowOcean(int biomeIn) {
		return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN
				|| biomeIn == FROZEN_OCEAN;
	}



}
