package com.deedllit.yggdrasil;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.init.BlockInit;
import com.deedllit.yggdrasil.init.CarverInit;
import com.deedllit.yggdrasil.init.DimensionInit;
import com.deedllit.yggdrasil.init.FluidInit;
import com.deedllit.yggdrasil.init.ItemInit;
import com.deedllit.yggdrasil.init.PaintingInit;
import com.deedllit.yggdrasil.init.StructureInit;
import com.deedllit.yggdrasil.init.YggdrasilContainerTypes;
import com.deedllit.yggdrasil.init.YggdrasilTileEntityTypes;
import com.deedllit.yggdrasil.objects.blocks.muspelheim.MuspelheimIkadamiaCropBlock;
import com.deedllit.yggdrasil.objects.bushes.muspelheim.MuspelheimAshCarambola;
import com.deedllit.yggdrasil.util.holder.DimensionsHolder;
import com.deedllit.yggdrasil.world.gen.OverworldAddFeatures;


@Mod("yggdrasil")
@Mod.EventBusSubscriber(modid = Yggdrasil.MOD_ID, bus = Bus.MOD)
public class Yggdrasil
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "yggdrasil" ; 
    public static Yggdrasil instance ; 
    
    public static DimensionsHolder dh = new DimensionsHolder(MOD_ID) ; 
    
    public static final ResourceLocation YGGDRASIL_DIM_TYPE = new ResourceLocation(MOD_ID, "muspelheim") ;  
    public static final ResourceLocation SVARTALVHEIM_DIM_TYPE = new ResourceLocation(MOD_ID, "svartalvheim") ;  
    public static final ResourceLocation NIFELHEIM_DIM_TYPE = new ResourceLocation(MOD_ID, "nifelheim") ;  
            
    public Yggdrasil() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus() ; 
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	    	
        dh.addDimension("muspelheim") ;
        dh.addDimension("nivlheim") ;
        dh.addDimension("nifelheim");
    	
    	ItemInit.ITEMS.register(modEventBus);
    	FluidInit.FLUIDS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
		YggdrasilTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		YggdrasilContainerTypes.CONTAINER_TYPES.register(modEventBus);
		StructureInit.STRUCTURES.register(modEventBus);
    	BiomeInit.BIOMES.register(modEventBus);
    	DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    	PaintingInit.PAINTINGS.register(modEventBus);
    	CarverInit.CAVERS.register(modEventBus);
    	
        instance = this ; 
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    
    
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInit.BLOCKS.getEntries().stream()
		.filter(block -> 
			!(block.get() instanceof MuspelheimIkadamiaCropBlock) && 
			!(block.get() instanceof MuspelheimAshCarambola) && 
			!(block.get() instanceof FlowingFluidBlock))
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
	
	private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	//OverworldAddFeatures.generateOre() ; 
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
    
    
    

 }