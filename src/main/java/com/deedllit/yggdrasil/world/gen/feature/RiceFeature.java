package com.deedllit.yggdrasil.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

public class RiceFeature extends Feature<NoFeatureConfig> { public RiceFeature(Codec<NoFeatureConfig> p_i231953_1_) {
		super(p_i231953_1_);
	}

	@Override
	public boolean func_230362_a_(ISeedReader p_230362_1_, StructureManager p_230362_2_, ChunkGenerator p_230362_3_,
			Random p_230362_4_, BlockPos p_230362_5_, NoFeatureConfig p_230362_6_) {
		
		int i = 0;
		
		
		
		return i > 0 ;
	}

}

