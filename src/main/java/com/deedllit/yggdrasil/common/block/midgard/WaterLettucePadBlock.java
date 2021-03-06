package com.deedllit.yggdrasil.common.block.midgard;

import java.util.Random;

import com.deedllit.yggdrasil.common.block.YggdrasilSpreadablePadBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class WaterLettucePadBlock extends YggdrasilSpreadablePadBlock {

	protected static final VoxelShape WATER_LETTUCE_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

	public WaterLettucePadBlock(AbstractBlock.Properties builder) {
		super(builder);
	}

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
	    if (worldIn instanceof ServerWorld && entityIn instanceof BoatEntity) {
	    	worldIn.destroyBlock(new BlockPos(pos), true, entityIn);
	    }
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return WATER_LETTUCE_AABB;
	}

	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		FluidState fluidstate = worldIn.getFluidState(pos);
		FluidState fluidstate1 = worldIn.getFluidState(pos.up());
		
		return (fluidstate.getFluid() == Fluids.WATER || state.getMaterial() == Material.ICE) && fluidstate1.getFluid() == Fluids.EMPTY;
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return worldIn.getBlockState(pos.up()).isAir();
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		
		//this.spread(worldIn, rand, pos, state);
		
	}

	
}
