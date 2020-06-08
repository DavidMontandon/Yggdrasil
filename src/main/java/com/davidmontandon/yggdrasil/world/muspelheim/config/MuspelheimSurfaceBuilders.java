package com.davidmontandon.yggdrasil.world.muspelheim.config;

import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.world.biome.general.LayeredSurfaceBuilder;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public final class MuspelheimSurfaceBuilders {
	
    public static final SurfaceBuilder<SurfaceBuilderConfig> SURFACE = new LayeredSurfaceBuilder(SurfaceBuilderConfig::deserialize, 0, 0);

    public static final SurfaceBuilder<SurfaceBuilderConfig> CAVERN = new LayeredSurfaceBuilder(SurfaceBuilderConfig::deserialize, 1, Integer.MAX_VALUE)
            .withMaxY(255);
    
    public static final SurfaceBuilderConfig MUSPELHEIM_GRASS_CONFIG = new SurfaceBuilderConfig(
    		BlockInit.MUSPELHEIM_GRASS.get().getDefaultState(),
    		BlockInit.MUSPELHEIM_ASH.get().getDefaultState(),
    		Blocks.SAND.getDefaultState()
    );
   

}
