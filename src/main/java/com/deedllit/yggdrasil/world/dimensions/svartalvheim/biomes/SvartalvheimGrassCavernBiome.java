package com.deedllit.yggdrasil.world.dimensions.svartalvheim.biomes;

import com.deedllit.yggdrasil.world.dimensions.svartalvheim.generator.SvartalvheimSurfaceBuilder;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;

import net.minecraft.world.biome.Biome;

public class SvartalvheimGrassCavernBiome extends Biome {

	public SvartalvheimGrassCavernBiome(Builder biomeBuilder) {
		
	      super((new Biome.Builder())
	    		  .surfaceBuilder(SvartalvheimSurfaceBuilder.SVARTALVHEIM_CAVERN, YggdrasilSurfaceBuilderConfigLists.STONE_STONE_STONE)	    		  
	    		  .precipitation(Biome.RainType.NONE)
	    		  .category(Biome.Category.PLAINS)
	    		  .depth(0.1F)
	    		  .scale(0.2F)
	    		  .temperature(1.0F)
	    		  .downfall(0.0F)
	    		  .waterColor(0xE8D8ED)
	    		  .waterFogColor(0xEABAF9)
	    		  .parent((String)null));
	      	      
	}
}