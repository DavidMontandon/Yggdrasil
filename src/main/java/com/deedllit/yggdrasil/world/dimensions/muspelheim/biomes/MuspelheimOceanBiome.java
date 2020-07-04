package com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes;

import com.deedllit.yggdrasil.world.dimensions.muspelheim.config.MuspelheimDefaultBiomeFeatures;
import com.deedllit.yggdrasil.world.gen.YggdrasilSurfaceBuilderConfigLists;
import com.google.common.collect.ImmutableList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MuspelheimOceanBiome extends Biome {

	public MuspelheimOceanBiome() {
	      super((new Biome.Builder())
	    		  .surfaceBuilder(SurfaceBuilder.DEFAULT, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_HOTROCK_COLDROCK_SAND)
	    		  .precipitation(Biome.RainType.NONE)
	    		  .category(Biome.Category.OCEAN)
	    		  .depth(-1.125F)
	    		  .scale(0.1F)
	    		  .temperature(2.0F)
	    		  .downfall(0.5F)
	    		  .func_235097_a_(
	    				  (new BiomeAmbience.Builder())
	    				  	.func_235246_b_(4159204)
	    				  	.func_235248_c_(329011)
	    				  	.func_235239_a_(12638463)
	    				  	.func_235243_a_(MoodSoundAmbience.field_235027_b_)
	    				  	.func_235238_a_())
	    		  .parent((String)null)
	    		  .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.0F, 0.0F, -0.5F, 0.0F, 1.0F))));
	      
	      MuspelheimDefaultBiomeFeatures.addCarvers(this) ; 
	      MuspelheimDefaultBiomeFeatures.addLakes(this) ; 
	      MuspelheimDefaultBiomeFeatures.addOres(this);
	      MuspelheimDefaultBiomeFeatures.addVanillaOres(this) ; 
	      MuspelheimDefaultBiomeFeatures.addPlants(this) ; 
	      MuspelheimDefaultBiomeFeatures.addTrees(this) ; 
	      MuspelheimDefaultBiomeFeatures.addSprings(this) ; 

	      
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getSkyColor() {
		return MuspelheimDefaultBiomeFeatures.SKY_COLOR;
	}
}
