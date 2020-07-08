package com.deedllit.yggdrasil.common.features;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;

public class BaseBasedFlowerBlock extends FlowerBlock {

	public BlockState allowedOn ; 
	
	public BaseBasedFlowerBlock(BlockState allowedOn, Effect p_i49984_1_, int effectDuration, Properties properties) {
		super(p_i49984_1_, effectDuration, properties);
		
		this.allowedOn = allowedOn ; 
		
	}
	   
}
