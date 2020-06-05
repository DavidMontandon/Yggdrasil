package com.davidmontandon.yggdrasil.objects.items;

import java.util.List;
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

		
		tooltip.add(new TranslationTextComponent("desc." + this.desc + "_buff").applyTextStyle(TextFormatting.DARK_GREEN)
				.appendSibling(new StringTextComponent(""))
				.appendSibling(new TranslationTextComponent("desc." + this.desc + "_debuff").applyTextStyle(TextFormatting.DARK_RED))) ; 
		
		
		tooltip.add(new TranslationTextComponent("desc." + this.desc + "_buff").applyTextStyle(TextFormatting.DARK_GREEN)) ;
		tooltip.add(new StringTextComponent("xxx")) ; 
		tooltip.add(new StringTextComponent("yyy")) ; 
		tooltip.add(new TranslationTextComponent("desc." + this.desc + "_debuff").applyTextStyle(TextFormatting.DARK_RED)) ;
		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
