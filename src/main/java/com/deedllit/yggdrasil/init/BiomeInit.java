package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.biome.*;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes.*;
//import com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes.*;
//import com.deedllit.yggdrasil.world.dimensions.svartalvheim.biomes.*;

import net.minecraft.block.Block;
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

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Yggdrasil.MOD_ID) ; 	

	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	

/*
 * OVERWORLD
 */
	public static final RegistryObject<Biome> IRON_WOOD_BIOME = BIOMES
			.register("iron_wood",
					() -> new IronWoodBiome(null));

/*
 * MUSPELHEIM
 */

	//public static final Biome MUSPELHEIM_FOREST = Biomes.DEFAULT;
	
	
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

	public static final RegistryObject<Biome> MUSPELHEIM_POPPY_FIELD_BIOME = BIOMES
			.register("muspelheim_poppy_field",
					() -> new MuspelheimFirePoppyField(null));

	
	public static final RegistryObject<Biome> MUSPELHEIM_OCEAN_BIOME = BIOMES
			.register("muspelheim_ocean",
					() -> new MuspelheimOceanBiome(null));

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
		registerBiome(IRON_WOOD_BIOME.get(), Type.FOREST, Type.OVERWORLD);		
	}

	private static void registerBiome(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}


}
