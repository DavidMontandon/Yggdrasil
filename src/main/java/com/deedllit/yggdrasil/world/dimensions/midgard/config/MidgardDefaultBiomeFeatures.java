package com.deedllit.yggdrasil.world.dimensions.midgard.config;

import com.deedllit.yggdrasil.init.BlockInit;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleWithChanceRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class MidgardDefaultBiomeFeatures {

	private static final BlockState WHITE_POMELIA_BLOCK = BlockInit.MIDGARD_WHITE_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState PINK_POMELIA_BLOCK = BlockInit.MIDGARD_PINK_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState ORANGE_POMELIA_BLOCK = BlockInit.MIDGARD_ORANGE_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();
    private static final BlockState LILY_PAD = Blocks.LILY_PAD.getDefaultState();
    private static final BlockState BLUE_ORCHID = Blocks.BLUE_ORCHID.getDefaultState();
    private static final BlockState GRASS = Blocks.GRASS.getDefaultState() ; 
    private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState() ; 
    private static final BlockState RED_MUSHROOM = Blocks.RED_MUSHROOM.getDefaultState() ; 
    private static final BlockState BROWN_MUSHROOM = Blocks.BROWN_MUSHROOM.getDefaultState() ; 
    private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState() ; 
    private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState() ; 
    
	public static final BlockClusterFeatureConfig WHITE_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PINK_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PINK_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig ORANGE_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ORANGE_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), SimpleBlockPlacer.field_236447_c_)).tries(64).build();
	public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), SimpleBlockPlacer.field_236447_c_)).tries(32).build();
	public static final BlockClusterFeatureConfig BLUE_ORCHID_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BLUE_ORCHID), SimpleBlockPlacer.field_236447_c_)).tries(64).build();
	public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), SimpleBlockPlacer.field_236447_c_)).tries(4).build();
    public static final BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_PAD), SimpleBlockPlacer.field_236447_c_)).tries(10).build();
    public static final BlockClusterFeatureConfig RED_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MUSHROOM), SimpleBlockPlacer.field_236447_c_)).tries(64).func_227317_b_().build();
    public static final BlockClusterFeatureConfig BROWN_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BROWN_MUSHROOM), SimpleBlockPlacer.field_236447_c_)).tries(64).func_227317_b_().build();

    public static final BaseTreeFeatureConfig SWAMP_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(3, 0, 0, 0, 3), new StraightTrunkPlacer(5, 3, 0), new TwoLayerFeature(1, 0, 1))).func_236701_a_(1).func_236703_a_(ImmutableList.of(LeaveVineTreeDecorator.field_236871_b_)).build();

	public static void addMangroveExtraPomelias(Biome biomeIn) {	
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(ORANGE_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(3))));

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(PINK_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(2))));
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(WHITE_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(1))));		
	}
	
		
	public static void addMangroveVegetation(Biome biomeIn) {	
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(
						Feature.RANDOM_PATCH.withConfiguration(ORANGE_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(PINK_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(WHITE_POMELIA_CONFIG), 
						Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)), 0))
				.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
		

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(SWAMP_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 0))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(8, 0.125F))));

		
		
	}
	
	
}
