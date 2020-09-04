package com.deedllit.mythologycraft.caves.decoration;

import java.util.Set;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.Chunk;

public abstract class MythologyCaveDecoration {
	public abstract void decorateCave(IWorld worldIn, Chunk chunk, Set<BlockPos> pos) ; 
}
