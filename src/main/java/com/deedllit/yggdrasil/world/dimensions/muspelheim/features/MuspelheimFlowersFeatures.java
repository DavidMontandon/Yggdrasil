package com.deedllit.yggdrasil.world.dimensions.muspelheim.features;

import com.deedllit.mythologycraft.features.MCDefaultFlowersFeatureNoConfig;
import com.deedllit.yggdrasil.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.DefaultFlowersFeature;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class MuspelheimFlowersFeatures extends MCDefaultFlowersFeatureNoConfig {

	private static final Block[] FLOWERS = new Block[] {BlockInit.MUSPELHEIM_FIRE_POPPY.get(), 
			BlockInit.MUSPELHEIM_DRAGON_GRASS.get()};
	
	@Override
	public boolean func_225559_a_(IWorld p_225559_1_, BlockPos p_225559_2_, NoFeatureConfig p_225559_3_) {
		return false;
	}

	@Override
	public BlockPos getNearbyPos(Random p_225561_1_, BlockPos p_225561_2_, NoFeatureConfig p_225561_3_) {
		return null;
	}

	@Override
	public BlockState getFlowerToPlace(Random p_225562_1_, BlockPos p_225562_2_, NoFeatureConfig p_225562_3_) {

		int i ;
		i = 0 ;
		
		return FLOWERS[i].getDefaultState();
	}
	
}
