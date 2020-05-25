package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Yggdrasil.MOD_ID) 
public class ItemInit {
	
	//https://sonsofvikings.com/blogs/history/viking-runes-guide-runic-alphabet-meanings-nordic-celtic-letters
	
	//@ObjectHolder(Yggdrasil.MOD_ID + "rune_elder_ansuz") 
	//public static Item rune_elder_ansuz;
	public static final Item rune_elder_ansuz = null ;
	public static final Item rune_elder_berkanan= null ;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("rune_elder_ansuz"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("rune_elder_berkanan"));
	}
	
	
}
