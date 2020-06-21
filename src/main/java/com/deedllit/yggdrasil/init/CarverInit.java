package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.common.world.carver.CavernCanyonWorldCarver;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CarverInit {
	
	public static final DeferredRegister<WorldCarver<?>> CAVERS = new DeferredRegister<>(ForgeRegistries.WORLD_CARVERS, Yggdrasil.MOD_ID);

	public static final RegistryObject<WorldCarver<ProbabilityConfig>> CAVERN_CANYON = CAVERS.register("cavern_canyon", () -> new CavernCanyonWorldCarver(ProbabilityConfig::deserialize));
	
}
