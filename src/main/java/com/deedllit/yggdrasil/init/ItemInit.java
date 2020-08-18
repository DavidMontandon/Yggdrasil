package com.deedllit.yggdrasil.init;

import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;
import com.deedllit.yggdrasil.Yggdrasil.YggdrasilToolItemGroup;
import com.deedllit.yggdrasil.common.item.VanafreintineHoe;
import com.deedllit.yggdrasil.init.Material.ArmorMaterial;
import com.deedllit.yggdrasil.init.Material.ToolMaterial;
import com.deedllit.yggdrasil.objects.items.DimensionKeyItem;
import com.deedllit.yggdrasil.objects.items.RuneItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;


public class ItemInit {

	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,  Yggdrasil.MOD_ID) ; 	
	
	//FLUID
	public static final RegistryObject<Item> ACIDIC_BUCKET = ITEMS.register("acidic_bucket",
			() -> new BucketItem(FluidInit.ACIDIC_FLUID, new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	
	
	//KEY
	public static final RegistryObject<Item> speical_item = ITEMS.register("special_item",
			() -> new DimensionKeyItem(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	
	//RUNES ELDER - 1st
	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_FEHU = ITEMS.register("rune_elder_futhark_first_aitt_fehu",
			() -> new RuneItem("rune_elder_futhark_first_aitt_fehu", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_URUZ = ITEMS.register("rune_elder_futhark_first_aitt_uruz",
			() -> new RuneItem("rune_elder_futhark_first_aitt_uruz", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_THURISAZ = ITEMS.register("rune_elder_futhark_first_aitt_thurisaz",
			() -> new RuneItem("rune_elder_futhark_first_aitt_thurisaz", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_ANSUZ = ITEMS.register("rune_elder_futhark_first_aitt_ansuz",
			() -> new RuneItem("rune_elder_futhark_first_aitt_ansuz", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_RAIDO = ITEMS.register("rune_elder_futhark_first_aitt_raido",
			() -> new RuneItem("rune_elder_futhark_first_aitt_raido", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_KENAZ = ITEMS.register("rune_elder_futhark_first_aitt_kenaz",
			() -> new RuneItem("rune_elder_futhark_first_aitt_kenaz", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_GEBO = ITEMS.register("rune_elder_futhark_first_aitt_gebo",
			() -> new RuneItem("rune_elder_futhark_first_aitt_gebo", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_FIRST_AITT_WUNJO = ITEMS.register("rune_elder_futhark_first_aitt_wunjo",
			() -> new RuneItem("rune_elder_futhark_first_aitt_wunjo", new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	//RUNES ELDER - 2nd

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_HAGALAZ = ITEMS.register("rune_elder_futhark_second_aitt_hagalaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_NAUTHIZ = ITEMS.register("rune_elder_futhark_second_aitt_nauthiz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_ISA = ITEMS.register("rune_elder_futhark_second_aitt_isa",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_JERA = ITEMS.register("rune_elder_futhark_second_aitt_jera",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_EIHWAZ = ITEMS.register("rune_elder_futhark_second_aitt_eihwaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_PERTHRO = ITEMS.register("rune_elder_futhark_second_aitt_perthro",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_ALGIZ = ITEMS.register("rune_elder_futhark_second_aitt_algiz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_SECOND_AITT_SOWILO = ITEMS.register("rune_elder_futhark_second_aitt_sowilo",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	//RUNES ELDER - 3rd

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_TIWAZ = ITEMS.register("rune_elder_futhark_third_aitt_tiwaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_BERKANA = ITEMS.register("rune_elder_futhark_third_aitt_berkana",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_EHWAZ = ITEMS.register("rune_elder_futhark_third_aitt_ehwaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_MANNAZ = ITEMS.register("rune_elder_futhark_third_aitt_mannaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));
	
	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_LAGUZ = ITEMS.register("rune_elder_futhark_third_aitt_laguz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_INGWAZ = ITEMS.register("rune_elder_futhark_third_aitt_ingwaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_OTHALA = ITEMS.register("rune_elder_futhark_third_aitt_othala",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUNE_ELDER_FUTHARK_THIRD_AITT_DAGAZ = ITEMS.register("rune_elder_futhark_third_aitt_dagaz",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	
	
	
	//Ores
	public static final RegistryObject<Item> VANAFREINTINE = ITEMS.register("vanafreintine",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> VANAFREINTINE_INGOT = ITEMS.register("vanafreintine_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> KEWHEATRIUM_INGOT = ITEMS.register("kewheatrium_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> RUBRILTH_INGOT = ITEMS.register("rubrilth_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));

	public static final RegistryObject<Item> TRAITHIL_INGOT = ITEMS.register("traithil_ingot",
			() -> new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)));


	//Blue,yellow,purpple,green,grey
	
	
	//Tools

	//public static final Item vanir_crescent_moon_boline = null ; 

	public static final RegistryObject<Item> iron_viking_sword = ITEMS.register("iron_viking_sword",
			() -> new SwordItem(ItemTier.IRON, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_viking_sword = ITEMS.register("vanir_viking_sword",
			() -> new SwordItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> SWORD_OF_FREYR = ITEMS.register("sword_of_freyr",
			() -> new SwordItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));
	
	public static final RegistryObject<Item> vanir_pickaxe = ITEMS.register("vanir_pickaxe",
			() -> new PickaxeItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_shovel = ITEMS.register("vanir_shovel",
			() -> new ShovelItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_axe = ITEMS.register("vanir_axe",
			() -> new AxeItem(ToolMaterial.VANAFREINTINE, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));

	public static final RegistryObject<Item> vanir_hoe = ITEMS.register("vanir_hoe",
			() -> new VanafreintineHoe(ToolMaterial.VANAFREINTINE, 5.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)));
	
	
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
	
	public static final RegistryObject<Item> MUSPELHEIM_ASH_CARAMBOLA_BERRY = ITEMS.register("muspelheim_ash_carambola_bush", 
			() -> new BlockItem(BlockInit.MUSPELHEIM_ASH_CARAMBOLA_BUSH.get(), new Item.Properties().group(YggdrasilToolItemGroup.instance)));
	
	
}
