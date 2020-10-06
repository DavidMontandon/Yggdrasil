package com.deedllit.yggdrasil.world.dimensions.asgard.generator;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.EndGenerationSettings;

public class AsgardGenSettings extends EndGenerationSettings{

	public AsgardGenSettings() {		
        this.defaultBlock = Blocks.STONE.getDefaultState();
        this.defaultFluid = Blocks.AIR.getDefaultState() ;    
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
		return -10;
	}
	
}
