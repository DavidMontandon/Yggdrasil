package com.deedllit.yggdrasil.objects.blocks.crops;

import java.util.Random;

import com.deedllit.yggdrasil.common.block.YggdrasilWaterBottomCropsBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class RiceBottomCropBlock extends YggdrasilWaterBottomCropsBlock {

	public RiceBottomCropBlock(Properties properties, int minDeep, int maxDeep, int minSize, int maxSize, Block[] blocks, Block topBlock) {
		super(minDeep, maxDeep, minSize, maxSize, properties, blocks, topBlock);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true ; 
	}
	
}