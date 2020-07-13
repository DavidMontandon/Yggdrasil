package com.deedllit.yggdrasil.objects.blocks.crops;

import com.deedllit.yggdrasil.common.block.YggdrasilExtendableTopCrop;

import net.minecraft.block.Block;

public class RiceTopCropBlock extends YggdrasilExtendableTopCrop {

	public RiceTopCropBlock(Properties properties, Block[] canBePlacedOn, Block topBlock) {
		super(properties, canBePlacedOn, topBlock);
	}

	public RiceTopCropBlock(Properties properties, Block[] canBePlacedOn) {
		this(properties, canBePlacedOn, null);
	}

	
}
