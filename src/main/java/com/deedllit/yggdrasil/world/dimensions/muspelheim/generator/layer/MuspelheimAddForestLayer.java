package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum MuspelheimAddForestLayer implements IC1Transformer {
	INSTANCE;

	public int apply(INoiseRandom context, int value) {
		if (MuspelheimLayerUtil.isShallowOcean(value)) {
			return value;
		} else {
			
			return MuspelheimLayerUtil.ACIDURIC_LAKE ; 
			
			/*
			int i = context.random(10);
			if (i == 0) {
				return MuspelheimLayerUtil.ACIDURIC_LAKE ;
			} else {
				return i == 1 ? MuspelheimLayerUtil.FOREST : MuspelheimLayerUtil.PLAINS ;
			}
			*/
			
		}
	}
}