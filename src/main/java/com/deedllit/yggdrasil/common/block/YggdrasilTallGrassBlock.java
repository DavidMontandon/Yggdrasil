package com.deedllit.yggdrasil.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.PlantType;

public class YggdrasilTallGrassBlock extends TallGrassBlock {
	
	public Block allowedOn ; 
	public PlantType biomeType ; 
	
	public YggdrasilTallGrassBlock(PlantType type, Block allowedOn, Properties properties) {
		super(properties);
		
		this.allowedOn = allowedOn ; 
		this.biomeType = type ;  
	}
	

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		 return state.isIn(this.allowedOn);
	}
	
}
