package com.davidmontandon.yggdrasil.world.feature.structure;

import net.minecraft.world.gen.feature.structure.ScatteredStructure;

import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.world.gen.feature.NoFeatureConfig;

public class CardinalPortalStructure extends ScatteredStructure<NoFeatureConfig> { public CardinalPortalStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	protected int getSeedModifier() {
		return 0;
	}
	
	@Override
	public IStartFactory getStartFactory() {
		return null;
	}
	
	@Override
	public String getStructureName() {
		return null;
	}
	
	@Override
	public int getSize() {
		return 0;
	}
}
