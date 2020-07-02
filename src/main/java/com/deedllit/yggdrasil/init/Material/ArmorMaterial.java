package com.deedllit.yggdrasil.init.Material;

import java.util.function.Supplier;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.ItemInit;

import net.minecraft.util.SoundEvent ; 
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ArmorMaterial implements IArmorMaterial {
		
	//Feet, leg, chest, head
	KEWHEATRIUM(Yggdrasil.MOD_ID + ":kewheatrium", 5, new int[] {3,9,11,5}, 420, null, 6.9f, () -> {
		return Ingredient.fromItems(ItemInit.VANAFREINTINE_INGOT.get()) ; 			
	}), 
	VANAFREINTINE(Yggdrasil.MOD_ID + ":vanafreintine", 5, new int[] {3,9,11,5}, 420, null, 6.9f, () -> {
		return Ingredient.fromItems(ItemInit.VANAFREINTINE_INGOT.get()) ; 			
	}) ; 
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent ;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	
	private ArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
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

	@Override
	public float func_230304_f_() {
		return this.toughness;
	}


	 
}