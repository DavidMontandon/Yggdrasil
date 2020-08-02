package com.deedllit.yggdrasil.world.dimensions.midgard.biomes;

import java.util.List;

import com.deedllit.yggdrasil.init.SurfaceBuilderInit;
import com.deedllit.yggdrasil.world.dimensions.midgard.config.MidgardDefaultBiomeFeatures;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.BuriedTreasureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.OceanRuinConfig;
import net.minecraft.world.gen.feature.structure.OceanRuinStructure;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardTropicalBeachBiome extends Biome {

	public MidgardTropicalBeachBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.TROPICAL, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.BEACH)
	    		  .depth(0.1F)
	    		  .scale(0.02F)
	    		  .temperature(0.9F)
	    		  .downfall(0.8F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent((String) null ));

	      this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
	      this.addStructure(Feature.BURIED_TREASURE.withConfiguration(new BuriedTreasureConfig(0.01F)));
	      this.addStructure(Feature.SHIPWRECK.withConfiguration(new ShipwreckConfig(true)));

	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addDesertLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);

	      /*
	      MidgardDefaultBiomeFeatures.addTropicalVegetation(this);
	      MidgardDefaultBiomeFeatures.addDesertFlowers(this); 
	      MidgardDefaultBiomeFeatures.addExtraPomelias(this);
	      
	      DefaultBiomeFeatures.addSprings(this);
	      */
	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 2, 2, 3));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 5, 4, 4));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 10, 1, 2));
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
