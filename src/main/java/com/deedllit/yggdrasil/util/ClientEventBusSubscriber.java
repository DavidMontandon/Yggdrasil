package com.deedllit.yggdrasil.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.client.gui.PedestalItemScreen;
import com.deedllit.yggdrasil.client.tileentity.render.PedestalItemRenderer;
import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.YggdrasilContainerTypes;
import com.deedllit.yggdrasil.init.YggdrasilTileEntityTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		//RenderTypeLookup.setRenderLayer(BlockInit.IRON_WOOD_SAPLING.get(), RenderType.getCutout());	
		
		/*
		 * MIDGARD
		 */
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_PINK_POMELIA_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_WHITE_POMELIA_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_ORANGE_POMELIA_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.IXIA_VIRIDIFLORA_TEAL_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_RED.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_PINK.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.FISH_HOOK.get(), RenderType.getCutout());		

		
		/*
		 * MUSPELHEIM
		 */
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_FIRE_POPPY.get(), RenderType.getCutout());		
		//RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_FARMLAND_BLOCK.get(), RenderType.getCutout());		
		//RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_IKADAMIA_CROP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_ASH_CARAMBOLA_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_DRAGON_GRASS.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_SLIM_GRASS.get(), RenderType.getCutout());		

		/*
		 * COMMON 
		 */		
		ScreenManager.registerFactory(YggdrasilContainerTypes.ITEM_PEDESTAL.get(), PedestalItemScreen::new);

		//ClientRegistry.bindTileEntityRenderer(YggdrasilTileEntityTypes.ITEM_PEDESTAL.get(), PedestalItemRenderer::new);
		
		Yggdrasil.LOGGER.info("Render Registered! ");
		
	}
	
}
