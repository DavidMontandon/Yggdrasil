package com.davidmontandon.yggdrasil;

//import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.init.ItemInit;

//import java.util.stream.Collectors;

@Mod("yggdrasil")
public class Yggdrasil
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "yggdrasil" ; 
    public static Yggdrasil instance ; 
    
    public Yggdrasil() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus() ; 
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);

    	//FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        instance = this ; 
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    	LOGGER.info("HELLO FROM doClientStuff");
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    
    public static class YggdrasilRuneItemGroup extends ItemGroup {

    	public static final YggdrasilRuneItemGroup instance = new YggdrasilRuneItemGroup(ItemGroup.GROUPS.length, "YggdrasilRuneItemGroup") ; 

		private YggdrasilRuneItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.rune_elder_ansuz);
		}
    	
    }   
    
    public static class YggdrasilToolItemGroup extends ItemGroup {

    	public static final YggdrasilToolItemGroup instance = new YggdrasilToolItemGroup(ItemGroup.GROUPS.length, "YggdrasilToolItemGroup") ; 
    	
		private YggdrasilToolItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.vanir_viking_sword);
		}
    	
    }
 
    public static class YggdrasilItemGroup extends ItemGroup {

    	public static final YggdrasilItemGroup instance = new YggdrasilItemGroup(ItemGroup.GROUPS.length, "YggdrasilItemGroup") ; 
    	
		private YggdrasilItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.yggdrasil_wood);
		}
    	
    }
    

    
    

 }
