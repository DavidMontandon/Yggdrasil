package com.deedllit.yggdrasil.init;

import java.util.LinkedHashSet;

import com.deedllit.yggdrasil.Yggdrasil;
//import com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension.MuspelheimModDimension;
//import com.deedllit.yggdrasil.world.dimensions.nifelheim.dimension.NifelheimModDimension;
//import com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension.SvartalvheimModDimension;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
//import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	//also register in ForgeEventBusSubscriber
	
    public static final RegistryKey<Dimension> DIMENSION_MUSPELHEIM = RegistryKey.func_240903_a_(Registry.field_239700_af_, new ResourceLocation("muspelheim"));
    public static final RegistryKey<Dimension> DIMENSION_NIFELHEIM = RegistryKey.func_240903_a_(Registry.field_239700_af_, new ResourceLocation("nifelheim"));

	
	private static final LinkedHashSet<RegistryKey<Dimension>> DIMENSIONS = Sets.newLinkedHashSet(ImmutableList.of(DIMENSION_MUSPELHEIM, DIMENSION_NIFELHEIM));

	
	/*
	public static final DeferredRegister<Dimension> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<ModDimension> MUSPELHEIM = MOD_DIMENSIONS.register("muspelheim", () -> new MuspelheimModDimension());
	public static final RegistryObject<ModDimension> SVARTALVHEIM = MOD_DIMENSIONS.register("svartalvheim", () -> new SvartalvheimModDimension());
	public static final RegistryObject<ModDimension> NIFELHEIM = MOD_DIMENSIONS.register("nifelheim", () -> new NifelheimModDimension());
	*/
}
