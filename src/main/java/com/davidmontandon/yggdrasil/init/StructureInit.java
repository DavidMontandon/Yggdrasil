package com.davidmontandon.yggdrasil.init;


import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.world.feature.structure.YggdrasilTreeStructure;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Yggdrasil.MOD_ID)
public class StructureInit {
	
	
    public static final Structure<NoFeatureConfig> YGGDRASIL_TREE_STRUCTURE = new YggdrasilTreeStructure(NoFeatureConfig::deserialize);
    
    @SubscribeEvent
    public static void registerStructures(IForgeRegistry<Feature<?>> event) {
        RegUtil.generic(event)
                .add("yggdrasil_tree_structure", YGGDRASIL_TREE_STRUCTURE) ;
    }
	
}
