package com.deedllit.yggdrasil.common.world;

import com.deedllit.yggdrasil.common.biome.BiomeLayers;
import com.deedllit.yggdrasil.common.biome.cavern.CavernousBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.*;

/*
 * Strongly inspired by The-MidNight Mod (https://github.com/Cryptic-Mushroom/The-Midnight)  
 */

public class YggdrasilChuckGenerator extends NoiseChunkGenerator<YggdrasilChuckGenerator.Config> {

	private static final int HORIZONTAL_GRANULARITY = 0;
	private static final int VERTICAL_GRANULARITY = 0;
	private int surfaceLevel ; 
	private int seaLevel ;
	private int minCaveHeight ; 
	private int maxCaveHeight ; 
	
	private final World world = null;
	
    private final BiomeLayers<Biome> surfaceLayers = null ;
    private final BiomeLayers<Biome> undergroundLayers = null;
	
    public YggdrasilChuckGenerator(World world, BiomeLayers<Biome> surfaceLayers, BiomeLayers<CavernousBiome> undergroundLayers, Config config) {
    	
		//TODO
        super(world, null, HORIZONTAL_GRANULARITY, VERTICAL_GRANULARITY, 256, config, true);
    	
        
    }
    
    
	public void setSurfaceLevel(int surfaceLevel) {
		this.surfaceLevel = surfaceLevel ; 
	}
	
	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel ; 
	}

	public void setMinCaveHeight(int minCaveHeight) {
		this.minCaveHeight = minCaveHeight ; 
	}

	public void setMaxCaveHeight(int maxCaveHeight) {
		this.maxCaveHeight = maxCaveHeight ; 
	}

	
	@Override
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGroundHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
    public static class Config extends GenerationSettings {
        public static Config createDefault() {
            Config config = new Config();
            config.setDefaultBlock(Blocks.GRASS_BLOCK.getDefaultState());
            config.setDefaultFluid(Blocks.WATER.getDefaultState());

            return config;
        }
    }

}
