package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.common.biome.MythologycraftBiome;
import com.deedllit.yggdrasil.init.CarverInit;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.GenerationStage;

public class MuspelheimAshPlainsBiome extends MythologycraftBiome {

	public MuspelheimAshPlainsBiome(Builder biomeBuilder) {
		super(new Biome.Builder()		
				.precipitation(RainType.NONE)
				.waterColor(0x906B9F)
				.waterFogColor(0x6E5651)
				.surfaceBuilder(SurfaceBuilder.DEFAULT, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_ASH_COLDROCK_SAND)
				.category(Category.PLAINS)
				.depth(0.2f)
				.scale(0.5f)
				.temperature(2.0f)
				.downfall(0.0f)
				.parent(null));
		
		
		//this.addCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(CarverInit.CAVERN_CANYON.get(), new ProbabilityConfig(probability

		//MuspelheimDefaultBiomeFeatures.addCavern(this); 
		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);
		MuspelheimDefaultBiomeFeatures.addSedimentDisks(this);
		MuspelheimDefaultBiomeFeatures.addStructures(this);
		MuspelheimDefaultBiomeFeatures.addSickTrees(this); 
		MuspelheimDefaultBiomeFeatures.addDeadBushes(this) ; 

	}
	
}