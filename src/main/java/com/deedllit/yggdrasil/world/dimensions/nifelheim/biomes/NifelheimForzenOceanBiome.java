package com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes;

import com.deedllit.yggdrasil.common.biome.YggdrasilBiome;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.config.NifelheimDefaultBiomeFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class NifelheimForzenOceanBiome extends YggdrasilBiome {
	
	public NifelheimForzenOceanBiome(Builder biomeBuilder) {
		super(new Biome.Builder()		
				.precipitation(RainType.SNOW)
				.waterColor(3750089)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.category(Category.OCEAN)
				.depth(-1.25f)
				.scale(0.1f)
				.temperature(0.0f)
				.downfall(0.5f)
				.parent(null));
			DefaultBiomeFeatures.addOceanCarvers(this);
			DefaultBiomeFeatures.addIcebergs(this);
			//NifelheimDefaultBiomeFeatures.addCarvers(this);
			NifelheimDefaultBiomeFeatures.addLakes(this);
			DefaultBiomeFeatures.addBlueIce(this);
			NifelheimDefaultBiomeFeatures.addStoneVariants(this) ; 
			NifelheimDefaultBiomeFeatures.addOres(this) ; 
			NifelheimDefaultBiomeFeatures.addSedimentDisks(this);
			NifelheimDefaultBiomeFeatures.addSprings(this);
			NifelheimDefaultBiomeFeatures.addFreezeTopLayer(this);

		}
	

	
}
