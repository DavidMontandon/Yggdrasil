package com.davidmontandon.yggdrasil.world.biome.general;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.List;

public interface ConfigurableBiome {

    <C extends ICarverConfig> void add(GenerationStage.Carving stage, ConfiguredCarver<C> carver);
    <C extends IFeatureConfig> void add(ConfiguredFeature<C, ? extends Structure<C>> structure);
    void add(EntityClassification classification, Biome.SpawnListEntry entry);
    
	List<Biome.SpawnListEntry> getSpawnsFor(EntityClassification classification);
}
