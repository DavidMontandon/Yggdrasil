package com.deedllit.yggdrasil.world.dimensions.asgard.generator;

import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.GenerationSettings;

public class AsgardGenSettings extends GenerationSettings{

	public AsgardGenSettings() {		
		this.setDefaultBlock( Blocks.STONE.getDefaultState());
		this.setDefaultFluid( Fluids.WATER.getDefaultState().getBlockState() );
	}
	
	public int getBiomeSize() {
		return 16;
	}

	public int getRiverSize() {
		return 8;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
}
