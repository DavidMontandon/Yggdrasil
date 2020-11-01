package com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes;

import com.deedllit.mythologycraft.world.biome.MythologycraftBiome;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.config.NifelheimDefaultBiomeFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class NifelheimForzenPlainBiome extends MythologycraftBiome {

	public NifelheimForzenPlainBiome() {
		super(new Biome.Builder()		
			.precipitation(RainType.SNOW)
			.waterColor(3750089)
			.waterFogColor(329011)
			.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
			.category(Category.PLAINS)
			.depth(0.2f)
			.scale(0.1f)
			.temperature(0.0f)
			.downfall(0.5f)
			.parent(null));
				
		NifelheimDefaultBiomeFeatures.addCarvers(this);
		NifelheimDefaultBiomeFeatures.addLakes(this);
		NifelheimDefaultBiomeFeatures.addStoneVariants(this) ; 
		NifelheimDefaultBiomeFeatures.addOres(this) ; 
		NifelheimDefaultBiomeFeatures.addSedimentDisks(this);
		NifelheimDefaultBiomeFeatures.addSprings(this);
		NifelheimDefaultBiomeFeatures.addFreezeTopLayer(this);

		//this.setSpwanWeight(2);
		
	}
	

	
}
