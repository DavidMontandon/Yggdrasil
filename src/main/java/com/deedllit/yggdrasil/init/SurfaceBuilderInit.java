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
	
	
}
