package com.deedllit.yggdrasil.init;

import java.util.Set;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.asgard.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.midgard.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.vanilla.biomes.*;
import com.deedllit.yggdrasil.world.gen.worldtype.WorldTypeMidgard;
import com.google.common.collect.Sets;

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

	public static WorldTypeMidgard worldType;
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Yggdrasil.MOD_ID) ; 	
	public static Set<Biome> setMidgard = Sets.newHashSet();
	
	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	

/*
 * OVERWORLD
 */
	
	public static final RegistryObject<Biome> VANILLA_COLD_OCEAN_BIOME = BIOMES
			.register("vanilla_cold_ocean_biome",
					() -> new VanillaColdOceanBiome());

	public static final RegistryObject<Biome> VANILLA_BIRCH_FOREST_HILLS_BIOME = BIOMES
			.register("vanilla_birch_forest_hills_biome",
					() -> new VanillaBirchForestHillsBiome());

	public static final RegistryObject<Biome> VANILLA_BIRCH_FOREST_BIOME = BIOMES
			.register("vanilla_birch_forest_biome",
					() -> new VanillaBirchForestBiome());

	public static final RegistryObject<Biome> VANILLA_BEACH_BIOME = BIOMES
			.register("vanilla_beach_biome",
					() -> new VanillaBeachBiome());

	public static final RegistryObject<Biome> VANILLA_BAMBOO_JUNGLE_BIOME = BIOMES
			.register("vanilla_bamboo_jungle_biome",
					() -> new VanillaBambooJungleBiome());

	public static final RegistryObject<Biome> VANILLA_BAMBOO_JUNGLE_HILLS_BIOME = BIOMES
			.register("vanilla_bamboo_jungle_hills_biome",
					() -> new VanillaBambooJungleHillsBiome());

	public static final RegistryObject<Biome> VANILLA_BADLANDS_PLATEAU_BIOME = BIOMES
			.register("vanilla_badlands_plateau_biome",
					() -> new VanillaBadlandsPlateauBiome());

	public static final RegistryObject<Biome> VANILLA_SUNFLOWER_PLAINS_BIOME = BIOMES
	.register("vanilla_sunflower_plains_biome",
			() -> new VanillaSunflowerPlainsBiome());

	public static final RegistryObject<Biome> VANILLA_BADLANDS_BIOME = BIOMES
	.register("vanilla_badlands_biome",
			() -> new VanillaBadlandsBiome());
	
	public static final RegistryObject<Biome> VANILLA_PLAINS_BIOME = BIOMES
	.register("vanilla_plains_biome",
			() -> new VanillaPlainsBiome());
	
	public static final RegistryObject<Biome> VANILLA_RIVER_BIOME = BIOMES
	.register("vanilla_river_biome",
			() -> new VanillaRiverBiome());
	
	
	
	/*
	 * ASGARD
	 */

	
	public static final RegistryObject<Biome> ASGARD_SMALL_ISLANDS_BIOME = BIOMES
			.register("asgard_small_islands_biome",
					() -> new AsgardSmallIslandsBiome());
	
	
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


	public static final RegistryObject<Biome> MIDGARD_RAINBOW_PLAINS_BIOME = BIOMES
			.register("midgard_rainbow_plains",
					() -> new MidgardRainbowPlainsBiome());

	public static final RegistryObject<Biome> MIDGARD_IRON_WOOD_BIOME = BIOMES
			.register("midgard_iron_wood",
					() -> new MidgardIronWoodBiome());

	public static final RegistryObject<Biome> MIDGARD_MANGROVE_BIOME = BIOMES
			.register("midgard_mangrove",
					() -> new MidgardMangroveBiome());
	
	/*
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_RIVER = BIOMES
			.register("midgard_mangrove_river",
					() -> new MidgardMangroveRiverBiome());	
	
	
	*/
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_DRYER_BIOME = BIOMES
			.register("midgard_mangrove_dryer",
					() -> new MidgardMangroveDryerBiome());	

	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_TROPICAL_BIOME = BIOMES
			.register("midgard_charparral_tropical",
					() -> new MidgardChaparralTropicalBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_ALPINE_TUNDRA_BIOME = BIOMES
			.register("midgard_alpine_tundra",
					() -> new MidgardAlpineTundraBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_TROPICAL_BEACH_BIOME = BIOMES
			.register("midgard_tropical_beach",
					() -> new MidgardTropicalBeachBiome());	

	public static final RegistryObject<Biome> MIDGARD_RAINBOW_MOUTAIN_BIOME = BIOMES
			.register("midgard_rainbow_moutain",
					() -> new MidgardRainbowMoutainBiome());	

	public static final RegistryObject<Biome> MIDGARD_TEAK_FOREST_BIOME = BIOMES
			.register("midgard_teak_forest",
					() -> new MidgardTeakForestBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_THOUSAND_LAKES_BIOME = BIOMES
			.register("midgard_thousand_lakes",
					() -> new MidgardThousandLakesBiome());	

	public static final RegistryObject<Biome> MIDGARD_TROPICAL_ISLAND_BIOME = BIOMES
			.register("midgard_tropical_island",
					() -> new MidgardTropicalIslandBiome());	

	
	public static final RegistryObject<Biome> MIDGARD_VOLCANIC_ISLAND_BIOME = BIOMES
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

	public static final RegistryObject<Biome> MUSPELHEIM_DEEP_OCEAN_BIOME = BIOMES
			.register("muspelheim_deep_ocean",
					() -> new MuspelheimDeepOceanBiome(null));

	public static final RegistryObject<Biome> MUSPELHEIM_VOLCANO_BIOME = BIOMES
			.register("muspelheim_volcano",
					() -> new MuspelheimVolcanoBiome(null));
	
	public static final RegistryObject<Biome> MUSPELHEIM_RIVER_BIOME = BIOMES
			.register("muspelheim_river",
					() -> new MuspelheimFireRiver());
	
	public static final RegistryObject<Biome> MUSPELHEIM_BEACH_BIOME = BIOMES
			.register("muspelheim_beach",
					() -> new MuspelheimBeachBiome());
	
	
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
	
	public static final RegistryObject<Biome> NIFELHEIM_BENKONGERIKE_PLAIN_BIOME = BIOMES
			.register("nifelheim_benkongerike_plain_biome",
					() -> new NifelheimBenkongerikePlainBiome());
	
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_PLAIN_BIOME = BIOMES
			.register("nifelheim_frozen_plain_biome",
					() -> new NifelheimForzenPlainBiome());

	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_FOREST_BIOME = BIOMES
			.register("nifelheim_frozen_forest_biome",
					() -> new NifelheimForzenForestBiome());
	
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_OCEAN_BIOME = BIOMES
			.register("nifelheim_frozen_ocean_biome",
					() -> new NifelheimForzenOceanBiome());
	
	
	
	
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
	}
	
	public static void onInit() {
        BiomeDictionary.addTypes(MUSPELHEIM_FOREST, BiomeDictionary.Type.FOREST);
	}
	
	
	
	private static void registerMidgardBiomes() {
		setMidgard.add(VANILLA_SUNFLOWER_PLAINS_BIOME.get()) ; 
		setMidgard.add(VANILLA_BADLANDS_BIOME.get()) ; 
		setMidgard.add(VANILLA_PLAINS_BIOME.get()) ; 
		setMidgard.add(VANILLA_RIVER_BIOME.get()) ; 
		setMidgard.add(MIDGARD_RAINBOW_PLAINS_BIOME.get()) ; 
		setMidgard.add(MIDGARD_IRON_WOOD_BIOME.get()) ; 
		setMidgard.add(MIDGARD_MANGROVE_DRYER_BIOME.get()) ; 
		setMidgard.add(MIDGARD_CHARPARRAL_TROPICAL_BIOME.get()) ; 
		setMidgard.add(MIDGARD_ALPINE_TUNDRA_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TROPICAL_BEACH_BIOME.get()) ; 
		setMidgard.add(MIDGARD_RAINBOW_MOUTAIN_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TEAK_FOREST_BIOME.get()) ; 
		setMidgard.add(MIDGARD_THOUSAND_LAKES_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TROPICAL_ISLAND_BIOME.get()) ; 
		setMidgard.add(MIDGARD_VOLCANIC_ISLAND_BIOME.get()) ; 
	}
	
	
	/*
	 * REGISTER IN OVERWORLD
	 */
	public static void registerBiomes() {
		
		registerMidgardBiomes() ;
		
		/*
		registerBiome(1000, IRON_WOOD_BIOME.get(), Type.FOREST, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_MANGROVE.get(), Type.SWAMP, Type.WET, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_CHARPARRAL_TROPICAL.get(), Type.SWAMP, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_MANGROVE_DRYER.get(), Type.SWAMP, Type.WET, Type.OVERWORLD);				
		registerBiome(1000, MIDGARD_ALPINE_TUNDRA.get(), Type.HILLS, Type.MOUNTAIN, Type.OVERWORLD);		
		registerBiome(1000, MIDGARD_TROPICAL_BEACH.get(), Type.BEACH, Type.SANDY, Type.HILLS, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_RAINBOW_MOUTAIN.get(), Type.SANDY, Type.MESA, Type.HILLS, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_TEAK_FOREST.get(), Type.FOREST, Type.HOT, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_THOUSAND_LAKES.get(), Type.PLAINS, Type.WATER, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_TROPICAL_ISLAND.get(), Type.MOUNTAIN, Type.OVERWORLD) ; 
		registerBiome(1000, MIDGARD_VOLCANIC_ISLAND.get(), Type.MOUNTAIN, Type.OVERWORLD) ; 			
		registerBiome(10000, SUNFLOWER_PLAINS_BIOME.get(), Type.PLAINS, Type.OVERWORLD) ; 			
		registerBiome(10000, BADLANDS_BIOME.get(), Type.MESA, Type.OVERWORLD) ; 			
		*/
	}

	
	private static void registerBiome(int weight, Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, weight));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	
    public static void setup() {
        worldType = new WorldTypeMidgard();
    }

}
