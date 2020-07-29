package com.deedllit.yggdrasil.common.biome;

import java.util.Optional;

import com.deedllit.mythologycraft.common.BiomeRegistry;
import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.init.BiomeInit;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.biomes.*;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


import static com.deedllit.mythologycraft.biomes.YggdrasilBiomes.*;
import static com.deedllit.mythologycraft.config.MCConfig.* ; 

/*
 * Strongly inspirated by Biomes O' Plenty : https://github.com/Glitchfiend/BiomesOPlenty
 */


//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {


    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event)
    {
    	Yggdrasil.LOGGER.info("DEBUG : registerBiomes in");	
    	BiomeInit.registerBiomes();
    	
    	if(YGGDRASIL_WORLD.get()) {
    		
    		if(YGGDRASIL_MUSPELHEIM_DIMENSION.get()) {
    			//registerBiome(new MuspelheimFirePoppyField(), "muspelheim_fire_poppy_field");
    			
    		}
    		
    	}
    	
    	registerBiomeDictionaryTags() ; 
    	
    	Yggdrasil.LOGGER.info("DEBUG : registerBiomes done");	
    }
	
    
    private static void registerBiomeDictionaryTags() {
    	
    	if(YGGDRASIL_WORLD.get()) {
    
    		if(YGGDRASIL_MUSPELHEIM_DIMENSION.get()) {
    			//registerBiomeToDictionary(muspelheim_fire_poppy_field, Type.HOT) ;
    		}
    		
    	}
    	
    }
    
    public static void registerBiome(YggdrasilBiome biome, String name)
    {
        BiomeRegistry.deferStandardRegistration(biome, name);
    }
    
    private static void registerBiomeToDictionary(Optional<Biome> biome, Type...types)
    {
        if (biome.isPresent())
        {
            BiomeDictionary.addTypes(biome.get(), types);
        }
    }
	
}
