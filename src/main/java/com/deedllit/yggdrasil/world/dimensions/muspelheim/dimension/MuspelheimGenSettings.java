package com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension;

import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.FluidInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.NetherGenSettings;

public class MuspelheimGenSettings extends GenerationSettings{

	public MuspelheimGenSettings() {		
		//this.setDefaultBlock( Blocks.STONE.getDefaultState());
		this.setDefaultBlock( BlockInit.MUSPELHEIM_STONE.get().getDefaultState().getBlockState() );
		this.setDefaultFluid( Fluids.LAVA.getDefaultState().getBlockState() );
		//this.setDefaultFluid( FluidInit.ACIDIC_FLUID.get().getDefaultState().getBlockState() );
	}
	
	public int getBiomeSize() {
		return 16;
	}

	public int getRiverSize() {
		return 1;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
	
}
