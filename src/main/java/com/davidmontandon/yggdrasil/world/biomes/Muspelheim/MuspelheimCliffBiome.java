package com.davidmontandon.yggdrasil.world.biomes.Muspelheim;

import com.davidmontandon.yggdrasil.init.BlockInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class MuspelheimCliffBiome  extends Biome {
	//DefaultBiomeFeatures (CTRl+CLICK)
	
	public MuspelheimCliffBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10)) ; 
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.02f)));
		
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.VANAFREINTINE_ORE.get().getDefaultState(), 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));		
				
	}
	


}