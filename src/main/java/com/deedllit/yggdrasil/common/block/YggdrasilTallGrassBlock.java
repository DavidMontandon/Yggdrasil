package com.deedllit.yggdrasil.common.block;

import java.util.Arrays;
import java.util.List;


import net.minecraft.block.Block;
import net.minecraft.block.TallGrassBlock;
import net.minecraftforge.common.PlantType;

public abstract class YggdrasilTallGrassBlock extends TallGrassBlock {
	
	private PlantType biomeType ; 
	private List<Block> allowedOn ; 
	
	public YggdrasilTallGrassBlock(PlantType type, Block [] allowedOn, Properties properties) {
		this(type, Arrays.asList(allowedOn), properties ) ; 
	}
	
	public YggdrasilTallGrassBlock(PlantType type, List<Block> allowedOn, Properties properties) {
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
	
	public void addAllowedBlock(Block allowedOn) {
		this.allowedOn.add(allowedOn) ; 
	}
	
}
