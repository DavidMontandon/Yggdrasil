package com.deedllit.yggdrasil.common.block;


import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public abstract class YggdrasilTallGrassBlock extends TallGrassBlock {
	
	private PlantType biomeType ; 
	private Block [] allowedOn ; 
	
	public YggdrasilTallGrassBlock(PlantType type, Block [] allowedOn, Properties properties) {
		super(properties);		

		this.allowedOn = allowedOn ; 
		this.setPlantType(type);
	}
	
	public PlantType getPlantType() {
		return this.biomeType ; 
	}
	
	public void setPlantType(PlantType type) {
		this.biomeType = type ;  		
	}
	
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		
		for (Block b : allowedOn) {
						
			if(state.getBlock() == b)
				return true ; 
			
		}
		
		return false ; 
		
	}

		
}
