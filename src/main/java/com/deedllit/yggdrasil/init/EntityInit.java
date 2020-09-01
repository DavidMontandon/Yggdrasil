package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.entity.monster.FireSkeletonEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Yggdrasil.MOD_ID);
	
	/*
	public static final RegistryObject<EntityType<SkeletonEntity>> EXAMPLE_ENTITY = ENTITY_TYPES
			.register("fire_skeleton_entity",
					() -> EntityType.Builder.<SkeletonEntity>create(SkeletonEntity::new, EntityClassification.MONSTER)
							.size(0.6f, 1.99f)
							.build(new ResourceLocation(Yggdrasil.MOD_ID, "fire_skeleton_entity").toString()));
	*/
			
}
