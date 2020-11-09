package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;

import java.util.function.LongFunction;

import com.deedllit.yggdrasil.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public class AsgardLayerUtil {

	public static final int PLAINS = Registry.BIOME.getId(BiomeInit.ASGARD_PLAINS_BIOME.get());
	public static final int SNOW_PLAINS = Registry.BIOME.getId(BiomeInit.ASGARD_SNOWY_TUNDRA_BIOME.get());
			
	
	
	public static final int SUNFLOWER_PLAINS = Registry.BIOME.getId(BiomeInit.ASGARD_SUNFLOWER_PLAINS_BIOME.get());
	public static final int PINK_MANGENTA_PLAINS = Registry.BIOME.getId(BiomeInit.ASGARD_PINK_MANGENTA_PLAINS_BIOME.get());
	public static final int LAKES = Registry.BIOME.getId(BiomeInit.ASGARD_LAKES_BIOME.get());
	public static final int ISLAND = Registry.BIOME.getId(BiomeInit.ASGARD_SMALL_ISLANDS_BIOME.get());

	public static final int DESERT = Registry.BIOME.getId(BiomeInit.ASGARD_DESERT_BIOME.get());
	
	public static final int FOREST_PLAINS = Registry.BIOME.getId(BiomeInit.ASGARD_FOREST_PLAINS_BIOME.get());
	public static final int BIRCH_FOREST = Registry.BIOME.getId(BiomeInit.ASGARD_BIRCH_FOREST_BIOME.get());

	
	public static final int OAK_FOREST = Registry.BIOME.getId(BiomeInit.ASGARD_OAK_FOREST_BIOME.get());
	public static final int SNOWNY_FOREST = Registry.BIOME.getId(BiomeInit.ASGARD_SNOWY_TAIGA_BIOME.get());
	
	public static final int HILLS = Registry.BIOME.getId(BiomeInit.ASGARD_HILLS_BIOME.get());
	public static final int SNOWY_HILLS = Registry.BIOME.getId(BiomeInit.ASGARD_SNOWY_TAIGA_HILLS_BIOME.get());
	
	
	
	public static final int MOUNTAIN = Registry.BIOME.getId(BiomeInit.ASGARD_MOUTAINS_BIOME.get());
	public static final int SNOWY_MOUNTAIN = Registry.BIOME.getId(BiomeInit.ASGARD_SNOWY_TAIGA_MOUNTAIN_BIOME.get());

	public static final int EXTREME_MOUNTAIN = Registry.BIOME.getId(BiomeInit.ASGARD_EXTREME_MOUTAINS_BIOME.get());
	public static final int SNOWY_EXTREME_MOUNTAIN = Registry.BIOME.getId(BiomeInit.ASGARD_SNOWY_TAIGA_EXTREME_MOUNTAIN_BIOME.get());
			
	
	public static boolean isCold(int biomeIn) {
		return biomeIn == SNOW_PLAINS || biomeIn == SNOWNY_FOREST || biomeIn == SNOWY_MOUNTAIN || biomeIn == SNOWY_EXTREME_MOUNTAIN ;
	}
	
	public static boolean isHotPlain(int biomeIn) {
		return isPlain(biomeIn) && ! isCold(biomeIn) ; 
	}
	
	public static boolean isColdPlain(int biomeIn) {
		return isPlain(biomeIn) && isCold(biomeIn) ; 
	}

	public static boolean isHotForest(int biomeIn) {
		return isForest(biomeIn) && ! isCold(biomeIn) ; 
	}

	public static boolean isPlain(int biomeIn) {
		return biomeIn == PLAINS || biomeIn == SNOW_PLAINS | biomeIn == SUNFLOWER_PLAINS || biomeIn == LAKES
				|| biomeIn == PINK_MANGENTA_PLAINS || biomeIn == ISLAND;
	}

	public static boolean isForest(int biomeIn) {
		return biomeIn == OAK_FOREST || biomeIn == SNOWNY_FOREST || biomeIn == BIRCH_FOREST ;
	}

	public static boolean isMoutain(int biomeIn) {
		return biomeIn == MOUNTAIN || biomeIn == SNOWY_MOUNTAIN  ;
	}
	
	
	public static int countSnowy(int center, int n, int e, int s, int w) {
		
		int i = 0 ;
		
		if(isCold(center)) 
			i++ ;
		
		if(isCold(n)) 
			i++ ;

		if(isCold(s)) 
			i++ ;

		if(isCold(e)) 
			i++ ;

		if(isCold(w)) 
			i++ ;

		return i ;
		
	}
	
	
	
	public static boolean contains(int center, int n, int e, int s, int w) {
		return center == n || center == e || center == s|| center == w ; 
	}
	
	public static boolean surroundBy(int center, int n, int e, int s, int w) {
		return center == n && center == e && center == s && center == w ; 
	}
	
	
	public static IAreaFactory<LazyArea> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<LazyArea> targetFactory,
			int count, LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory) {

		IAreaFactory<LazyArea> iareafactory = targetFactory;

		for (int i = 0; i < count; ++i) {
			iareafactory = parent.apply(contextFactory.apply(seed + (long) i), iareafactory);
		}

	return iareafactory;
	}	
	
}
