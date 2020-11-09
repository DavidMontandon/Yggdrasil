package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.mythologycraft.world.biome.MythologycraftBiome;
import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class MuspelheimFirePoppyField extends MythologycraftBiome {

	public MuspelheimFirePoppyField() {
		super(null);
	} 
	
	@Override
	public Biome getRiver() {
		return ForgeRegistries.BIOMES.getValue(new ResourceLocation(Yggdrasil.MOD_ID + ":muspelheim_river")) ; 
	}

}
