package com.davidmontandon.yggdrasil.objects.items;

import java.util.List;

import com.davidmontandon.yggdrasil.util.helpers.TranslateHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class RuneItem extends Item {

	private String desc ; 
	
	public RuneItem(String desc, Properties properties) {
		super(properties);

		this.desc = desc ; 
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		
		tooltip.add(new StringTextComponent(  "\u00A7e" +  TranslateHelper.getTranslate("desc." + this.desc + "_buff") + 
					" \u00A74" + TranslateHelper.getTranslate("desc." + this.desc + "_debuff")));
		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
