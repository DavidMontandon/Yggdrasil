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
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardMangroveRiverBiome extends Biome {
//SurfaceBuilderInit
	public MidgardMangroveRiverBiome() {
	      super((new Biome.Builder()).surfaceBuilder(
	    		  new ConfiguredSurfaceBuilder(SurfaceBuilderInit.MANGROVE, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG))
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.RIVER)
	    		  .depth(-0.25F)
	    		  .scale(0.0025F)
	    		  .temperature(0.80F)
	    		  .downfall(0.5F)
	    		  .func_235097_a_((new BiomeAmbience.Builder())
	    				  .func_235246_b_(4159204)
	    				  .func_235248_c_(329011)
	    				  .func_235239_a_(12638463)
	    				  .func_235243_a_(MoodSoundAmbience.field_235027_b_)
	    				  .func_235238_a_())
	    		  .parent("river")
	    		  .func_235098_a_(ImmutableList.of(new Biome.Attributes(0.5F, 0.5F, 0.0F, 0.0F, 1.0F))));
	      
	      this.func_235063_a_(DefaultBiomeFeatures.field_235172_j_);
	      this.func_235063_a_(DefaultBiomeFeatures.field_235150_b_);
	      this.func_235063_a_(DefaultBiomeFeatures.field_235130_B_);
	      
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.func_235191_ai_(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSwampClayDisks(this);
	      MidgardDefaultBiomeFeatures.addMangroveVegetation(this);
	      MidgardDefaultBiomeFeatures.addMangroveExtraPomelias(this);
	      DefaultBiomeFeatures.addMushrooms(this);
	      DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
	      DefaultBiomeFeatures.addSprings(this);
	      
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	      
	      //this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
	      //this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      //this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
	      
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 15, 3, 6));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 10, 4, 4));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.PUFFERFISH, 15, 1, 3));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 8, 8));

	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 40, 1, 2));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 1, 1, 1));
	      
	   }

	   @OnlyIn(Dist.CLIENT)
	   public int getGrassColor(double posX, double posZ) {
	      double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	      return d0 < -0.1D ? 5011004 : 6975545;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public int getFoliageColor() {
	      return 6975545;
	   }

}
