package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.SurfaceBuilderInit;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.MidgardDefaultBiomeFeatures;
import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class MidgardVolcanicIslandBiome extends Biome {

	public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, BlockInit.MUSPELHEIM_ASH.get()));

	public MidgardVolcanicIslandBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.BLACK_SAND_ISLAND, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.OCEAN)
	    		  .depth(-1.8F)
	    		  .scale(0.3F)
	    		  .temperature(0.5F)
	    		  .downfall(0.5F)
	    		  .waterColor(9428950)
	    		  .waterFogColor(270131)
	    		  .parent((String) null));
	    		  
	      this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(10))));
	      
	      DefaultBiomeFeatures.addOceanCarvers(this);
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      	      
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_VERY_BIASED_RANGE.configure(new CountRangeConfig(20, 8, 16, 256))));
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(48, 0.3D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	      DefaultBiomeFeatures.addSeagrass(this);
	      DefaultBiomeFeatures.addExtraKelp(this);
	      DefaultBiomeFeatures.addFreezeTopLayer(this);
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 1, 1, 4));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 10, 3, 6));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.DOLPHIN, 1, 1, 2));

	}

}
