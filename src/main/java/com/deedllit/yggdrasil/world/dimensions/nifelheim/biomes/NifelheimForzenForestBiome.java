package com.deedllit.yggdrasil.world.dimensions.nifelheim.biomes;

import com.deedllit.mythologycraft.world.biome.MythologycraftBiome;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.config.NifelheimDefaultBiomeFeatures;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class NifelheimForzenForestBiome extends MythologycraftBiome {
	
	public NifelheimForzenForestBiome() {
		super(new Biome.Builder()		
				.precipitation(RainType.SNOW)
				.waterColor(4159204)
				.waterFogColor(329011)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
				.category(Category.EXTREME_HILLS)
				.depth(0.25f)
				.scale(0.15f)
				.temperature(0.0f)
				.downfall(0.55f)
				.parent(null));
					
			NifelheimDefaultBiomeFeatures.addCarvers(this);
			NifelheimDefaultBiomeFeatures.addLakes(this);
			NifelheimDefaultBiomeFeatures.addStoneVariants(this) ; 
			NifelheimDefaultBiomeFeatures.addOres(this) ; 
			NifelheimDefaultBiomeFeatures.addSedimentDisks(this);
			NifelheimDefaultBiomeFeatures.addSprings(this);
			NifelheimDefaultBiomeFeatures.addFreezeTopLayer(this);

		}

	

	
}
