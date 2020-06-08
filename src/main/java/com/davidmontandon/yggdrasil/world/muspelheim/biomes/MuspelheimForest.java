package com.davidmontandon.yggdrasil.world.muspelheim.biomes;

import com.davidmontandon.yggdrasil.world.biome.general.surface.SurfaceBiome;
import com.davidmontandon.yggdrasil.world.muspelheim.config.MuspelheimSurfaceBuilders;

public class MuspelheimForest extends SurfaceBiome {

	/*
	public MuspelheimForest() {
        super(new Properties()
                .surfaceBuilder(MuspelheimBiomeGroup.SURFACE, MuspelheimSurfaceBuilders.MUSPELHEIM_GRASS_CONFIG)
                .category(Category.FOREST)
                .grassColor(0x695F8C)
                .depth(0.155F)
                .scale(0.07F)
                .fog(0.1F, 80.0F)

	}
	*/
	
	public MuspelheimForest(Properties properties) {
		super(properties);
	}

}
