package com.deedllit.midgard.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public enum MidgardStartRiverLayer implements IC0Transformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int value) {
	      return MidgardLayerUtil.isShallowOcean(value) ? value : context.random(299999) + 2;
	   }
	}
