package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MidgardRainbowMoutainBiome extends Biome {

	public MidgardRainbowMoutainBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.RAINBOW, SurfaceBuilder.RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.DESERT)
	    		  .depth(0.45F)
	    		  .scale(0.3F)
	    		  .temperature(0.75F)
	    		  .downfall(0.6F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent((String) null ));
	      
		}

}
