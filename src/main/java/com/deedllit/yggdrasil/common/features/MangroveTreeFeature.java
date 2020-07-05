package com.deedllit.yggdrasil.common.features;


import java.util.Random;

import com.deedllit.yggdrasil.init.BlockInit;
import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

public class MangroveTreeFeature extends Feature<NoFeatureConfig> {

	public MangroveTreeFeature(Codec<NoFeatureConfig> p_i231953_1_) {
		super(p_i231953_1_);
	}

	@Override
	public boolean func_230362_a_(ISeedReader world, StructureManager structureManager, ChunkGenerator chunkGenerator,
			Random rand, BlockPos blockPos, NoFeatureConfig config) {
		
		int i = 0;
		
		BlockState roots = BlockInit.MIDGARD_MANGROVE_LOG.get().getDefaultState() ; 
		BlockState leaves = BlockInit.MIDGARD_MANGROVE_LEAVES.get().getDefaultState() ; 
		
		for(int j = 0; j < 64; ++j) {
			
			BlockPos blockPosBuild = blockPos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			
						
			if (world.getBlockState(blockPosBuild).getMaterial() == Material.WATER && world.isAirBlock(blockPosBuild.up()) ) {
				world.setBlockState(blockPosBuild, roots, 2);
				
				((DoublePlantBlock)roots.getBlock()).placeAt(world, blockPosBuild, 2);

				BlockPos leaves1 = blockPosBuild.up().up();
				BlockPos leaves2 = leaves1.north();
				BlockPos leaves3 = leaves1.south();
				BlockPos leaves4 = leaves1.east();
				BlockPos leaves5 = leaves1.west();
				BlockPos leaves6 = leaves1.down();
				
				
				if (world.getBlockState(leaves1).canBeReplacedByLeaves(world, leaves1))
				{
										
					world.setBlockState(leaves1, leaves, 2)  ;
				}

				
				if (rand.nextInt(2) == 0)
				{
					if (world.getBlockState(leaves2).canBeReplacedByLeaves(world, leaves2))
					{
						world.setBlockState(leaves2, leaves, 2)  ;
					}
					if (world.getBlockState(leaves3).canBeReplacedByLeaves(world, leaves3))
					{
						world.setBlockState(leaves3, leaves, 2)  ;
					}
					if (world.getBlockState(leaves4).canBeReplacedByLeaves(world, leaves4))
					{
						world.setBlockState(leaves4, leaves, 2)  ;
					}
					if (world.getBlockState(leaves5).canBeReplacedByLeaves(world, leaves5))
					{
						world.setBlockState(leaves5, leaves, 2)  ;
					}
					if (world.getBlockState(leaves6).canBeReplacedByLeaves(world, leaves6))
					{
						world.setBlockState(leaves6, leaves, 2)  ;
					}
				}
				
				++i;
			}
			
			
		}
		
		
	return false ; 
	}
}