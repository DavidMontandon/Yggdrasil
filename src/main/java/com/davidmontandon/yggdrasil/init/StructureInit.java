package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.feature.structure.YggdrasilTreeStructure;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class StructureInit {
	/*
	public static final DeferredRegister<Feature<?>> STRUCTURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES,  Yggdrasil.MOD_ID) ; 	
	public static final RegistryObject<YggdrasilTreeStructure> YGGDRASIL_TREE_STRUCTURE = STRUCTURES.register("yggdrasil_tree_structure",
			() -> new YggdrasilTreeStructure(NoFeatureConfig::deserialize));
	*/
	
	
    public static final Structure<NoFeatureConfig> YGGDRASIL_TREE_STRUCTURE = new YggdrasilTreeStructure(NoFeatureConfig::deserialize);
    
    public static void registerStructures(RegistryEvent.Register<Feature<?>> event){
    	IForgeRegistry<Feature<?>> registry = event.getRegistry() ;
       	RegUtil.register(registry, YGGDRASIL_TREE_STRUCTURE, "yggdrasil_tree_structure");
       
       	Yggdrasil.LOGGER.info("YGGDRASIL_TREE_STRUCTURE REGISTRED");
       	
    }
    
	
}
