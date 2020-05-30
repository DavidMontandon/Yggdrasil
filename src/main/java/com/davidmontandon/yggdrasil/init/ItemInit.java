package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilToolItemGroup;
import com.davidmontandon.yggdrasil.init.Material.ToolMaterial;
import com.davidmontandon.yggdrasil.init.Material.ArmorMaterial;

import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;


public class ItemInit {

	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,  Yggdrasil.MOD_ID) ; 	
	
	
	//RUNES
	public static final RegistryObject<Item> rune_elder_ansuz = ITEMS.register("rune_elder_ansuz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> rune_elder_berkanan = ITEMS.register("rune_elder_berkanan",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	

	
	//Ores
	public static final RegistryObject<Item> vanafreintine = ITEMS.register("vanafreintine",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> vanafreintine_ingot = ITEMS.register("vanafreintine_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> kewheatrium_ingot = ITEMS.register("kewheatrium_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));


	
	//Tools

	//public static final Item vanir_crescent_moon_boline = null ; 

	public static final RegistryObject<Item> iron_viking_sword = ITEMS.register("iron_viking_sword",
			() -> new SwordItem(ItemTier.IRON, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_viking_sword = ITEMS.register("vanir_viking_sword",
			() -> new SwordItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_pickaxe = ITEMS.register("vanir_pickaxe",
			() -> new PickaxeItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_shovel = ITEMS.register("vanir_shovel",
			() -> new ShovelItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_axe = ITEMS.register("vanir_axe",
			() -> new AxeItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_hoe = ITEMS.register("vanir_hoe",
			() -> new HoeItem(ToolMaterial.VANAFREINTINE, 5.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	//Armor
	public static final RegistryObject<Item> vanafreintine_helmet = ITEMS.register("vanafreintine_helmet",
			() -> new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.HEAD, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanafreintine_chestplate = ITEMS.register("vanafreintine_chestplate",
			() -> new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.CHEST, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanafreintine_leggings = ITEMS.register("vanafreintine_leggings",
			() -> new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.LEGS, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanafreintine_boots = ITEMS.register("vanafreintine_boots",
			() -> new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.FEET, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	//Seed
	public static final RegistryObject<Item> MUSPELHEIM_IKADAMIA_SEED = ITEMS.register("muspelheim_ikadamia_seed",
			() -> new BlockItem(BlockInit.MUSPELHEIM_IKADAMIA_CROP.get(), new Item.Properties().group(YggdrasilToolItemGroup.instance)));
	
	
	
}
