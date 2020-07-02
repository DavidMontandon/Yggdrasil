package com.deedllit.yggdrasil.objects.fluids;

import com.deedllit.yggdrasil.init.FluidInit;
import com.deedllit.yggdrasil.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class Acidic extends FlowingFluid {

	@Override
	public FlowingFluid getFlowingFluid() {
		return FluidInit.ACIDIC_FLUID.get();
	}

	@Override
	public FlowingFluid getStillFluid() {
		return FluidInit.ACIDIC_FLOWING.get();
	}

	@Override
	protected boolean canSourcesMultiply() {
		return true;
	}

	@Override
	protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
	}

	@Override
	protected int getSlopeFindDistance(IWorldReader worldIn) {
		return 4;
	}

	@Override
	protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
		return 1;
	}

	@Override
	public Item getFilledBucket() {
		return ItemInit.ACIDIC_BUCKET.get();
	}

	/*
	@Override
	protected boolean canDisplace(IFluidState fluidStateIn, IBlockReader blockReader, BlockPos pos, Fluid fluidIn,
			Direction directionIn) {
		return false;
	}
	*/

	@Override
	public int getTickRate(IWorldReader p_205569_1_) {
		return 60 ;
	}

	@Override
	protected float getExplosionResistance() {
		return 100.0f ;
	}

	/*
	@Override
	protected BlockState getBlockState(IFluidState state) {
		return FluidInit.ACIDIC_BLOCK.get().getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state))) ;
	}

	@Override
	public boolean isSource(IFluidState state) {
		return true;
	}

	@Override
	public int getLevel(IFluidState p_207192_1_) {
		return 0;
	}
*/
	
	@Override
	protected boolean canDisplace(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_,
			Fluid p_215665_4_, Direction p_215665_5_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected BlockState getBlockState(FluidState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSource(FluidState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel(FluidState p_207192_1_) {
		// TODO Auto-generated method stub
		return 0;
	}

}
