package com.deedllit.yggdrasil.util.helpers;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class PlacementHelper {

	public static boolean isInList(BlockState state, List<Block> blocks) {
		
		for(Block b : blocks){
			if(state.isIn(b))
				return true ; 
		}
		
		return false  ; 
	}
	
}
