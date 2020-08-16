package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.world.feature.tree.YggdrasilBasicTree;

import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;


public class FeatureTreeInit {

	
	public static final Feature<BaseTreeFeatureConfig> ELM_TREE = 
			new YggdrasilBasicTree.Builder()
				.maxHeight(9)
				.log(BlockInit.ELM_LOG.get().getDefaultState())
				.leaves(BlockInit.PALM_LEAVES.get().getDefaultState())
				.create();
	
	
}
