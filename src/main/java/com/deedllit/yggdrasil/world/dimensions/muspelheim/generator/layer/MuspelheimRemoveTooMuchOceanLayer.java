package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MuspelheimRemoveTooMuchOceanLayer implements ICastleTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		return MuspelheimLayerUtil.isShallowOcean(center) && MuspelheimLayerUtil.isShallowOcean(north)
				&& MuspelheimLayerUtil.isShallowOcean(west) && MuspelheimLayerUtil.isShallowOcean(east) && MuspelheimLayerUtil.isShallowOcean(south)
				&& context.random(2) == 0 ? MuspelheimLayerUtil.PLAINS : center;
	}
}