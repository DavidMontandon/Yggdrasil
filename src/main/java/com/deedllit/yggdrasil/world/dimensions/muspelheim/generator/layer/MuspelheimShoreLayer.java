package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import com.deedllit.yggdrasil.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MuspelheimShoreLayer implements ICastleTransformer {
    INSTANCE;
	
	private static final int BEACH = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_BEACH_BIOME.get());
	private static final int PLAINS = Registry.BIOME.getId(BiomeInit.MUSPELHEIM_ASH_PLAINS_BIOME.get());
	private static final int FOREST= Registry.BIOME.getId(BiomeInit.MUSPELHEIM_PLAINS_BIOME.get());
	
	@Override
    public int apply(INoiseRandom context, int northBiomeId, int eastBiomeId, int southBiomeId, int westBiomeId, int biomeId)
    {
		
		Biome biome = Registry.BIOME.getByValue(biomeId);
		
		if (!MuspelheimLayerUtil.isOcean(biomeId) && (MuspelheimLayerUtil.isOcean(northBiomeId) || MuspelheimLayerUtil.isOcean(eastBiomeId)
				|| MuspelheimLayerUtil.isOcean(southBiomeId) || MuspelheimLayerUtil.isOcean(westBiomeId))) {
			return BEACH;
		}
		
		
		
		return biomeId ;
    }
}
