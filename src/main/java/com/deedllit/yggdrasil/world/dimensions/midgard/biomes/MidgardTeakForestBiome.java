package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.common.biome.MythologycraftBiome;
import com.deedllit.yggdrasil.common.biome.MythologycraftClimates;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardTeakForestBiome extends MythologycraftBiome {

	public MidgardTeakForestBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
		  	.precipitation(Biome.RainType.RAIN)
		  	.category(Biome.Category.FOREST)
		  	.depth(0.25F)
		  	.scale(0.05F)
		  	.temperature(0.8F)
		  	.downfall(0.3F)
		  	.waterColor(6388580)
		  	.waterFogColor(2302743)
		  	.parent((String)null));

	      this.addWeight(MythologycraftClimates.SUBTROPICAL, 5);	      
		}
	      
  	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	    return d0 < -0.1D ? 10066176 : 10526720;

  	}

}
