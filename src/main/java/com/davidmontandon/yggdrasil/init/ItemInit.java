package com.davidmontandon.yggdrasil.init;

import java.util.function.Supplier;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_ansuz"));
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_berkanan"));
		
		
		//event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(6).saturation(1.2f).effect(()-> new EffectInstance(Effects.HASTE, 1200,5), 1f).build())).setRegistryName("rune_elder_berkanan"));

	}
	
	
}
