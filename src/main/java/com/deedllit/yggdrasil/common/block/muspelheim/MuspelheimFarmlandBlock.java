package com.deedllit.yggdrasil.common.block.muspelheim;

import com.deedllit.yggdrasil.common.block.YggdrasilFarmBlock;

import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;

public class MuspelheimFarmlandBlock extends YggdrasilFarmBlock {
	
	public MuspelheimFarmlandBlock(Properties builder) {
		super(builder, FluidTags.WATER, Blocks.BIRCH_WOOD.getDefaultState());
	}
			
}
