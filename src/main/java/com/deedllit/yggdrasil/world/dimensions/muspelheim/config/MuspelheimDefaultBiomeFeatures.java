package com.deedllit.yggdrasil.world.dimensions.muspelheim.config;

import java.util.OptionalInt;

import com.deedllit.yggdrasil.init.BlockInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.FrequencyConfig ;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

public class MuspelheimDefaultBiomeFeatures {
	
	//field_236291_c_,TREE,2,,net/minecraft/world/gen/feature/Feature
	
	//public static final LiquidsConfig ACIDIC_SPRING_CONFIG = new LiquidsConfig(FluidInit.ACIDIC_FLOWING.get().getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get()));
	public static final LiquidsConfig WATER_SPRING_CONFIG = new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get()));
	public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get(), BlockInit.MUSPELHEIM_COLD_ROCK.get(), BlockInit.MUSPELHEIM_HOT_ROCK.get()));

	public static int SKY_COLOR = 6684672 ; 
	
	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	private static final BlockState SULFUR = BlockInit.SULFUR_BLOCK.get().getDefaultState() ; 
	private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
	private static final BlockState HOT_ROCK = BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState();
	private static final BlockState ASH = BlockInit.MUSPELHEIM_ASH.get().getDefaultState();
	private static final BlockState DRAGON_GRASS = BlockInit.MUSPELHEIM_DRAGON_GRASS.get().getDefaultState();
	private static final BlockState SLIM_GRASS = BlockInit.MUSPELHEIM_SLIM_GRASS.get().getDefaultState();
	private static final BlockState FIRE_POPPY = BlockInit.MUSPELHEIM_FIRE_POPPY.get().getDefaultState() ;  
	private static final BlockState MUSPELHEIM_GRASS = BlockInit.MUSPELHEIM_GRASS.get().getDefaultState() ; 
	private static final BlockState EPLUPHIFER_LOG = BlockInit.MUSPELHEIM_EPLUPHIFER_LOG.get().getDefaultState() ; 
	private static final BlockState EPLUPHIFER_SICK_LOG = BlockInit.MUSPELHEIM_EPLUPHIFER_SICK_LOG.get().getDefaultState() ; 
	private static final BlockState EPLUPHIFER_LEAVES = BlockInit.MUSPELHEIM_EPLUPHIFER_LEAVES.get().getDefaultState() ; 
	private static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
	private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
	private static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
	private static final BlockState REDSTONE_ORE = Blocks.REDSTONE_ORE.getDefaultState();
	private static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState();
	private static final BlockState LAPIS_ORE = Blocks.LAPIS_ORE.getDefaultState();
	
	public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig DRAGON_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DRAGON_GRASS), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig SLIM_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SLIM_GRASS), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig FIRE_POPPY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FIRE_POPPY), new SimpleBlockPlacer())).tries(32).build();
 	
	private static final BeehiveTreeDecorator BEEHIVES_CONFIG = new BeehiveTreeDecorator(0.05F);
	
	//Spruce style
	//public static final BaseTreeFeatureConfig EPLUPHIFER_TREE_NORMAL_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(EPLUPHIFER_LOG), new SimpleBlockStateProvider(EPLUPHIFER_LEAVES), new SpruceFoliagePlacer(2, 1, 0, 2, 1, 1), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).func_236700_a_().build();	
	//Small Oak Style
	public static final BaseTreeFeatureConfig EPLUPHIFER_SIKCK_TREE_NORMAL_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(EPLUPHIFER_SICK_LOG), new SimpleBlockStateProvider(EPLUPHIFER_LEAVES), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build();
	//Giant Oak Style
	public static final BaseTreeFeatureConfig EPLUPHIFER_FANCY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(EPLUPHIFER_LOG), new SimpleBlockStateProvider(EPLUPHIFER_LEAVES), new FancyFoliagePlacer(2, 0, 4, 0, 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).func_236700_a_().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
	public static final BaseTreeFeatureConfig EPLUPHIFER_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = EPLUPHIFER_FANCY_TREE_CONFIG.func_236685_a_(ImmutableList.of(BEEHIVES_CONFIG));

	
	public static final SurfaceBuilderConfig MAGMA_SURFACE = new SurfaceBuilderConfig(HOT_ROCK, HOT_ROCK, ASH);
	public static final SurfaceBuilderConfig MAGMA_SURFACE2 = new SurfaceBuilderConfig(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.BEDROCK.getDefaultState(), Blocks.BRICKS.getDefaultState());
		
	
	
	public static void addCavern(Biome biomeIn) {	
		/*
		float probability ; 

		
		probability = MuspelheimCavernConfig.INSTANCE.canyon.get().floatValue();

		
		if (probability > 0.0F)
		{
			biomeIn.addCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(CarverInit.CAVERN_CANYON.get(), new ProbabilityConfig(probability)));
		}
		*/
		
	}
	
	public static void addPlants(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SLIM_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DRAGON_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(FIRE_POPPY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	}

	public static void addExtraPoppy(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(FIRE_POPPY_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));		
	}
	
	public static void addSickTree(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.RANDOM_SELECTOR.withConfiguration(
						new MultipleRandomFeatureConfig(
								ImmutableList.of(Feature.field_236291_c_
										.withConfiguration(EPLUPHIFER_SIKCK_TREE_NORMAL_CONFIG)
										.withChance(0.666F), Feature.field_236291_c_
										.withConfiguration(EPLUPHIFER_FANCY_TREE_CONFIG)
										.withChance(0.1F)), 
								Feature.field_236291_c_.withConfiguration(EPLUPHIFER_SIKCK_TREE_NORMAL_CONFIG)))
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
						.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
	}
	
	public static void addHealthyTree(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(EPLUPHIFER_FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));		
	}
	
	public static void addTrees(Biome biomeIn) {
		MuspelheimDefaultBiomeFeatures.addSickTree(biomeIn) ; 
		MuspelheimDefaultBiomeFeatures.addHealthyTree(biomeIn) ; 
	}
	
	
	/*
	 *      
biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.field_236291_c_.withConfiguration(FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(0.33333334F)), Feature.field_236291_c_.withConfiguration(OAK_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(PLAINS_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
      biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));

	 */
	
	
	public static void addLakes(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
	}
   
	
	public static void addSprings(Biome biomeIn) {				   
	   	//biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(ACIDIC_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 16, 256))));		
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 8, 256))));
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 16, 256))));
   	}
   
	public static void addVanillaOres(Biome biomeIn) {
	   	biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, COAL_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));
	    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, IRON_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 64))));
	    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GOLD_ORE, 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(2, 0, 0, 32))));
	    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 16))));
	    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIAMOND_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 16))));
	    biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LAPIS_ORE, 7)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(1, 16, 16))));		
	}
	
   	public static void addOres(Biome biomeIn) {
	   	biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.KIMBERLITE_ORE.get().getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));		   	
   	}
   
	
   	public static void addCarvers(Biome biomeIn) {
        biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
        biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.02F)));
   	}
   
   	
   	public static void addDeadBushes(Biome biomeIn) {
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
   	}

   	/*
    public static void addSedimentDisks(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(SULFUR, 7, 2, Lists.newArrayList(BlockInit.MUSPELHEIM_GRASS.get().getDefaultState(), BlockInit.MUSPELHEIM_ASH.get().getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(20))));
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(GRAVEL, 7, 2, Lists.newArrayList(BlockInit.MUSPELHEIM_GRASS.get().getDefaultState(), BlockInit.MUSPELHEIM_ASH.get().getDefaultState()))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(2))));
     }
   	
    public static void addDenseGrass(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
     }

    
    public static void addSickTrees(Biome biomeIn) {
    	
    	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(EpluphiferTree.EPLUPHIFER_TREE_SICK).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.2f, 1))));	

    	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(EpluphiferTree.EPLUPHIFER_TREE_NORMAL).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));	
      	
    }
    
    public static void addStructures(Biome biomeIn) {    	
    	biomeIn.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StructureInit.YGGDRASIL_TREE_STRUCTURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.2f, 1)))) ; 
    }
    */
    
}
