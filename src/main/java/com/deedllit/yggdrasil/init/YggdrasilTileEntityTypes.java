package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.objects.tileentities.PedestalItemTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YggdrasilTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, Yggdrasil.MOD_ID);
	
	public static final RegistryObject<TileEntityType<PedestalItemTileEntity>> ITEM_PEDESTAL = TILE_ENTITY_TYPES
			.register("pedestal_item", () -> TileEntityType.Builder
					.create(PedestalItemTileEntity::new, BlockInit.PEDESTAL_ITEM.get()).build(null));
	
}
