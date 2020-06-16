package com.davidmontandon.yggdrasil.world.dimensions.svartalvheim.generator;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public abstract class SvartalvheimSurfaceBuilder<C extends ISurfaceBuilderConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<SurfaceBuilder<?>> {
	
	   public static final SurfaceBuilder<SurfaceBuilderConfig> SVARTALVHEIM_CAVERN = register("svartalvheim_cavern", new SvartalvheimCavernBuilder(SurfaceBuilderConfig::deserialize));

	   private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		      return (F)(Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
		   }
}
