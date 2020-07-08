package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.midgard.biomes.*;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes.*;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Yggdrasil.MOD_ID) ; 	

	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	


/*
 * MIDGARD
 */
	public static final RegistryObject<Biome> IRON_WOOD_BIOME = BIOMES
			.register("iron_wood",
					() -> new MidgardIronWoodBiome(null));
	
	
	public static final RegistryObject<Biome> MIDGARD_MANGROVE = BIOMES
			.register("midgard_mangrove",
					() -> new MidgardMangroveBiome());
	
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_RIVER = BIOMES
			.register("midgard_mangrove_river",
					() -> new MidgardMangroveRiverBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_DRYER = BIOMES
			.register("midgard_mangrove_dryer",
					() -> new MidgardMangroveDryerBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_TROPICAL = BIOMES
			.register("midgard_charparral_tropical",
					() -> new MidgardChaparralTropicalBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_FYNBOS = BIOMES
			.register("midgard_fynbos",
					() -> new MidgardFynbos());	
				
	public static final RegistryObject<Biome> MIDGARD_VOLCANIC = BIOMES
			.register("midgard_volcanic",
					() -> new MidgardVolcanicBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_DESERT = BIOMES
			.register("midgard_charparral_desert",
					() -> new MidgardChaparralDesertBiome());	
	
	
/*
 * MUSPELHEIM
 */

	//public static final Biome MUSPELHEIM_FOREST = Biomes.DEFAULT;
	
	
	public static final RegistryObject<Biome> MUSPELHEIM = BIOMES
			.register("muspelheim_extreme_hill",
					() -> new MuspelheimExtremeHillBiome());

	public static final RegistryObject<Biome> MUSPELHEIM_PLAINS = BIOMES
			.register("muspelheim_plains",
					() -> new MuspelheimPlainsBiome());
	
	public static final RegistryObject<Biome> MUSPELHEIM_ASH_PLAINS = BIOMES
			.register("muspelheim_ash_plains",
					() -> new MuspelheimAshPlainsBiome());
		
	public static final RegistryObject<Biome> MUSPELHEIM_CLIFF_BIOME = BIOMES
			.register("muspelheim_cliff",
					() -> new MuspelheimCliffBiome());

	public static final RegistryObject<Biome> MUSPELHEIM_POPPY_FIELD_BIOME = BIOMES
			.register("muspelheim_poppy_field",
					() -> new MuspelheimFirePoppyField());

	public static final RegistryObject<Biome> MUSPELHEIM_OCEAN_BIOME = BIOMES
			.register("muspelheim_ocean",
					() -> new MuspelheimOceanBiome());

	public static final RegistryObject<Biome> MUSPELHEIM_RIVER_BIOME = BIOMES
			.register("muspelheim_river",
					() -> new MuspelheimRiverBiome());

	public static final RegistryObject<Biome> MUSPELHEIM_BEACH_BIOME = BIOMES
			.register("muspelheim_beach",
					() -> new MuspelheimBeachBiome());
	
	public static final RegistryObject<Biome> MUSPELHEIM_FOREST_BIOME = BIOMES
			.register("muspelheim_forest",
					() -> new MuspelheimEpluphierForestBiome());
	
	
	/*
	public static final RegistryObject<Biome> MUSPELHEIM_VOLCANO_BIOME = BIOMES
			.register("muspelheim_volcano",
					() -> new MuspelheimVolcanoBiome(null));
	*/
	
/*
 * SVARTALVHEIM
 */

	/*
	public static final RegistryObject<Biome> SVARTALVHEIM_GRASS_CAVERN_BIOME = BIOMES
			.register("svartalvheim_grass_cavern_biome",
					() -> new SvartalvheimGrassCavernBiome(null));

	public static final RegistryObject<Biome> SVARTALVHEIM_CAVERN_BIOME = BIOMES
			.register("svartalvheim_cavern_biome",
					() -> new SvartalvheimCavernBiome(null));
		*/
	
	/*
	 * NIFELHEIM
	 */	
	
	/*
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_PLAIN_BIOME = BIOMES
			.register("nifelheim_frozen_plain_biome",
					() -> new NifelheimForzenPlainBiome(null));

	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_FOREST_BIOME = BIOMES
			.register("nifelheim_frozen_forest_biome",
					() -> new NifelheimForzenForestBiome(null));
	
	public static final RegistryObject<Biome> NIFELHEIM_FROZEN_OCEAN_BIOME = BIOMES
			.register("nifelheim_frozen_ocean_biome",
					() -> new NifelheimForzenOceanBiome(null));
	*/
	
	
	
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
	}
	
	public static void onInit() {
        //BiomeDictionary.addTypes(MUSPELHEIM_FOREST, BiomeDictionary.Type.FOREST);
	}
	
	
	/*
	 * REGISTER IN OVERWORLD
	 */
	public static void registerBiomes() {
		registerBiome(100, IRON_WOOD_BIOME.get(), Type.FOREST, Type.OVERWORLD);		
		registerBiome(100, MIDGARD_MANGROVE.get(), Type.SWAMP, Type.OVERWORLD);		
		registerBiome(100, MIDGARD_MANGROVE_RIVER.get(), Type.SWAMP, Type.OVERWORLD);		
		registerBiome(5, MIDGARD_MANGROVE_DRYER.get(), Type.SWAMP, Type.OVERWORLD);		
	}

	
	private static void registerBiome(int height, Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, height));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
				
		if(Yggdrasil.PRINT_DEBUG) 			
			Yggdrasil.LOGGER.info("YGGDRASIL DEBUG : BiomeInit.registerBiome - " + biome.getDisplayName());
	}
	 

}
