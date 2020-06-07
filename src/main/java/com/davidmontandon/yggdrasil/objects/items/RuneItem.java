package com.davidmontandon.yggdrasil.objects.items;

import java.util.List;

import com.davidmontandon.yggdrasil.Yggdrasil;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class RuneItem extends Item {

	private String desc ; 	
	
	public RuneItem(String desc, Properties properties) {
		super(properties);
		this.desc = desc ; 
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {		

		String pathDesc = "desc." + Yggdrasil.MOD_ID + "." + this.desc; 
	
		tooltip.add(new TranslationTextComponent( pathDesc ).applyTextStyle(TextFormatting.YELLOW)) ;
		tooltip.add(new StringTextComponent("Buff:")) ; 
		tooltip.add(new TranslationTextComponent( pathDesc + "_buff").applyTextStyle(TextFormatting.DARK_GREEN)) ;
		tooltip.add(new StringTextComponent("Debuff:")) ; 
		tooltip.add(new TranslationTextComponent( pathDesc + "_debuff").applyTextStyle(TextFormatting.DARK_RED)) ;
	
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
