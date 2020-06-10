package com.davidmontandon.yggdrasil.world.muspelheim.biomes;

import java.util.Collection;
import java.util.List;

import com.davidmontandon.yggdrasil.world.biome.general.ConfigurableBiome;
import com.davidmontandon.yggdrasil.world.biome.general.surface.SurfaceBiome;
import com.davidmontandon.yggdrasil.world.muspelheim.config.MuspelheimSurfaceBuilders;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.GenerationStage.Carving;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

public class MuspelheimForest extends SurfaceBiome implements ConfigurableBiome {

	
	/*
	public MuspelheimForest() {
        super(new Properties(
                .surfaceBuilder(MuspelheimSurfaceBuilders.MUSPELHEIM_GRASS_CONFIG, MuspelheimSurfaceBuilders.MUSPELHEIM_GRASS_CONFIG)
                .category(Category.FOREST)
                .grassColor(0x695F8C)
                .depth(0.155F)
                .scale(0.07F)
                .fog(0.1F, 80.0F)) ;

	}
	*/
	
	public MuspelheimForest(Properties properties) {
		super(properties);
	}

	
	

	@Override
	public void add(EntityClassification classification, SpawnListEntry entry) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void generateSurface(SharedSeedRandom random, IChunk chunk, int x, int z, int y, double depth,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Collection<ConfiguredCarver<?>> getCarversFor(Carving stage) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<SpawnListEntry> getSpawnsFor(EntityClassification classification) {
		// TODO Auto-generated method stub
		return null;
	}

}
