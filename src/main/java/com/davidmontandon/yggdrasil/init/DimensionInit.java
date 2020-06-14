package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.muspelheim.dimension.MuspelheimModDimension;
import com.davidmontandon.yggdrasil.world.svartalvheim.dimension.SvartalvheimModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<ModDimension> MUSPELHEIM = MOD_DIMENSIONS.register("muspelheim", () -> new MuspelheimModDimension());
	public static final RegistryObject<ModDimension> SVARTALVHEIM = MOD_DIMENSIONS.register("svartalvheim", () -> new SvartalvheimModDimension());
	
}
