package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardLayerUtil;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MuspelheimDeepOceanLayer implements ICastleTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		if (MuspelheimLayerUtil.isShallowOcean(center)) {
			int i = 0;
			if (MuspelheimLayerUtil.isShallowOcean(north)) {
				++i;
			}

			if (MidgardLayerUtil.isShallowOcean(west)) {
				++i;
			}

			if (MuspelheimLayerUtil.isShallowOcean(east)) {
				++i;
			}

			if (MuspelheimLayerUtil.isShallowOcean(south)) {
				++i;
			}

			if (i > 3) {
				return MuspelheimLayerUtil.DEEP_OCEAN;
			
			}
		}

		return center;
	}
}
