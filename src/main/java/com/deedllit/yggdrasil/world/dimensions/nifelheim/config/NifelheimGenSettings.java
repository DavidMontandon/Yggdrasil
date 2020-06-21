package com.deedllit.yggdrasil.world.dimensions.nifelheim.config;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class NifelheimGenSettings extends GenerationSettings{

	public NifelheimGenSettings() {		
		this.setDefaultBlock( Blocks.STONE.getDefaultState());
		this.setDefaultFluid( Blocks.WATER.getDefaultState() );
	}
	
	public int getBiomeSize() {
		return 16;
	}

	public int getRiverSize() {
		return 16;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
}
