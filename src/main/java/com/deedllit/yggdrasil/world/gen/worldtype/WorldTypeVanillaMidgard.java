package com.deedllit.yggdrasil.world.gen.worldtype;

import com.deedllit.yggdrasil.world.dimensions.vanilla.config.ChunkGeneratorOverworldVanillaMidgard;
import com.deedllit.yggdrasil.world.dimensions.vanilla.config.VanillaMidgardBiomeProvider;
import com.deedllit.yggdrasil.world.dimensions.vanilla.config.VanillaMidgardWorldGenSettings;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class WorldTypeVanillaMidgard extends WorldType {

	public WorldTypeVanillaMidgard() {
		super("vanilla_midgard");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		
		VanillaMidgardWorldGenSettings genSettings = new VanillaMidgardWorldGenSettings();
		OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
		
		if (world.getDimension().getType() == DimensionType.OVERWORLD) {
			return new ChunkGeneratorOverworldVanillaMidgard(world, new VanillaMidgardBiomeProvider(biomeProviderSettings), genSettings);
		}
		
		return super.createChunkGenerator(world);
	}

}
