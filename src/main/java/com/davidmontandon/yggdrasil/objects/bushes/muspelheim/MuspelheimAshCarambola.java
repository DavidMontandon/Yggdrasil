package com.davidmontandon.yggdrasil.objects.bushes.muspelheim;

import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;

import java.util.Random;

import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MuspelheimAshCarambola extends BushBlock implements IGrowable {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
			Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 16.0D, 16.0D, 15.0D) };
	
	public MuspelheimAshCarambola(Properties properties) {
		super(properties);
	}

   public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
	      return new ItemStack (ItemInit.RUNE_ELDER_FUTHARK_FIRST_AITT_ANSUZ.get()) ; 
	   }
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(AGE)];
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		 return state.get(AGE) < 3;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
	      int i = Math.min(3, state.get(AGE) + 1);
	      worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}	
	
}
