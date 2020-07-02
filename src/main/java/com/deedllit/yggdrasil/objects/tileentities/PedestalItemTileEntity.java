package com.deedllit.yggdrasil.objects.tileentities;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.container.PedestalItemContainer;
import com.deedllit.yggdrasil.init.YggdrasilTileEntityTypes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IClearable;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;

public class PedestalItemTileEntity extends LockableLootTileEntity implements IClearable, INamedContainerProvider {

	protected PedestalItemTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ITextComponent getDefaultName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		// TODO Auto-generated method stub
		return null;
	}


}