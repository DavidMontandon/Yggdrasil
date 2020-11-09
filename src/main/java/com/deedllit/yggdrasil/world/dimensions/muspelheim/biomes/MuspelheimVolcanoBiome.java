package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class MuspelheimVolcanoBiome extends Biome { 
	
	public MuspelheimVolcanoBiome(Builder biomeBuilder) {
		super(new Biome.Builder()		
			.precipitation(RainType.NONE)
			.waterColor(0x906B9F)
			.waterFogColor(0x6E5651)
			.surfaceBuilder(MuspelheimDefaultBiomeFeatures.VOLCANO_SURFACE_BUILDER, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_ASH_MAGMA_GRAVEL)
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

	@Override
	public Biome getRiver() {
		return ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_river")) ; 
	}

	
}
