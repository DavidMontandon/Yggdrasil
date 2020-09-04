package com.deedllit.mythologycraft.caves.decoration.types;

import java.util.Set;

import com.deedllit.mythologycraft.caves.decoration.MythologyCaveDecoration;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.Chunk;

public class CobbleCaveDecorator extends MythologyCaveDecoration {

	@Override
	public void decorateCave(IWorld worldIn, Chunk chunk, Set<BlockPos> pos) {

		for(BlockPos p : pos) {
			
			int r = worldIn.getRandom().nextInt(6) ; 
			
			if (r == 0) {
				chunk.setBlockState(p.down(), Blocks.COBBLESTONE.getDefaultState(), false) ; 
			} else if (r == 1) {
				chunk.setBlockState(p.down(), Blocks.MOSSY_COBBLESTONE.getDefaultState(), false) ; 				
			}
		
		}
		
	}

}
