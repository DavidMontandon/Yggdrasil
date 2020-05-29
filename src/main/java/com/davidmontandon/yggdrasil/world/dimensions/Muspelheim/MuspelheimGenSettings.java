package com.davidmontandon.yggdrasil.world.dimensions.Muspelheim;

import com.davidmontandon.yggdrasil.init.BlockInit;

import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.GenerationSettings;

public class MuspelheimGenSettings extends GenerationSettings{

	public MuspelheimGenSettings() {
		this.setDefaultBlock( BlockInit.MUSPELHEIM_STONE.get().getDefaultState().getBlockState() );
		this.setDefaultFluid( Fluids.LAVA.getDefaultState().getBlockState() );
	}
	
	public int getBiomeSize() {
		return 4;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
}
