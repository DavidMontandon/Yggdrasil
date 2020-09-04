package com.deedllit.yggdrasil.world.gen.worldtype;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.ChunkGeneratorOverworldVanillaMidgard;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.VanillaMidgardBiomeProvider;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.VanillaMidgardWorldGenSettings;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.OverworldChunkGenerator;

public class WorldTypeMidgard extends WorldType {

	public WorldTypeMidgard() {
		super("midgard");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		
		
		if (world.getDimension().getType() == DimensionType.OVERWORLD) {
			Yggdrasil.LOGGER.info("=========== VanillaMidhard createChunkGenerator ===========") ;

			VanillaMidgardWorldGenSettings genSettings = new VanillaMidgardWorldGenSettings();
			OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
			biomeProviderSettings.setGeneratorSettings(genSettings) ; 
			
			return new ChunkGeneratorOverworldVanillaMidgard(world, new VanillaMidgardBiomeProvider(biomeProviderSettings), genSettings);
			//return new OverworldChunkGenerator(world, new VanillaMidgardBiomeProvider(biomeProviderSettings), ChunkGeneratorType.SURFACE.createSettings()) ; 
			
		}
		
		return super.createChunkGenerator(world);
	}
	
	/*
	 * Use config file instead
	 */
	@Override
	public boolean hasCustomOptions() {
		return false ; 
	}

}
