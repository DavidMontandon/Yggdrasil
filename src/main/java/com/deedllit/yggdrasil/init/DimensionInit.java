package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.asgard.dimension.AsgardModDimension;
import com.deedllit.yggdrasil.world.dimensions.midgard.dimension.MidgardModDimension;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension.MuspelheimModDimension;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.dimension.NifelheimModDimension;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension.SvartalvheimModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	//also register in ForgeEventBusSubscriber
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<ModDimension> ASGARD = MOD_DIMENSIONS.register("asgard", () -> new AsgardModDimension());
	public static final RegistryObject<ModDimension> MIDGARD = MOD_DIMENSIONS.register("midgard", () -> new MidgardModDimension());
	public static final RegistryObject<ModDimension> MUSPELHEIM = MOD_DIMENSIONS.register("muspelheim", () -> new MuspelheimModDimension());
	public static final RegistryObject<ModDimension> NIFELHEIM = MOD_DIMENSIONS.register("nifelheim", () -> new NifelheimModDimension());
	public static final RegistryObject<ModDimension> SVARTALVHEIM = MOD_DIMENSIONS.register("svartalvheim", () -> new SvartalvheimModDimension());
	
}
