package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class HighRockBiome extends Biome {

	public HighRockBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.DEEP_TOP, SurfaceBuilder.SAND_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.OCEAN)
	    		  .depth(-1.8F)
	    		  .scale(0.1F)
	    		  .temperature(0.80F)
	    		  .downfall(0.3F)
	    		  .waterColor(6388580)
	    		  .waterFogColor(2302743)
	    		  .parent((String) null));
		
		
		//super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder(BOPBiomeFeatures.VOLCANO_SURFACE_BUILDER, BOPBiomeFeatures.ASH_SURFACE)).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.NONE).depth(4.5F).scale(0.0F).temperature(0.95F).downfall(0.3F).waterColor(4566514).waterFogColor(267827).parent((String)null));
	}

	
	
}
