package com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension;

import java.util.function.BiFunction;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class SvartalvheimModDimension extends ModDimension {

	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		return SvartalvheimDimension::new ; 
	}



}
