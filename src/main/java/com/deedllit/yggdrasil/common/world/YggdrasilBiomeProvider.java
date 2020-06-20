package com.deedllit.yggdrasil.common.world;

import java.util.Set;

import com.deedllit.yggdrasil.common.biome.BiomeLayers;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

/*
 * Strongly inspired by The-MidNight Mod (https://github.com/Cryptic-Mushroom/The-Midnight)  
 */


public class YggdrasilBiomeProvider extends BiomeProvider {

	private final BiomeLayers<Biome> layers;
	
	//TODO
	private static final Set<Biome> biomes = null ; 
	
		
	protected YggdrasilBiomeProvider(BiomeLayers<Biome> layers) {
		super(biomes);
		this.layers = layers;
	}

	    @Override
	    public Biome getNoiseBiome(int x, int y, int z) {
	        return this.layers.noise.sample(x, z);
	    }

	    @Override
	    public boolean hasStructure(Structure<?> structure) {
	        return this.hasStructureCache.computeIfAbsent(structure, s -> {
	        	
	        	//TODO 
	        	return null ;
	        	
	        		/*
	            return MidnightSurfaceBiomes.allBiomes()
	                    .anyMatch(biome -> biome.hasStructure(s));
	                    */
	        });
	    }

	    @Override
	    public Set<BlockState> getSurfaceBlocks() {
	    	
	    	//TODO
	    	
	    	/*
	        if (this.topBlocksCache.isEmpty()) {
	            MidnightSurfaceBiomes.allBiomes().forEach(biome -> {
	                this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
	            });
	        }
	            */
	        return this.topBlocksCache;
	    }

	
}
