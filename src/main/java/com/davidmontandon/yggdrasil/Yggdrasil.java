package com.davidmontandon.yggdrasil;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.davidmontandon.yggdrasil.init.BiomeInit;
import com.davidmontandon.yggdrasil.init.BlockInit;
import com.davidmontandon.yggdrasil.init.DimensionInit;
import com.davidmontandon.yggdrasil.init.FeatureInit;
import com.davidmontandon.yggdrasil.init.FluidInit;
import com.davidmontandon.yggdrasil.init.ItemInit;
import com.davidmontandon.yggdrasil.init.PaintingInit;
import com.davidmontandon.yggdrasil.init.StructureInit;
import com.davidmontandon.yggdrasil.objects.blocks.muspelheim.MuspelheimIkadamiaCropBlock;
import com.davidmontandon.yggdrasil.world.gen.OverworldOreGen;

@Mod("yggdrasil")
@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD)
public class Yggdrasil
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "yggdrasil" ; 
    public static Yggdrasil instance ; 
    public static final ResourceLocation YGGDRASIL_DIM_TYPE = new ResourceLocation(MOD_ID, "muspelheim") ;  
        
    
    public Yggdrasil() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus() ; 
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	    	
    	ItemInit.ITEMS.register(modEventBus);
    	FluidInit.FLUIDS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
    	BiomeInit.BIOMES.register(modEventBus);
    	DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    	PaintingInit.PAINTINGS.register(modEventBus);
    	
        instance = this ; 
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    
    
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInit.BLOCKS.getEntries().stream()
		.filter(block -> !(block.get() instanceof MuspelheimIkadamiaCropBlock) && !(block.get() instanceof FlowingFluidBlock))
		.map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(YggdrasilItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	OverworldOreGen.generateOre() ; 
    }
    
    public static class YggdrasilRuneItemGroup extends ItemGroup {

    	public static final YggdrasilRuneItemGroup instance = new YggdrasilRuneItemGroup(ItemGroup.GROUPS.length, "YggdrasilRuneItemGroup") ; 

		private YggdrasilRuneItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.RUNE_ELDER_FUTHARK_FIRST_AITT_FEHU.get());
		}
    	
    }   
    
    public static class YggdrasilToolItemGroup extends ItemGroup {

    	public static final YggdrasilToolItemGroup instance = new YggdrasilToolItemGroup(ItemGroup.GROUPS.length, "YggdrasilToolItemGroup") ; 
    	
		private YggdrasilToolItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.vanir_viking_sword.get());
		}
    	
    }
 
    public static class YggdrasilItemGroup extends ItemGroup {

    	public static final YggdrasilItemGroup instance = new YggdrasilItemGroup(ItemGroup.GROUPS.length, "YggdrasilItemGroup") ; 
    	
		private YggdrasilItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.YGGDRASIL_WOOD.get());
		}
    	
    }
    
	@SubscribeEvent
	public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event) 
	{
	    //FeatureInit.registerFeatures(event);
	    //StructureInit.registerStructures(event);
	}
    
    

 }