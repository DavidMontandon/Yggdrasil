package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.feature.structure.YggdrasilTreeStructure;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class StructureInit {

	
	public static final DeferredRegister<Feature<?>> STRUCTURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Yggdrasil.MOD_ID);	
	
    @ObjectHolder(Yggdrasil.MOD_ID + ":yggdrasil_tree_structure")
    public static final Structure<NoFeatureConfig> YGGDRASIL_TREE_STRUCTURE = registerStructure(new YggdrasilTreeStructure(NoFeatureConfig::deserialize), "yggdrasil_tree_structure");

        
    private static <T extends IFeatureConfig> Structure<T> registerStructure(Structure<T> structure, String registryName) {
        structure.setRegistryName(Yggdrasil.MOD_ID, registryName);

        STRUCTURES.register(registryName, () -> new YggdrasilTreeStructure(NoFeatureConfig::deserialize));
        return structure;
    }
    
    
}
