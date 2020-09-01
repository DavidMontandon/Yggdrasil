package com.deedllit.yggdrasil.common.biome;

import net.minecraftforge.common.BiomeManager.BiomeType;

public enum MythologycraftClimates {

	ALPINE (BiomeType.ICY),
	ARCTIC_CIRCLE (BiomeType.COOL),
    MEDITERRANEAN (BiomeType.WARM), 
    SUBTROPICAL (BiomeType.WARM),
    TEMPERATE_COOL (BiomeType.COOL),
    TEMPERATE_WARM (BiomeType.WARM),
    TROPICAL (BiomeType.DESERT) ; 
 
    public final BiomeType biomeType;
    
    MythologycraftClimates(BiomeType biomeType) {
        this.biomeType = biomeType;
    }
        
}
