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

public class MuspelheimBeachBiome extends Biome {

	public MuspelheimBeachBiome() {
		
	    super((new Biome.Builder())
	    		  .surfaceBuilder(SurfaceBuilder.MOUNTAIN, YggdrasilSurfaceBuilderConfigLists.MUSPELHEIM_SAND_ASH_SAND)
	    		  .precipitation(Biome.RainType.NONE)
	    		  .category(Biome.Category.BEACH)
	    		  .depth(0.0F)
	    		  .scale(0.025F)
	    		  .temperature(2.0F)
	    		  .downfall(0.4F)
	    		  .func_235097_a_(
	    				  (new BiomeAmbience.Builder())
	    				  	.func_235246_b_(4159204)
	    				  	.func_235248_c_(329011)
	    				  	.func_235239_a_(12638463)
	    				  	.func_235243_a_(MoodSoundAmbience.field_235027_b_)
	    				  	.func_235238_a_())
	    		  .parent((String)null)
	    		  .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.0F, 0.0F, -0.1F, 0.0F, 0.9935F))));

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
