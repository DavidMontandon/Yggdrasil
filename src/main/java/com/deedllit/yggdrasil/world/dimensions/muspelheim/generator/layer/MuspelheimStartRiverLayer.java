package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;


import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public enum MuspelheimStartRiverLayer implements IC0Transformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int value) {
		   
		   Yggdrasil.LOGGER.info( context.random(299999) + 2 );
		   
	      return MuspelheimLayerUtil.isShallowOcean(value) ? value : value;
	   }
	}
