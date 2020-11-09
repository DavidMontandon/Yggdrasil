package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;


import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

public enum AsgardAddForest implements IBishopTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int x, int southEast, int p_202792_4_, int p_202792_5_, int p_202792_6_) {

		boolean isCenterCold = AsgardLayerUtil.isCold(p_202792_6_);

		int i = 1;
		int j = p_202792_6_;
		if (!AsgardLayerUtil.isPlain(p_202792_5_) && context.random(i++) == 0) {
			j = p_202792_5_;
		}

		if (!AsgardLayerUtil.isPlain(p_202792_4_) && context.random(i++) == 0) {
			j = p_202792_4_;
		}

		if (!AsgardLayerUtil.isPlain(x) && context.random(i++) == 0) {
			j = x;
		}

		if (!AsgardLayerUtil.isPlain(southEast) && context.random(i++) == 0) {
			j = southEast;
		}

		if (context.random(4) == 0) {
			return this.getForest(context, AsgardLayerUtil.OAK_FOREST, isCenterCold);
		} else {
			return AsgardLayerUtil.isForest(j) ? this.getForest(context, AsgardLayerUtil.OAK_FOREST, isCenterCold) : p_202792_6_;
		}

	}

	public int getForest(INoiseRandom context, int parentBiome, boolean isFrozen) {

		if (isFrozen) {
			if (parentBiome == AsgardLayerUtil.OAK_FOREST)
				Yggdrasil.LOGGER.info("SNOWNY_FOREST") ;

				return AsgardLayerUtil.SNOWNY_FOREST;
		} 

		return parentBiome;
	}

}
