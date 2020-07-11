package com.deedllit.yggdrasil.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.util.helpers.PlacementHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class YggdrasilWaterBottomCropsBlock extends YggdrasilExtendableBottomCorp implements ILiquidContainer  {
		
	
	private int minDeep ;
	private int maxDeep ; 
	private Block liquid = Blocks.WATER ; 
	
	public YggdrasilWaterBottomCropsBlock(int minDeep, int maxDeep, int minSize, int maxSize, Properties properties, List<Block> canBePlacedOn, Block topBlock) {
		super(minSize, maxSize, properties.notSolid(), canBePlacedOn, topBlock);		

		this.minDeep = minDeep ; 
		this.maxDeep = maxDeep ; 
	}
	
	public YggdrasilWaterBottomCropsBlock(int minDeep, int maxDeep, int minSize, int maxSize, Properties properties, Block [] canBePlacedOn, Block topBlock) {
		this(minDeep, maxDeep, minSize, maxSize, properties, Arrays.asList(canBePlacedOn), topBlock);		
	}
	
	public YggdrasilWaterBottomCropsBlock(Properties properties) {
		this(1, 1, 1, 1, properties, new Block[] {Blocks.SAND, Blocks.DIRT}, null);
	}

	public int getMinDeep() {
		return this.minDeep ; 
	}
	
	public int getMaxDeep() {
		return this.maxDeep ; 
	}

	/*
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Yggdrasil.LOGGER.info("Check isValidGround");
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		
		blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
		if (!PlacementHelper.blockIsInList(worldIn.getBlockState(blockpos$mutableblockpos).getBlock(), this.getPlacableOn()))  {
			Yggdrasil.LOGGER.info("Not good floor");			
			return false ; 
		}
					
		return true ; 
	}
	*/
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Yggdrasil.LOGGER.info("Check getStateForPlacement");

		int thisDeep = PlacementHelper.blocksDeep(context) ;
		if(thisDeep >= this.minDeep && thisDeep <= this.maxDeep) 
			return super.getStateForPlacement(context) ;
		
		return null ; 
		/*
		if(thisDeep >= this.minDeep && thisDeep <= this.maxDeep) {
			Yggdrasil.LOGGER.info("In good deep : " + Integer.toString(thisDeep) );			
		} else {
			Yggdrasil.LOGGER.info("Not in good deep"  + Integer.toString(thisDeep) );			
		}
		
		
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		return fluidstate.isTagged(FluidTags.WATER) && fluidstate.getLevel() == 8 ? super.getStateForPlacement(context) : null;
		*/
	}
	
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {	
		Yggdrasil.LOGGER.info("Check isValidPosition");

		
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
				
		/*
		int thisDeep = PlacementHelper.blocksUntilSurface(worldIn, pos, this.liquid, Blocks.AIR) ; 
		
		
		if(thisDeep >= this.minDeep && thisDeep <= this.maxDeep) {
			Yggdrasil.LOGGER.info("In good deep : " + Integer.toString(thisDeep) );			
		} else {
			Yggdrasil.LOGGER.info("Not in good deep"  + Integer.toString(thisDeep) );			
			return false ; 			
		}
		*/
		
		//valid bottom
		blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
		if (!PlacementHelper.blockIsInList(worldIn.getBlockState(blockpos$mutableblockpos).getBlock(), this.getPlacableOn()))  {
			Yggdrasil.LOGGER.info("Not good floor");			
			return false ; 
		}
					
		return true ; 
		
	}
	
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	/*
	 * ILiquidContainer
	 */
	
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
