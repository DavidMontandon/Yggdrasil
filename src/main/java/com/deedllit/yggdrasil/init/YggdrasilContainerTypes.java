package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.container.PedestalItemContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YggdrasilContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(
			ForgeRegistries.CONTAINERS, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<ContainerType<PedestalItemContainer>> ITEM_PEDESTAL = CONTAINER_TYPES
			.register("pedestal_item", () -> IForgeContainerType.create(PedestalItemContainer::new));
	
}
