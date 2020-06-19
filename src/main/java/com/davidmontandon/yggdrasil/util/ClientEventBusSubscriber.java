package com.davidmontandon.yggdrasil.util;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.client.gui.PedestalItemScreen;
import com.davidmontandon.yggdrasil.client.tileentity.render.PedestalItemRenderer;
import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.init.YggdrasilContainerTypes;
import com.davidmontandon.yggdrasil.init.YggdrasilTileEntityTypes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.IRON_WOOD_SAPLING.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_IKADAMIA_CROP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_ASH_CARAMBOLA_BUSH.get(), RenderType.getCutout());		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_DRAGON_GRAS.get(), RenderType.getCutout());		

		
		ScreenManager.registerFactory(YggdrasilContainerTypes.ITEM_PEDESTAL.get(), PedestalItemScreen::new);

		ClientRegistry.bindTileEntityRenderer(YggdrasilTileEntityTypes.ITEM_PEDESTAL.get(), PedestalItemRenderer::new);
		
		Yggdrasil.LOGGER.info("Render Registered! ");
		
	}
	
}
