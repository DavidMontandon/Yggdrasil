package com.deedllit.yggdrasil.world.feature.flower;

import java.util.Random;

import com.deedllit.yggdrasil.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;

public class AsgardFlowerBlockStateProvider extends BlockStateProvider {

	private static final BlockState[] PINK = new BlockState[]{Blocks.PEONY.getDefaultState(), Blocks.PINK_TULIP.getDefaultState()};
	private static final BlockState[] MANGENTA = new BlockState[]{BlockInit.PURPLE_SUNFLOWER.get().getDefaultState(),  Blocks.LILAC.getDefaultState()};

	
	public AsgardFlowerBlockStateProvider() {
		super(BlockStateProviderType.PLAIN_FLOWER_PROVIDER);	
	}

	public <T> AsgardFlowerBlockStateProvider(Dynamic<T> p_i225857_1_) {
		this();
	}


	@Override
	public <T> T serialize(DynamicOps<T> p_218175_1_) {
		return null;
	}

	@Override
	public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
	      double d0 = Biome.INFO_NOISE.noiseAt((double)blockPosIn.getX() / 200.0D, (double)blockPosIn.getZ() / 200.0D, false);
	      if (d0 < -0.8D) {
	         return PINK[randomIn.nextInt(PINK.length)];
	      } else {
	         return randomIn.nextInt(3) > 0 ? MANGENTA[randomIn.nextInt(MANGENTA.length)] : Blocks.DANDELION.getDefaultState();
	      }
	} 

}
