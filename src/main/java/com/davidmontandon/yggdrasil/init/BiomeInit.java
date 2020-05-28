package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.biomes.MuspelheimBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Yggdrasil.MOD_ID) ; 	

	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	

	
	public static final RegistryObject<Biome> MUSPELHEIM = BIOMES
			.register("muspelheim",
					() -> new MuspelheimBiome(
							new Biome.Builder()
									.precipitation(RainType.SNOW)
									.scale(1.2f).temperature(0.5f)
									.waterColor(0x906B9F)
									.waterFogColor(0x6E5651)
									.surfaceBuilder(SurfaceBuilder.DEFAULT, 
											new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState(), 
													BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState(), 
													Blocks.SAND.getDefaultState()))
									.category(Category.PLAINS)
									.downfall(0.5f)
									.depth(0.12f)
									.parent(null)));
	
	
	public static void registerBiomes() {
		registerBiome(MUSPELHEIM.get(), Type.PLAINS, Type.OVERWORLD);
	}

	private static void registerBiome(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}


}
