package com.davidmontandon.yggdrasil.init;

import java.util.function.Supplier;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilToolItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
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
	
	//Runes
	public static final Item rune_elder_ansuz = null ;
	public static final Item rune_elder_berkanan= null ;
	
	//Tools
	//public static final Item vanir_crescent_moon_boline = null ; 
	public static final Item iron_viking_sword = null ; 
	public static final Item vanir_viking_sword = null ; 
	public static final Item vanir_pickaxe = null ; 
	public static final Item vanir_shovel = null ; 
	public static final Item vanir_axe= null ; 
	public static final Item vanir_hoe = null ; 
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		//Runes
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_ansuz"));
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_berkanan"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ItemTier.IRON, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("iron_viking_sword"));

		event.getRegistry().register(new SwordItem(ModItemTier.VANIR, 7, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_viking_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.VANIR, 4, 1.2f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.VANIR, 4, 1.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.VANIR, 6, 0.9f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.VANIR, 5.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_hoe"));
		
		//event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(6).saturation(1.2f).effect(()-> new EffectInstance(Effects.HASTE, 1200,5), 1f).build())).setRegistryName("rune_elder_berkanan"));

	}
	
	public enum ModItemTier implements IItemTier
	{
		//Tier, Durability, efficiency, attack, enchant, supplier
		VANIR(4, 500, 15.0f, 7.0f, 250, () -> {
			return Ingredient.fromItems(ItemInit.rune_elder_ansuz) ; 
		});

		private final int harvestLevel; 
		private final int maxUses; 
		private final float efficiency ; 
		private final float attackDamage ;
		private final int enchantability ; 
		private final LazyValue<Ingredient> repairMaterial ;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			this.harvestLevel = harvestLevel ; 
			this.maxUses = maxUses ;
			this.efficiency = efficiency ;
			this.attackDamage = attackDamage ; 
			this.enchantability = enchantability ; 
			this.repairMaterial = new LazyValue<>(repairMaterial) ; 
			
		}
		
		@Override
		public int getMaxUses() {
			return maxUses; 
		}
		@Override
		public float getEfficiency() {
			return this.efficiency ; 
		}
		@Override
		public float getAttackDamage() {
			return this.attackDamage  ; 
		}
		@Override
		public int getHarvestLevel() {
			return this.harvestLevel ;
		}
		@Override
		public int getEnchantability() {
			return this.enchantability;  
		}
		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue() ; 
		} 
		

	}
	
}
