package com.deedllit.yggdrasil.common.block;

import java.util.Random;

import com.deedllit.yggdrasil.util.interfaces.DoNotCreateItem;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public abstract class YggdrasilSpreadablePadBlock extends BushBlock implements DoNotCreateItem, IGrowable {

	public YggdrasilSpreadablePadBlock(Properties properties) {
		super(properties);
	}
	

	public void spread(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		
	}
	
	
}
