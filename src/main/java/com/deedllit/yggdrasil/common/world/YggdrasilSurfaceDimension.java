package com.deedllit.yggdrasil.common.world;

import java.util.function.Supplier;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
//import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.storage.ISpawnWorldInfo;

public class YggdrasilSurfaceDimension  extends YggdrasilDimension {

	protected YggdrasilSurfaceDimension(ISpawnWorldInfo p_i231617_1_, RegistryKey<World> p_i231617_2_,
			RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_,
			boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
		super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
		// TODO Auto-generated constructor stub
	}
	
	/*
	public YggdrasilSurfaceDimension(World worldIn, DimensionType dimensionType, float p_i225788_3_) {
		super(worldIn, dimensionType, p_i225788_3_);
	    this.nether = false;
	}
	*/
}
