package com.deedllit.yggdrasil.objects.blocks.muspelheim;

import com.deedllit.yggdrasil.common.block.YggdrasilPlantBlock;
import com.deedllit.yggdrasil.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MuspelheimDragonGrassBlock extends YggdrasilPlantBlock {

	public MuspelheimDragonGrassBlock(Properties properties) {
		super(properties);
		this.cantBurn();
	}
	
	@Override 
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == BlockInit.MUSPELHEIM_GRASS.get() ; 
		//return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
	}

}
