package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension.MuspelheimModDimension;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension.SvartalvheimModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<ModDimension> MUSPELHEIM = MOD_DIMENSIONS.register("muspelheim", () -> new MuspelheimModDimension());
	public static final RegistryObject<ModDimension> SVARTALVHEIM = MOD_DIMENSIONS.register("svartalvheim", () -> new SvartalvheimModDimension());
	
}