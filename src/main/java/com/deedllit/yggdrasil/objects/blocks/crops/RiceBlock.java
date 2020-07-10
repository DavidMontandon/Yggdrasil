package com.deedllit.yggdrasil.objects.blocks.crops;

import java.util.Random;

import com.deedllit.yggdrasil.common.block.YggdrasilWaterCropsBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class RiceBlock extends YggdrasilWaterCropsBlock {

	public RiceBlock(Properties properties) {
		super(properties.notSolid());
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true ; 
	}
	
}