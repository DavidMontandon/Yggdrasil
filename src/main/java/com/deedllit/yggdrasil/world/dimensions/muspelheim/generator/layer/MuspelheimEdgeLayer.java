package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public class MuspelheimEdgeLayer {
	public static enum Warm implements ICastleTransformer {
		INSTANCE;

		public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
			return center != MuspelheimLayerUtil.PLAINS
					|| north != MuspelheimLayerUtil.MOUTAINS && west != MuspelheimLayerUtil.MOUTAINS
							&& east != MuspelheimLayerUtil.MOUTAINS && south != MuspelheimLayerUtil.MOUTAINS
							&& north != MuspelheimLayerUtil.FOREST && west != MuspelheimLayerUtil.FOREST
							&& east != MuspelheimLayerUtil.FOREST && south != MuspelheimLayerUtil.FOREST ? center
									: MuspelheimLayerUtil.VOLCANO;
		}
	}

	public static enum Heat implements ICastleTransformer {
		INSTANCE;

		public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
			return center != MuspelheimLayerUtil.FOREST
					|| north != MuspelheimLayerUtil.PLAINS && west != MuspelheimLayerUtil.PLAINS
							&& east != MuspelheimLayerUtil.PLAINS && south != MuspelheimLayerUtil.PLAINS
							&& north != MuspelheimLayerUtil.VOLCANO && west != MuspelheimLayerUtil.VOLCANO
							&& east != MuspelheimLayerUtil.VOLCANO && south != MuspelheimLayerUtil.VOLCANO ? center
									: MuspelheimLayerUtil.MOUTAINS;
		}
	}

	public static enum Special implements IC0Transformer {
		INSTANCE;

		public int apply(INoiseRandom context, int value) {
			if (!MuspelheimLayerUtil.isShallowOcean(value) && context.random(13) == 0) {
				value |= 1 + context.random(15) << 8 & 3840;
			}

			return value;
		}
	}
}