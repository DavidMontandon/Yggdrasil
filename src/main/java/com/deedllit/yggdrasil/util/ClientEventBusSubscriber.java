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
		
		RenderType basicRender =  RenderType.getCutout();

		
		/*
		 * MIDGARD
		 */
		RenderTypeLookup.setRenderLayer(BlockInit.CHARDON.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_PINK_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_WHITE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_ORANGE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_BLUE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_TEAL_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.IXIA_VIRIDIFLORA_TEAL_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_RED.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_PINK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.FISH_HOOK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.SWEET_PEA.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.DESERT_GRASS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.EDELWEISS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HIBICUS_TREE_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PALM_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.RED_SUNFLOWER.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_SUNFLOWER.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.COPPER_BARS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.LEAD_BARS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_SEA_HORSE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_RICE_BOTTOM_CROP.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.ALPINE_BETONY.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.FIRELILY.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.LAVENDER.get(), basicRender);		
		
		//RenderTypeLookup.setRenderLayer(BlockInit.PISTIA_WATER_LETTUCE.get(), basicRender);		
		//RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_RICE_TOP_CROP.get(), basicRender);		

		/*
		 * MUSPELHEIM
		 */
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_FIRE_POPPY.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_FARMLAND_BLOCK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_IKADAMIA_CROP.get(), basicRender);
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_ASH_CARAMBOLA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_DRAGON_GRASS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MUSPELHEIM_SLIM_GRASS.get(), basicRender);		

		/*
		 * COMMON 
		 */		
		
		ScreenManager.registerFactory(YggdrasilContainerTypes.ITEM_PEDESTAL.get(), PedestalItemScreen::new);

		ClientRegistry.bindTileEntityRenderer(YggdrasilTileEntityTypes.ITEM_PEDESTAL.get(), PedestalItemRenderer::new);
		
		Yggdrasil.LOGGER.info("Render Registered! ");
		
	}
	
}
