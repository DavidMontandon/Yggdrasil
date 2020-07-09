package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.gen.surfacebuilders.*;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {

	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS,  Yggdrasil.MOD_ID) ; 	

	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE = new MangroveSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_BORDER = new MangroveBorderSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_MIX = new MangroveMixedSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	public static final SurfaceBuilder<SurfaceBuilderConfig> CHAPARRAL = new ChaparralSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FYNBOS = new FynbosSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	public static final SurfaceBuilder<SurfaceBuilderConfig> SPOOKY = new SpookySurfaceBuilder(SurfaceBuilderConfig.field_237203_a_);
	
}
