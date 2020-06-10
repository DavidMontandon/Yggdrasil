package com.davidmontandon.yggdrasil.objects.blocks.muspelheim;

import java.util.Random;

import com.davidmontandon.yggdrasil.objects.blocks.GrowableOnBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class MuspelheimGrass extends GrowableOnBlock {

	public MuspelheimGrass(Properties builder) {
		super(builder, true);
	}

   public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
	   }
   
   @Override
   public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
	   return false ;
   }

}
