package com.davidmontandon.yggdrasil.events;
import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.init.BlockInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent {

	//@SubscribeEvent
	public static void testJumpEvent(LivingJumpEvent event)  {
		Yggdrasil.LOGGER.info("Test jump event fire");
		LivingEntity livingEntity = event.getEntityLiving() ; 
		World world = livingEntity.getEntityWorld() ; 
		
		
		world.setBlockState(livingEntity.getPosition().add(0,5,0), BlockInit.YGGDRASIL_WOOD.get().getDefaultState()) ; 
		livingEntity.addPotionEffect( new EffectInstance(Effects.JUMP_BOOST, 600, 255)) ; 
		livingEntity.addPotionEffect( new EffectInstance(Effects.RESISTANCE, 5000, 255)) ; 
		livingEntity.setGlowing( true );
		
	}
	
}
