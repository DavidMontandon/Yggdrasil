package com.deedllit.yggdrasil.common.block.midgard;

import com.deedllit.yggdrasil.common.block.YggdrasilTallGrassBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class YggdrasilGrass extends YggdrasilTallGrassBlock {

	
	public YggdrasilGrass(PlantType type, Block [] allowedOn, Properties properties) {
		super(type, allowedOn, properties);		
	}
	
	
}
