package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;

import net.minecraft.world.biome.Biome;

public class MuspelheimVolcanoBiome extends Biome { 
	
	public MuspelheimVolcanoBiome(Builder biomeBuilder) {
		super(new Biome.Builder()		
			.precipitation(RainType.NONE)
			.waterColor(0x906B9F)
			.waterFogColor(0x6E5651)
			.surfaceBuilder(MuspelheimDefaultBiomeFeatures.VOLCANO_SURFACE_BUILDER, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_HOTROCK_COLDROCK_SAND)
			.category(Category.NONE)
			.depth(4.5f)
			.scale(0.1f)
			.downfall(0.35f)
			.temperature(2.0f)
			.parent(null));
						
		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);
		MuspelheimDefaultBiomeFeatures.addSedimentDisks(this);
		MuspelheimDefaultBiomeFeatures.addStructures(this);

	}

}
