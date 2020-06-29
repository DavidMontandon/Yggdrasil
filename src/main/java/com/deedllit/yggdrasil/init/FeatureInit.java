package com.deedllit.yggdrasil.init;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.world.feature.structure.YggdrasilTreeStructure;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Yggdrasil.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> YGGDRASIL_TREE_STRUCTURE = register("yggdrasil_tree_structure", new YggdrasilTreeStructure(NoFeatureConfig::deserialize));

    private static <T extends Feature<?>> RegistryObject<T> register(String name, T feature) {
        return FEATURES.register(name, () -> feature);
    }

}
