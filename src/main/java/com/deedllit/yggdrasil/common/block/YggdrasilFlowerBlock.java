package com.deedllit.yggdrasil.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class YggdrasilFlowerBlock extends FlowerBlock {

	public Block allowedOn ; 
	public PlantType biomeType ; 
	
	public YggdrasilFlowerBlock(PlantType type, Block allowedOn, Effect p_i49984_1_, int effectDuration, Properties properties) {
		super(p_i49984_1_, effectDuration, properties);
		
		this.allowedOn = allowedOn ; 
		this.biomeType = type ;  
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		 return state.isIn(this.allowedOn);
	}
	
	
	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return this.biomeType ; 
	}
	
}
