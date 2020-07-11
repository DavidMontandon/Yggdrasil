package com.deedllit.yggdrasil.objects.blocks.crops;

import java.util.Random;

import com.deedllit.yggdrasil.common.block.YggdrasilWaterBottomCropsBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class RiceBlock extends YggdrasilWaterBottomCropsBlock {

	public RiceBlock(Properties properties) {
		super(1, 1, 2, 3, properties, new Block[] {Blocks.SAND, Blocks.DIRT, Blocks.CLAY, Blocks.GRAVEL}, null);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true ; 
	}
	
}