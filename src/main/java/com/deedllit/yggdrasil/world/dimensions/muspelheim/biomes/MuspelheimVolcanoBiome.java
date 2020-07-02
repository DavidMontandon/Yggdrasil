package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;
import com.google.common.collect.ImmutableList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MuspelheimVolcanoBiome extends Biome { 
	
	public MuspelheimVolcanoBiome(Builder biomeBuilder) {
		
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.6F).downfall(0.6F).func_235097_a_((new BiomeAmbience.Builder()).func_235246_b_(4159204).func_235248_c_(329011).func_235239_a_(12638463).func_235243_a_(MoodSoundAmbience.field_235027_b_).func_235238_a_()).parent((String)null).func_235098_a_(ImmutableList.of(new Biome.Attributes(-0.1F, 0.2F, 0.0F, 0.0F, 1.0F))));

		
		/*
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
			*/
		
		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);
		MuspelheimDefaultBiomeFeatures.addSedimentDisks(this);
		MuspelheimDefaultBiomeFeatures.addStructures(this);

	}

}
