package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.MidgardDefaultBiomeFeatures;
import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardChaparralTropicalBiome extends Biome {
	
	public MidgardChaparralTropicalBiome() {
	      super((new Biome.Builder()).surfaceBuilder(
	    		  new ConfiguredSurfaceBuilder(SurfaceBuilderInit.CHAPARRAL, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG))
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.PLAINS)
	    		  .depth(1.25F)
	    		  .scale(0.325F)
	    		  .temperature(0.80F)
	    		  .downfall(0.3F)
	    		  .func_235097_a_((new BiomeAmbience.Builder())
	    				  .func_235246_b_(4159204)
	    				  .func_235248_c_(329011)
	    				  .func_235239_a_(12638463)
	    				  .func_235243_a_(MoodSoundAmbience.field_235027_b_)
	    				  .func_235238_a_())
	    		  .parent((String)null)
	    		  .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.5F, 0.0F, 0.0F, 0.0F, 1.05F))));
	      
	      
	      
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addDesertLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      MidgardDefaultBiomeFeatures.addRice(this) ; 
	      MidgardDefaultBiomeFeatures.addJungleTrees(this);
	      MidgardDefaultBiomeFeatures.addTropicalVegetation(this);
	      MidgardDefaultBiomeFeatures.addExtraTropicalVegetation(this);
	      MidgardDefaultBiomeFeatures.addBamboo(this);
	      MidgardDefaultBiomeFeatures.addBambooJungleVegetation(this) ;
	      MidgardDefaultBiomeFeatures.addDesertFlowers(this); 
	      MidgardDefaultBiomeFeatures.addExtraPomelias(this);
	      
	      MidgardDefaultBiomeFeatures.addCactus(this);
	      MidgardDefaultBiomeFeatures.addExtraCactus(this);
	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 10, 1, 2));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

	      
	}
	
	
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	    return d0 < -0.1D ? 10066176 : 10526720;
	}
}
