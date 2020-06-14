package com.davidmontandon.yggdrasil.util;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
				
		
		//Yggdrasil.dh.doRegister(); 
		
		
		if (DimensionType.byName(Yggdrasil.YGGDRASIL_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.YGGDRASIL_DIM_TYPE, DimensionInit.MUSPELHEIM.get(), null, true);
		
		if (DimensionType.byName(Yggdrasil.SVARTALVHEIM_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.SVARTALVHEIM_DIM_TYPE, DimensionInit.SVARTALVHEIM.get(), null, true);
					
	}
}