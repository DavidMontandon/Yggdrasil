package com.davidmontandon.yggdrasil.world.gen;

import com.davidmontandon.yggdrasil.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class YggdrasilSurfaceBuilderConfigLists {

	public static final BlockState STONE = Blocks.STONE.getDefaultState();
	public static final BlockState SAND = Blocks.SAND.getDefaultState();

	public static final BlockState MUSPELHEIM_HOTROCK = BlockInit.MUSPELHEIM_HOT_ROCK.get().getDefaultState();
	public static final BlockState MUSPELHEIM_COLDROCK = BlockInit.MUSPELHEIM_COLD_ROCK.get().getDefaultState();
	public static final BlockState MUSPELHEIM_GRASS = BlockInit.MUSPELHEIM_GRASS.get().getDefaultState();
	public static final BlockState MUSPELHEIM_ASH = BlockInit.MUSPELHEIM_ASH.get().getDefaultState();
	
	public static SurfaceBuilderConfig STONE_STONE_STONE = new SurfaceBuilderConfig(STONE, STONE, STONE);
	public static SurfaceBuilderConfig MUSPELHEIM_HOTROCK_COLDROCK_SAND = new SurfaceBuilderConfig(MUSPELHEIM_HOTROCK, MUSPELHEIM_COLDROCK, SAND);
	public static SurfaceBuilderConfig MUSPELHEIM_GRASS_ASH_SAND = new SurfaceBuilderConfig(MUSPELHEIM_HOTROCK, MUSPELHEIM_COLDROCK, SAND);
	
	
	
}
