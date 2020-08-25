package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.asgard.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.midgard.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.vanilla.biomes.*;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Yggdrasil.MOD_ID) ; 	

	
	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	

/*
 * OVERWORLD
 */

	public static final RegistryObject<Biome> SUNFLOWER_PLAINS_BIOME = BIOMES
	.register("vanilla_sunflower_plains_biome",
			() -> new VanillaSunflowerPlainsBiome());

	public static final RegistryObject<Biome> BADLANDS_BIOME = BIOMES
	.register("vanilla_badlands_biome",
			() -> new VanillaBadlandsBiome());
	
	
	/*
	 * ASGARD
	 */

	public static final RegistryObject<Biome> ASGARD_LAKES_BIOME = BIOMES
		.register("asgard_lakes_biome",
				() -> new AsgardLakesBiome());
	
	public static final RegistryObject<Biome> ASGARD_DESERT_BIOME = BIOMES
		.register("asgard_desert_biome",
				() -> new AsgardDesertBiome());

	public static final RegistryObject<Biome> ASGARD_PINK_MANGENTA_PLAINS_BIOME = BIOMES
		.register("asgard_pink_mangenta_plains_biome",
				() -> new AsgardPinkMangentaPlainsBiome());

	public static final RegistryObject<Biome> ASGARD_HILLS_BIOME = BIOMES
			.register("asgard_hills_biome",
					() -> new AsgardHillsBiome());

	public static final RegistryObject<Biome> ASGARD_MOUTAINS_BIOME = BIOMES
			.register("asgard_moutains_biome",
					() -> new AsgardMountainsBiome());

	public static final RegistryObject<Biome> ASGARD_PLAINS_BIOME = BIOMES
			.register("asgard_plains_biome",
					() -> new AsgardPlainsBiome());

	public static final RegistryObject<Biome> ASGARD_SUNFLOWER_PLAINS_BIOME = BIOMES
			.register("asgard_sunflower_plains_biome",
					() -> new AsgardSunflowerPlainsBiome());

	public static final RegistryObject<Biome> ASGARD_FOREST_PLAINS_BIOME = BIOMES
			.register("asgard_forest_plains_biome",
					() -> new AsgardForestPlainsBiome());

	public static final RegistryObject<Biome> ASGARD_OAK_FOREST_BIOME = BIOMES
			.register("asgard_oak_forest_biome",
					() -> new AsgardOakForestBiome());
	
	public static final RegistryObject<Biome> ASGARD_BIRCH_FOREST_BIOME = BIOMES
			.register("asgard_birch_forest_biome",
					() -> new AsgardBirchForestBiome());

	/*
 * MIDGARD
 */

	public static final RegistryObject<Biome> IRON_WOOD_BIOME = BIOMES
			.register("iron_wood",
					() -> new MidgardIronWoodBiome());

	public static final RegistryObject<Biome> MIDGARD_MANGROVE = BIOMES
			.register("midgard_mangrove",
					() -> new MidgardMangroveBiome());
	
	/*
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_RIVER = BIOMES
			.register("midgard_mangrove_river",
					() -> new MidgardMangroveRiverBiome());	
	
	
	*/
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_DRYER = BIOMES
			.register("midgard_mangrove_dryer",
					() -> new MidgardMangroveDryerBiome());	

	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_TROPICAL = BIOMES
			.register("midgard_charparral_tropical",
					() -> new MidgardChaparralTropicalBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_ALPINE_TUNDRA = BIOMES
			.register("midgard_alpine_tundra",
					() -> new MidgardAlpineTundraBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_TROPICAL_BEACH = BIOMES
			.register("midgard_tropical_beach",
					() -> new MidgardTropicalBeachBiome());	

	public static final RegistryObject<Biome> MIDGARD_RAINBOW_MOUTAIN = BIOMES
			.register("midgard_rainbow_moutain",
					() -> new MidgardRainbowMoutainBiome());	

	public static final RegistryObject<Biome> MIDGARD_TEAK_FOREST = BIOMES
			.register("midgard_teak_forest",
					() -> new MidgardTeakForestBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_THOUSAND_LAKES = BIOMES
			.register("midgard_thousand_lakes",
					() -> new MidgardThousandLakesBiome());	

	public static final RegistryObject<Biome> MIGARD_TROPICAL_ISLAND = BIOMES
			.register("midgard_tropical_island",
					() -> new MidgardTropicalIslandBiome());	

	
	public static final RegistryObject<Biome> MIGARD_VOLCANIC_ISLAND = BIOMES
			.register("midgard_volcanic_island",
					() -> new MidgardVolcanicIslandBiome());	
	
					
	/*
	public static final RegistryObject<Biome> MIDGARD_FYNBOS = BIOMES
			.register("midgard_fynbos",
					() -> new MidgardFynbos());	
				
	public static final RegistryObject<Biome> MIDGARD_VOLCANIC = BIOMES
			.register("midgard_volcanic",
					() -> new MidgardVolcanicBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_DESERT = BIOMES
			.register("midgard_charparral_desert",
					() -> new MidgardChaparralDesertBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_SPOOKY = BIOMES
			.register("midgard_spooky",
					() -> new MidgardSpookyBiome());	
	
	*/
	
/*
 * MUSPELHEIM
 */

	public static final Biome MUSPELHEIM_FOREST = Biomes.DEFAULT;
	
	public static final RegistryObject<Biome> MUSPELHEIM = BIOMES
			.register("muspelheim_extreme_hill",
					() -> new MuspelheimExtremeHillBiome(null));

	public static final RegistryObject<Biome> MUSPELHEIM_PLAINS = BIOMES
			.register("muspelheim_plains",
					() -> new MuspelheimPlainsBiome(null));
	
	public static final RegistryObject<Biome> MUSPELHEIM_ASH_PLAINS = BIOMES
			.register("muspelheim_ash_plains",
					() -> new MuspelheimAshPlainsBiome(null));
		
	public static final RegistryObject<Biome> MUSPELHEIM_CLIFF_BIOME = BIOMES
			.register("muspelheim_cliff",
					() -> new MuspelheimCliffBiome(null));

	public static final RegistryObject<Biome> MUSPELHEIM_OCEAN_BIOME = BIOMES
			.register("muspelheim_ocean",
					() -> new MuspelheimOceanBiome(null));

	public static final RegistryObject<Biome> MUSPELHEIM_VOLCANO_BIOME = BIOMES
			.register("muspelheim_volcano",
					() -> new MuspelheimVolcanoBiome(null));
	
	
	
/*
 * SVARTALVHEIM
 */

	public static final RegistryObject<Biome> SVARTALVHEIM_GRASS_CAVERN_BIOME = BIOMES
			.register("svartalvheim_grass_cavern_biome",
					() -> new SvartalvheimGrassCavernBiome(null));

	public static final RegistryObject<Biome> SVARTALVHEIM_CAVERN_BIOME = BIOMES
			.register("svartalvheim_cavern_biome",
					() -> new SvartalvheimCavernBiome(null));
		
	
	/*
	 * NIFELHEIM
	 */	
	
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_PLAIN_BIOME = BIOMES
			.register("nifelheim_frozen_plain_biome",
					() -> new NifelheimForzenPlainBiome(null));

	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_FOREST_BIOME = BIOMES
			.register("nifelheim_frozen_forest_biome",
					() -> new NifelheimForzenForestBiome(null));
	
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_OCEAN_BIOME = BIOMES
			.register("nifelheim_frozen_ocean_biome",
					() -> new NifelheimForzenOceanBiome(null));
	
	
	
	
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
	}
	
	public static void onInit() {
        BiomeDictionary.addTypes(MUSPELHEIM_FOREST, BiomeDictionary.Type.FOREST);
	}
	
	
	/*
	 * REGISTER IN OVERWORLD
	 */
	public static void registerBiomes() {
		registerBiome(1000, IRON_WOOD_BIOME.get(), Type.FOREST, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_MANGROVE.get(), Type.SWAMP, Type.WET, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_CHARPARRAL_TROPICAL.get(), Type.SWAMP, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_MANGROVE_DRYER.get(), Type.SWAMP, Type.WET, Type.OVERWORLD);				
		registerBiome(1000, MIDGARD_ALPINE_TUNDRA.get(), Type.HILLS, Type.MOUNTAIN, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_TROPICAL_BEACH.get(), Type.BEACH, Type.SANDY, Type.HILLS, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_RAINBOW_MOUTAIN.get(), Type.SANDY, Type.MESA, Type.HILLS, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_TEAK_FOREST.get(), Type.FOREST, Type.HOT, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_THOUSAND_LAKES.get(), Type.PLAINS, Type.WATER, Type.OVERWORLD) ; 
		registerBiome(1000, MIGARD_TROPICAL_ISLAND.get(), Type.MOUNTAIN, Type.OVERWORLD) ; 
		registerBiome(1000, MIGARD_VOLCANIC_ISLAND.get(), Type.MOUNTAIN, Type.OVERWORLD) ; 			
		registerBiome(10000, SUNFLOWER_PLAINS_BIOME.get(), Type.PLAINS, Type.OVERWORLD) ; 			
		registerBiome(10000, BADLANDS_BIOME.get(), Type.MESA, Type.OVERWORLD) ; 			
	}

	
	private static void registerBiome(int weight, Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, weight));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}


}
