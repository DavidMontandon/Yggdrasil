package com.deedllit.yggdrasil.common.item;

import java.util.Map;

import com.deedllit.yggdrasil.init.BlockInit;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VanafreintineHoe extends HoeItem {
	
	protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(
			BlockInit.MUSPELHEIM_GRASS.get(),	Blocks.FARMLAND.getDefaultState()
			));

	   
	public VanafreintineHoe(IItemTier tier, float attackSpeedIn, Properties builder) {
		super(tier, attackSpeedIn, builder);
	}

	
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
	    BlockPos blockpos = context.getPos();
	    int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
	    if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
	    if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
	       BlockState blockstate = HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());
	       if (blockstate != null) {
	          PlayerEntity playerentity = context.getPlayer();
	          world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
	          if (!world.isRemote) {
	             world.setBlockState(blockpos, blockstate, 11);
	             if (playerentity != null) {
	                context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
	                   p_220043_1_.sendBreakAnimation(context.getHand());
	                });
	             }
	          }

	          return ActionResultType.SUCCESS;
	       }
	    }

	    return ActionResultType.PASS;
	 }
	
}
