package com.deedllit.yggdrasil.objects.blocks.crops;

import java.util.Random;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.common.block.YggdrasilWaterBottomCropsBlock;
import com.deedllit.yggdrasil.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;


public class RiceBottomCropBlock extends YggdrasilWaterBottomCropsBlock {

	public RiceBottomCropBlock(Properties properties, int minDeep, int maxDeep, int minSize, int maxSize, Block[] blocks ) {
		super(minDeep, maxDeep, minSize, maxSize, properties, blocks);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true ; 
	}
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		Yggdrasil.LOGGER.info("canGrow");
		
		
    	if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR)
    	{
    		
    		
    		
    		/*
    		worldIn.setBlockState(pos.up(), BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState());
            worldIn.setBlockState(pos, this.withAge(this.getMaxAge()), 2);
            */
    	}
    	
		return super.canGrow(worldIn, pos, state, isClient);
	}	
	
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		BlockPos blockpos = pos.up();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		
        if (blockstate.get(AGE) == 1 || !worldIn.isAirBlock(blockpos.up())) {
        	return ; 
        }

		
	}
	
	/*
	public int getNumRiceBlocksAbove(IBlockReader worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 16 && worldIn.getBlockState(pos.up(i + 1)).isIn(BlockInit.MIDGARD_RICE_TOP_CROP.get()); ++i) {
		}

		return i;
	}
	*/
	
}