package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			Yggdrasil.MOD_ID);
	
	public static final Lazy<SoundEvent> LAZY_GRUNDAR_MUSIC = Lazy
			.of(() -> new SoundEvent(new ResourceLocation(Yggdrasil.MOD_ID, "disc.grundar")));

	public static final RegistryObject<SoundEvent> GRUNDAR_MUSIC = SOUNDS.register("grundar_music",
			LAZY_GRUNDAR_MUSIC);
	
}
