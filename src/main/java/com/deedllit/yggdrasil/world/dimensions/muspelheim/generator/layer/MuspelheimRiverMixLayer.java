package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;

import com.deedllit.midgard.world.dimension.midgard.generator.layer.MidgardLayerUtil;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum MuspelheimRiverMixLayer implements IAreaTransformer2, IDimOffset0Transformer {
	INSTANCE;

	public int apply(INoiseRandom context, IArea biomeArea, IArea riverArea, int x, int z) {

		int biomeId = biomeArea.getValue(x, z);
		int riverId = riverArea.getValue(x, z);
		Biome biome = Registry.BIOME.getByValue(biomeId);
		
		if (MuspelheimLayerUtil.isOcean(biomeId)) {
			return biomeId;
		} else if (riverId == MuspelheimLayerUtil.RIVER) {
			if (biomeId == MuspelheimLayerUtil.PLAINS) 
				return MuspelheimLayerUtil.SULFUR_RIVER;
		}

			
		return biomeId;
	}
}