package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.muspelheim.biomes.MuspelheimBasicBiome;
import com.davidmontandon.yggdrasil.world.muspelheim.biomes.MuspelheimCliffBiome;
import com.davidmontandon.yggdrasil.world.muspelheim.biomes.MuspelheimForest;
import com.davidmontandon.yggdrasil.world.muspelheim.biomes.MuspelheimOceanBiome;
import com.davidmontandon.yggdrasil.world.muspelheim.biomes.MuspelheimPlainsBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
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
	

	public static final Biome MUSPELHEIM_FOREST = Biomes.DEFAULT;

	
	public static final RegistryObject<Biome> MUSPELHEIM = BIOMES
			.register("muspelheim",
					() -> new MuspelheimBasicBiome(
							new Biome.Builder()
									.precipitation(RainType.NONE)
									.waterColor(0x906B9F)
									.waterFogColor(0x6E5651)
									.surfaceBuilder(SurfaceBuilder.DEFAULT, 
											new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState(), 
													BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState(), 
													Blocks.SAND.getDefaultState()))
									.category(Category.EXTREME_HILLS)
									.downfall(0.0f)
									.depth(0.86f)
									.scale(1.2f).
									temperature(0.5f)
									.parent(null)));
	
	
	
	public static final RegistryObject<Biome> MUSPELHEIM_PLAINS = BIOMES
			.register("muspelheim_plains",
					() -> new MuspelheimPlainsBiome(
						new Biome.Builder()		
							.precipitation(RainType.NONE)
							.waterColor(0x906B9F)
							.waterFogColor(0x6E5651)
							.surfaceBuilder(SurfaceBuilder.DEFAULT, 
									new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_GRASS.get().getDefaultState(), 
											BlockInit.MUSPELHEIM_ASH.get().getDefaultState(), 
											Blocks.SAND.getDefaultState()))
							.category(Category.PLAINS)
							.depth(0.2f)
							.scale(0.1f)
							.temperature(1.0f)
							.downfall(0.0f)
							.parent(null)));
	
	
	public static final RegistryObject<Biome> MUSPELHEIM_ASH_PLAINS = BIOMES
			.register("muspelheim_ash_plains",
					() -> new MuspelheimPlainsBiome(
						new Biome.Builder()		
							.precipitation(RainType.NONE)
							.waterColor(0x906B9F)
							.waterFogColor(0x6E5651)
							.surfaceBuilder(SurfaceBuilder.DEFAULT, 
									new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_ASH.get().getDefaultState(), 
											BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState(), 
											Blocks.SAND.getDefaultState()))
							.category(Category.PLAINS)
							.depth(0.2f)
							.scale(0.5f)
							.temperature(2.0f)
							.downfall(0.0f)
							.parent(null)));
		
	public static final RegistryObject<Biome> MUSPELHEIM_CLIFF_BIOME = BIOMES
			.register("muspelheim_cliff",
					() -> new MuspelheimCliffBiome(
						new Biome.Builder()		
							.precipitation(RainType.NONE)
							.waterColor(0x906B9F)
							.waterFogColor(0x6E5651)
							.surfaceBuilder(SurfaceBuilder.DEFAULT, 
									new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState(), 
											BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState(), 
											Blocks.SAND.getDefaultState()))
							.category(Category.EXTREME_HILLS)
							.downfall(0.0f)
							.scale(0.6f)
							.temperature(2.0f)
							.depth(1.8f)
							.parent(null)));
	
	public static final RegistryObject<Biome> MUSPELHEIM_OCEAN_BIOME = BIOMES
			.register("muspelheim_ocean",
					() -> new MuspelheimOceanBiome(
						new Biome.Builder()		
							.precipitation(RainType.NONE)
							.waterColor(0x906B9F)
							.waterFogColor(0x6E5651)
							.surfaceBuilder(SurfaceBuilder.DEFAULT, 
									new SurfaceBuilderConfig(BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState(), 
											BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState(), 
											Blocks.SAND.getDefaultState()))
							.category(Category.OCEAN)
							.downfall(0.0f)
							.scale(0.1f)
							.temperature(2.0f)
							.depth(-1.0f)
							.parent(null)));
	
	
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
        RegUtil.generic(event.getRegistry())
        	.add("muspelheim_forest", new MuspelheimForest(null))  ;  
	}
	
	public static void onInit() {
        BiomeDictionary.addTypes(MUSPELHEIM_FOREST, BiomeDictionary.Type.FOREST);
        
            
	}
	
	public static void registerBiomes() {
		registerBiome(MUSPELHEIM.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(MUSPELHEIM_CLIFF_BIOME.get(), Type.MOUNTAIN, Type.OVERWORLD);
		registerBiome(MUSPELHEIM_ASH_PLAINS.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(MUSPELHEIM_PLAINS.get(), Type.PLAINS, Type.OVERWORLD);
	}

	private static void registerBiome(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}


}
