package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilRuneItemGroup;
import com.davidmontandon.yggdrasil.Yggdrasil.YggdrasilToolItemGroup;
import com.davidmontandon.yggdrasil.init.Material.ArmorMaterial;
import com.davidmontandon.yggdrasil.init.Material.ToolMaterial;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
	
	//Ores
	public static final Item vanafreintine = null ; 
	public static final Item vanafreintine_ingot = null ; 
	public static final Item kewheatrium_ingot = null ; 
	
	//Tools
	//public static final Item vanir_crescent_moon_boline = null ; 
	public static final Item iron_viking_sword = null ; 
	public static final Item vanir_viking_sword = null ; 
	public static final Item vanir_pickaxe = null ; 
	public static final Item vanir_shovel = null ; 
	public static final Item vanir_axe= null ; 
	public static final Item vanir_hoe = null ; 
	
	//Armor
	public static final Item vanafreintine_helmet = null ; 
	public static final Item vanafreintine_chestplate = null ; 
	public static final Item vanafreintine_leggings = null ; 
	public static final Item vanafreintine_boots= null ; 
	
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		
		//Runes
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_ansuz"));
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("rune_elder_berkanan"));

		//Ores
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("vanafreintine"));
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("vanafreintine_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(YggdrasilRuneItemGroup.instance)).setRegistryName("kewheatrium_ingot"));

		
		//Tools
		event.getRegistry().register(new SwordItem(ItemTier.IRON, 6, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("iron_viking_sword"));

		event.getRegistry().register(new SwordItem(ToolMaterial.VANAFREINTINE, 7, 1.7f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_viking_sword"));
		event.getRegistry().register(new PickaxeItem(ToolMaterial.VANAFREINTINE, 4, 1.2f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_pickaxe"));
		event.getRegistry().register(new ShovelItem(ToolMaterial.VANAFREINTINE, 4, 1.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_shovel"));
		event.getRegistry().register(new AxeItem(ToolMaterial.VANAFREINTINE, 6, 0.9f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_axe"));
		event.getRegistry().register(new HoeItem(ToolMaterial.VANAFREINTINE, 5.0f, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanir_hoe"));
		
		
		//Armor
		event.getRegistry().register(new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.HEAD, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanafreintine_helmet"));
		event.getRegistry().register(new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.CHEST, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanafreintine_chestplate"));
		event.getRegistry().register(new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.LEGS, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanafreintine_leggings"));
		event.getRegistry().register(new ArmorItem(ArmorMaterial.VANAFREINTINE, EquipmentSlotType.FEET, new Item.Properties().group(YggdrasilToolItemGroup.instance)).setRegistryName("vanafreintine_boots"));
		
		
		
		//event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(6).saturation(1.2f).effect(()-> new EffectInstance(Effects.HASTE, 1200,5), 1f).build())).setRegistryName("rune_elder_berkanan"));

	}
	
	/*
	public enum ModArmorMaterial implements IArmorMaterial {
		
		
		//Feet, leg, chest, head
		VANAFREINTINE(Yggdrasil.MOD_ID + ":vanafreintine", 5, new int[] {3,9,11,5}, 420, null, 6.9f, () -> {
			return Ingredient.fromItems(ItemInit.vanafreintine_ingot) ; 			
		}) ; 
		
		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent ;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}
		
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}
		
		public int getEnchantability() {
			return this.enchantability;
		}
		
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}
		
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
		public String getName() {
			return this.name;
		}
		
		public float getToughness() {
			return this.toughness;
		}
		 
	}
	*/
	
	/*
	public enum ModItemTier implements IItemTier {
		
		//Tier, Durability, efficiency, attack, enchant, supplier
		KEWHEATRIUM(4, 500, 15.0f, 7.0f, 250, () -> {
			return Ingredient.fromItems(ItemInit.kewheatrium_ingot) ; 
		}),
		VANAFREINTINE(4, 500, 15.0f, 7.0f, 250, () -> {
			return Ingredient.fromItems(ItemInit.vanafreintine_ingot) ; 
		}) ;
		

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
	 */
	
}
