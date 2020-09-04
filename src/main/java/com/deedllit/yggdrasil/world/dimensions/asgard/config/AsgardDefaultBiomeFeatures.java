package com.deedllit.yggdrasil.world.dimensions.asgard.config;

import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.world.feature.asgard.flowers.AsgardFlowerBlockStateProvider;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.MultipleWithChanceRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

public class AsgardDefaultBiomeFeatures {

    private static final BlockState RED_SUNFLOWER = BlockInit.PURPLE_SUNFLOWER.get().getDefaultState();
    private static final BlockState PURPLE_SUNFLOWER = BlockInit.PURPLE_SUNFLOWER.get().getDefaultState();
    private static final BlockState ELM_LOG = BlockInit.ELM_LOG.get().getDefaultState();
    private static final BlockState ASH_LOG = BlockInit.ASH_LOG.get().getDefaultState();

    private static final BlockState STONE = Blocks.STONE.getDefaultState() ; 
    private static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState() ; 
    private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState() ; 
    private static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState() ; 
    private static final BlockState EMERALD_ORE = Blocks.EMERALD_ORE.getDefaultState() ; 
    private static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState() ; 
    private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState() ; 
    private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState() ; 
    private static final BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState() ; 
    private static final BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState() ; 
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState() ; 
    private static final BlockState SPRUCE_LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState() ; 
    private static final BlockState PODZOL = Blocks.PODZOL.getDefaultState() ; 
    private static final BlockState LARGE_FERN = Blocks.LARGE_FERN.getDefaultState() ; 
    private static final BlockState LILAC = Blocks.LILAC.getDefaultState();
    private static final BlockState PEONY = Blocks.PEONY.getDefaultState();
    private static final BlockState WATER = Blocks.WATER.getDefaultState();
    
    
    public static final BlockClusterFeatureConfig PINK_MANGENTA_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new AsgardFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    private static final BlockClusterFeatureConfig RED_SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_SUNFLOWER), new DoublePlantBlockPlacer())).tries(16).func_227317_b_().build();
    private static final BlockClusterFeatureConfig PURPLE_SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PURPLE_SUNFLOWER), new DoublePlantBlockPlacer())).tries(16).func_227317_b_().build();
    private static final TreeFeatureConfig ASH_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ASH_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    private static final TreeFeatureConfig ELM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ELM_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    
    private static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LARGE_FERN), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final TreeFeatureConfig BIRCH_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    private static final TreeFeatureConfig OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    private static final TreeFeatureConfig SPRUCE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new SpruceFoliagePlacer(2, 1))).baseHeight(6).heightRandA(3).trunkHeight(1).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final TreeFeatureConfig PINE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new PineFoliagePlacer(1, 0))).baseHeight(7).heightRandA(4).trunkTopOffset(1).foliageHeight(3).foliageHeightRandom(1).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final HugeTreeFeatureConfig MEGA_BIRCH_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES))).baseHeight(13).heightInterval(15).crownHeight(13).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final HugeTreeFeatureConfig MEGA_OAK_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES))).baseHeight(13).heightInterval(15).crownHeight(13).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final HugeTreeFeatureConfig MEGA_SPRUCE_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES))).baseHeight(13).heightInterval(15).crownHeight(13).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final HugeTreeFeatureConfig MEGA_PINE_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES))).baseHeight(13).heightInterval(15).crownHeight(13).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
    private static final BlockClusterFeatureConfig LILAC_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILAC), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final BlockClusterFeatureConfig PEONY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PEONY), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    private static final TreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(0, 0))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    public static final TreeFeatureConfig OAK_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();


    
    public static void addMoreLakes(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(1))));    	
    }
    
    public static void addPinkMangentaFlowers(Biome biomeIn) {    	
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(PINK_MANGENTA_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
        //biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.withConfiguration(LILAC_CONFIG), Feature.RANDOM_PATCH.withConfiguration(PEONY_CONFIG)), 0)).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
    }

    public static void addOakTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
    }
    
	public static void addOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
	}
	
	public static void addSparseAshTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(ASH_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addSparseElmTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(ELM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addSparseOakTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addScatteredSpruceTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
	}

	public static void addLargeFern(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
	}
	
	public static void addGiantBirchTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_BIRCH_TREE_CONFIG).withChance(0.33333334F), Feature.NORMAL_TREE.withConfiguration(BIRCH_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(BIRCH_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addGiantOakTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_OAK_TREE_CONFIG).withChance(0.33333334F), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addGiantSpruceTaigaTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.33333334F), Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	public static void addGiantTreeTaigaTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.025641026F), Feature.MEGA_SPRUCE_TREE.withConfiguration(MEGA_PINE_TREE_CONFIG).withChance(0.30769232F), Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}

	
	public static void addEmeraldOre(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(STONE, EMERALD_ORE)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}

	public static void addDiamondOre(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(STONE, DIAMOND_ORE)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
	
	public static void addSunFlowers(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PURPLE_SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(10))));
	}
	
	public static void addExtraRedSunFlower(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(10))));
	}
	
	public static void addExtraPurpleSunFlower(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PURPLE_SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(10))));
	}
	
	
	
}
