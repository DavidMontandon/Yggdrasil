package com.davidmontandon.yggdrasil.world.feature.tree;

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

	public EpluphiferTree() {
		super() ;
	}
	
	public static final TreeFeatureConfig EPLUPHIFER_TREE_NORMAL = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0)))
				.baseHeight(8)
				.heightRandA(4)
				.trunkHeight(4)
				.trunkHeightRandom(3)
				.trunkTopOffsetRandom(1)
				//.foliageHeight(9)
				.foliageHeightRandom(5)
				.ignoreVines()
				.setSapling((IPlantable) BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get())
				.build();

	public static final TreeFeatureConfig EPLUPHIFER_TREE_SICK = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER_SICK_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MUSPELHEIM_EPLUPHIFER_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0)))
				.baseHeight(4)
				.heightRandA(4)
				.trunkHeight(4)
				.trunkHeightRandom(3)
				.foliageHeight(1)
				.foliageHeightRandom(5)
				.ignoreVines()
				.setSapling((IPlantable) BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get())
				.build();
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
				
		switch (randomIn.nextInt(10)) {
			case 0:	
				return Feature.NORMAL_TREE.withConfiguration(EPLUPHIFER_TREE_SICK);
			default:
				return Feature.NORMAL_TREE.withConfiguration(EPLUPHIFER_TREE_NORMAL) ; 
		}

	}
	
	
	
}
