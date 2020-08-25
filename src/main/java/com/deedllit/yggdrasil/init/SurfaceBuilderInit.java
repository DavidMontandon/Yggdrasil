package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.gen.surfacebuilders.*;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS =  new DeferredRegister<>(ForgeRegistries.SURFACE_BUILDERS,  Yggdrasil.MOD_ID) ; 	

	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE = new MangroveSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_BORDER = new MangroveBorderSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_MIX = new MangroveMixedSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> CHAPARRAL = new ChaparralSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FYNBOS = new FynbosSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> SNOWTOP = new SnowTopSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> TROPICAL = new TropicalWhiteSandSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOW = new RaibowsMoutainSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> HOLES = new HolesSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> WHITE_SAND_ISLAND = new WhiteSandIsland(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> BLACK_SAND_ISLAND = new BlackSandIsland(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FLOATING_ISLAND_MOUTAIN = new FloatingIslandMountainSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FLOATING_ISLAND_HILL = new FloatingIslandHillSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	
	
	//public static final SurfaceBuilder<SurfaceBuilderConfig> SPOOKY = new SpookySurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
}
