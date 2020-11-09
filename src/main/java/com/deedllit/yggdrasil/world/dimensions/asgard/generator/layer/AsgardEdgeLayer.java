package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;


import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public class AsgardEdgeLayer {

	public static enum Mountains implements ICastleTransformer {
		INSTANCE;

		public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {

			boolean isCenterCold = AsgardLayerUtil.isCold(center);

			// Replace forest by moutains
			if (AsgardLayerUtil.isForest(center)) {


				if (context.random(4) == 0) {
					return getMoutain(AsgardLayerUtil.MOUNTAIN, isCenterCold);
				}


			}

			return center;
		}

	}

	public static int getMoutain(int parentBiome, boolean isFrozen) {

		if (isFrozen) {
			if (parentBiome == AsgardLayerUtil.MOUNTAIN)
				return AsgardLayerUtil.SNOWY_MOUNTAIN;
		} 

		return parentBiome;
	}

}
