package com.deedllit.midgard.world.dimension.midgard.generator.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

import java.util.Optional;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;

public enum MidgardBiomeEdgeLayer implements ICastleTransformer {
	INSTANCE;

	
	private static final int DESERT = Registry.BIOME.getId(BiomeInit.VANILLA_DESERT_BIOME.get());
	
	@Override
	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {

		int[] outBiomeId = new int[1];

		
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				BiomeInit.MIDGARD_TROPICAL_ISLAND_BIOME.get(), BiomeInit.VANILLA_DEEP_WARM_OCEAN_BIOME.get())) {
			
			Yggdrasil.LOGGER.info("Edge Layer MIDGARD_TROPICAL_ISLAND_BIOME <---> VANILLA_DEEP_WARM_OCEAN_BIOME" );
			
			return outBiomeId[0];
		}		
		
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				BiomeInit.MIDGARD_VOLCANIC_ISLAND_BIOME.get(), BiomeInit.VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get())) {

			Yggdrasil.LOGGER.info("Edge Layer MIDGARD_VOLCANIC_ISLAND_BIOME <---> VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME" );

			return outBiomeId[0];
		}		
		
		
		if( center == DESERT ) {
			
			Yggdrasil.LOGGER.info("Edge Layer CHECK DESERT" );
			
		}
		
		
		return center;
	}
	
    private boolean replaceBiomeEdge(int[] outId, int north, int west, int south, int east, int center, Biome fromBiome, Biome toBiome) {
        return this.replaceBiomeEdge(outId, north, west, south, east, center, Registry.BIOME.getId(fromBiome), Registry.BIOME.getId(toBiome));
    }

	boolean replaceBiomeEdge(int[] outId, int north, int west, int south, int east, int center, int from, int to) {
		if (center != from) {
			return false;
		} else {
			if (LayerUtil.areBiomesSimilar(north, from) && LayerUtil.areBiomesSimilar(east, from)
					&& LayerUtil.areBiomesSimilar(west, from) && LayerUtil.areBiomesSimilar(south, from)) {
				outId[0] = center;
			} else {
				outId[0] = to;
			}

			return true;
		}	

	}

}
