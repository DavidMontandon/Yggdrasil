package com.deedllit.yggdrasil.world.dimensions.asgard.biomes;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class AsgardMountainsBiome extends Biome {

	public AsgardMountainsBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.FLOATING_ISLAND_MOUTAIN, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.EXTREME_HILLS)
	    		  .depth(-1.8F)
	    		  .scale(1.75F)
	    		  .temperature(0.5F)
	    		  .downfall(0.3F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent((String)null));
	      
	} 

	
	
}
