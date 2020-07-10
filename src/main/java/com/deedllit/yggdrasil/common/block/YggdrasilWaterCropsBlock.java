package com.deedllit.yggdrasil.common.block;

import java.util.Random;

import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.util.math.shapes.VoxelShapes;

public abstract class YggdrasilWaterCropsBlock extends CropsBlock implements IGrowable, ILiquidContainer  {
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
			
	
	public YggdrasilWaterCropsBlock(Properties properties) {
		super(properties);
	}


	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
		//return VoxelShapes.fullCube() 
	}

	
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Yggdrasil.LOGGER.info("Check isValidGround");
		
		return state.isIn(Blocks.SAND);
		
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {	
		Yggdrasil.LOGGER.info("Check isValidPosition");

		Yggdrasil.LOGGER.info("POS : " + Integer.toString(pos.getX()) + "." + Integer.toString(pos.getY()) + "." + Integer.toString(pos.getZ())) ; 
		
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
		
		BlockState blockUp = worldIn.getBlockState(blockpos$mutableblockpos) ; 
		if (blockUp.getBlock() == Blocks.AIR) {
			return true ; 
		}

				
		Yggdrasil.LOGGER.info( state.toString() ) ; 
		
		return false ; 
		
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
	}

}
