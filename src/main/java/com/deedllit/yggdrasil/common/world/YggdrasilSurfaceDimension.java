package com.deedllit.yggdrasil.common.world;

import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class YggdrasilSurfaceDimension  extends YggdrasilDimension {

	public YggdrasilSurfaceDimension(World worldIn, DimensionType dimensionType, float p_i225788_3_) {
		super(worldIn, dimensionType, p_i225788_3_);
	    this.nether = false;
	}
	
}
