package com.deedllit.yggdrasil.world.dimensions.vanilla.config;

import com.deedllit.yggdrasil.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

public class VanillaDefaultBiomeFeatures {

    public static final BlockState RED_SUNFLOWER = BlockInit.RED_SUNFLOWER.get().getDefaultState();

	public static final BlockClusterFeatureConfig REDSUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_SUNFLOWER), new DoublePlantBlockPlacer())).tries(16).func_227317_b_().build();

	public static void addRedSunFlower(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(REDSUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
	}

		
	
}
