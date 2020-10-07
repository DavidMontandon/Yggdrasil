package com.deedllit.yggdrasil.util;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.DimensionInit;

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
		
		
		if (DimensionType.byName(Yggdrasil.ASGARD_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.ASGARD_DIM_TYPE, DimensionInit.ASGARD.get(), null, true);

		DimensionManager.registerDimension(Yggdrasil.MIDGARD_DIM_TYPE, DimensionInit.MIDGARD.get(), null, true);

		if (DimensionType.byName(Yggdrasil.MUSPELHEIM_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.MUSPELHEIM_DIM_TYPE, DimensionInit.MUSPELHEIM.get(), null, true);
		
		if (DimensionType.byName(Yggdrasil.NIFELHEIM_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.NIFELHEIM_DIM_TYPE, DimensionInit.NIFELHEIM.get(), null, true);

		if (DimensionType.byName(Yggdrasil.SVARTALVHEIM_DIM_TYPE) == null) 
			DimensionManager.registerDimension(Yggdrasil.SVARTALVHEIM_DIM_TYPE, DimensionInit.SVARTALVHEIM.get(), null, true);
	
		
		
		
	}
}