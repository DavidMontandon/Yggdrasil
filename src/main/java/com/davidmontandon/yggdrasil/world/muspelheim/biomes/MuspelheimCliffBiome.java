package com.davidmontandon.yggdrasil.world.muspelheim.biomes;

import com.davidmontandon.yggdrasil.init.StructureInit;
import com.davidmontandon.yggdrasil.world.muspelheim.config.MuspelheimDefaultBiomeFeatures;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class MuspelheimCliffBiome  extends Biome {
	//DefaultBiomeFeatures (CTRl+CLICK)
	
	public MuspelheimCliffBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10)) ; 

		MuspelheimDefaultBiomeFeatures.addCarver(this);
		MuspelheimDefaultBiomeFeatures.addLakes(this);
		MuspelheimDefaultBiomeFeatures.addSprings(this);
		//MuspelheimDefaultBiomeFeatures.addDenseGrass(this);
		MuspelheimDefaultBiomeFeatures.addOres(this);

				
        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StructureInit.YGGDRASIL_TREE_STRUCTURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))) ; 

	}
	


}