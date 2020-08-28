package com.deedllit.yggdrasil.world.dimensions.asgard.biomes;

import com.deedllit.yggdrasil.init.FeatureInit;
import com.deedllit.yggdrasil.world.dimensions.asgard.config.AsgardDefaultBiomeFeatures;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class AsgardDesertBiome extends Biome  {
	
	public AsgardDesertBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.NONE)
	    		  .category(Biome.Category.DESERT)
	    		  .depth(0.1F)
	    		  .scale(0.1F)
	    		  .temperature(1.0F)
	    		  .downfall(0.1F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent((String)null));
	      	      
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      DefaultBiomeFeatures.addDesertLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      
	      AsgardDefaultBiomeFeatures.addOres(this);
	      AsgardDefaultBiomeFeatures.addDiamondOre(this) ; 
	      AsgardDefaultBiomeFeatures.addEmeraldOre(this) ; 

	      DefaultBiomeFeatures.addSedimentDisks(this);
	      DefaultBiomeFeatures.addDeadBushes(this);
	      DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
	      DefaultBiomeFeatures.addSprings(this);
	      
	      this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, FeatureInit.ASGARD_GOLD_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(80))));

	      DefaultBiomeFeatures.addFreezeTopLayer(this);
	      
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.HUSK, 80, 4, 4));	      
	      
	}
	
	
}
