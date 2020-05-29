package com.davidmontandon.yggdrasil.world.feature;

import java.util.Random;

import com.davidmontandon.yggdrasil.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class EpluphiferTree extends Tree {

	public static final TreeFeatureConfig EPLUPHIFER_TREE_CONFIG= (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER__LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0))).baseHeight(14).heightRandA(8).foliageHeight(3).ignoreVines()
					.setSapling((IPlantable) BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(EPLUPHIFER_TREE_CONFIG);
	}
	
}
