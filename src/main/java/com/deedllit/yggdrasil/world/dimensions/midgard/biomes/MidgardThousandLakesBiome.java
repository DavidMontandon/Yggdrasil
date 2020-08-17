package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MidgardThousandLakesBiome extends Biome {

	public MidgardThousandLakesBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.HOLES, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.PLAINS)
	    		  .depth(-0.125F)
	    		  .scale(0.05F)
	    		  .temperature(0.80F)
	    		  .downfall(0.8F)
	    		  .waterColor(6388580)
	    		  .waterFogColor(2302743)
	    		  .parent((String) null));
	      
	      BlockState WATER = Blocks.WATER.getDefaultState();

	     // this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(1))));

	}

}
