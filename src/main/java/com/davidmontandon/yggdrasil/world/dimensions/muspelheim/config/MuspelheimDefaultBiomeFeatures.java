package com.davidmontandon.yggdrasil.world.dimensions.muspelheim.config;

import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.init.FluidInit;
import com.davidmontandon.yggdrasil.init.StructureInit;
import com.davidmontandon.yggdrasil.world.dimensions.muspelheim.generator.MuspelheimVolcanoSurfaceBuilder;
import com.davidmontandon.yggdrasil.world.dimensions.muspelheim.generator.MuspelheimVolcanoTopLayerSurfaceBuilder;
import com.davidmontandon.yggdrasil.world.feature.tree.EpluphiferTree;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MuspelheimDefaultBiomeFeatures {
	
	//public static final LiquidsConfig ACIDIC_SPRING_CONFIG = new LiquidsConfig(FluidInit.ACIDIC_FLOWING.get().getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get()));
	public static final LiquidsConfig WATER_SPRING_CONFIG = new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get()));
	public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, BlockInit.MUSPELHEIM_ASH.get(), BlockInit.MUSPELHEIM_GRASS.get(), BlockInit.MUSPELHEIM_COLD_ROCK.get(), BlockInit.MUSPELHEIM_HOT_ROCK.get()));

	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	private static final BlockState SULFUR = BlockInit.SULFUR_BLOCK.get().getDefaultState() ; 
	private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
	private static final BlockState HOT_ROCK = BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState();
	private static final BlockState ASH = BlockInit.MUSPELHEIM_ASH.get().getDefaultState();
	
	public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
	
	public static final SurfaceBuilder<SurfaceBuilderConfig> VOLCANO_SURFACE_BUILDER = new MuspelheimVolcanoSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> VOLCANO_TOP_LAYER_SURFACE_BUILDER = new MuspelheimVolcanoTopLayerSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	public static final SurfaceBuilderConfig MAGMA_SURFACE = new SurfaceBuilderConfig(HOT_ROCK, HOT_ROCK, ASH);
	public static final SurfaceBuilderConfig MAGMA_SURFACE2 = new SurfaceBuilderConfig(Blocks.DIAMOND_BLOCK.getDefaultState(), Blocks.BEDROCK.getDefaultState(), Blocks.BRICKS.getDefaultState());
		
	
	
	public static void addLakes(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
	}
   
	public static void addSprings(Biome biomeIn) {				   
	   	//biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(ACIDIC_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 16, 256))));
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 8, 256))));
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(50, 8, 16, 256))));
   	}
   
   	public static void addOres(Biome biomeIn) {
	   	biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.KIMBERLITE_ORE.get().getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));		
   	}
   
   	public static void addCarver(Biome biomeIn) {
	   	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
	   	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.20f)));		
	   	biomeIn.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.20F)));
   	}
   
   	public static void addDeadBushes(Biome biomeIn) {
	   	biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
   	}

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
	   
}
