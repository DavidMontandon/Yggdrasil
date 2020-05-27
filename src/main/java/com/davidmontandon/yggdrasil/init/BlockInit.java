package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Yggdrasil.MOD_ID) 
@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD)
public class BlockInit {

	// Blocks   --> CTRL + Leftclick for faster details of the vanilla blocks
	
	public static final Block yggdrasil_wood = null ;
	public static final Block yggdrasil_planks = null ;
	public static final Block rune_ore = null ; 
	public static final Block vanaheim_ore = null ; 
	//public static final Block niflheim_nickel = null ;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("yggdrasil_wood"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)).setRegistryName("yggdrasil_planks"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)).setRegistryName("rune_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)).setRegistryName("vanaheim_ore"));
	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(yggdrasil_wood, new Item.Properties().group(YggdrasilItemGroup.instance)).setRegistryName("yggdrasil_wood"));
		event.getRegistry().register(new BlockItem(yggdrasil_planks, new Item.Properties().group(YggdrasilItemGroup.instance)).setRegistryName("yggdrasil_planks"));
		event.getRegistry().register(new BlockItem(rune_ore, new Item.Properties().group(YggdrasilItemGroup.instance)).setRegistryName("rune_ore"));
		event.getRegistry().register(new BlockItem(vanaheim_ore, new Item.Properties().group(YggdrasilItemGroup.instance)).setRegistryName("vanaheim_ore"));
	}
	
}
