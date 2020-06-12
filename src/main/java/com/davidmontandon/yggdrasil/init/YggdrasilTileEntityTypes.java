package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.objects.tileentities.ItemPedestalTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YggdrasilTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<TileEntityType<ItemPedestalTileEntity>> ITEM_PEDESTAL = TILE_ENTITY_TYPES
			.register("item_pedestal", () -> TileEntityType.Builder
					.create(ItemPedestalTileEntity::new, BlockInit.ITEM_PEDESTAL.get()).build(null));
	
}
