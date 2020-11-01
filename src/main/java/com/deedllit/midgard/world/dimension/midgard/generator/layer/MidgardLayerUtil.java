package com.deedllit.midgard.world.dimension.midgard.generator.layer;

import com.deedllit.yggdrasil.init.BiomeInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;

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
	

    public static boolean isOcean(int biomeIn) {
        return biomeIn == COLD_OCEAN || biomeIn == DEEP_COLD_OCEAN || biomeIn == DEEP_FROZEN_OCEAN;
    }	
	
    /*
     * Not deep
     */
    public static boolean isShallowOcean(int biomeIn) {
        return biomeIn == COLD_OCEAN || biomeIn == COLD_OCEAN ;
    }	

}
