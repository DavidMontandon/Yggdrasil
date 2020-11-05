package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum MuspelheimIslandLayer implements IAreaTransformer0 {
	INSTANCE;

	public int apply(INoiseRandom context, int x, int z) {
		if (x == 0 && z == 0) {
			return MuspelheimLayerUtil.PLAINS;
		} else {
			return context.random(10) == 0 ?  MuspelheimLayerUtil.PLAINS : MuspelheimLayerUtil.OCEAN;
		}
	}
}