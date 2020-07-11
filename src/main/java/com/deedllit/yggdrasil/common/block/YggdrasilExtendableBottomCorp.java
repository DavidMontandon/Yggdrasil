package com.deedllit.yggdrasil.common.block;

import java.util.List;

import net.minecraft.block.Block;

public abstract class YggdrasilExtendableBottomCorp extends YggdrasilExtendableCorp {

	public int minSize ; 
	public int maxSize ; 
	
	public YggdrasilExtendableBottomCorp(int minSize, int maxSize, Properties builder, List<Block> canBePlacedOn, Block topBLock) {
		super(builder, canBePlacedOn);
	}
	
}
