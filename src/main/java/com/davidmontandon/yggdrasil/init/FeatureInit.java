package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.Yggdrasil;
import com.davidmontandon.yggdrasil.objects.bushes.muspelheim.MuspelheimAshCarambola;
import com.davidmontandon.yggdrasil.world.feature.TestDig;
import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class FeatureInit {

	
	/*
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES,  Yggdrasil.MOD_ID) ; 	
	public static final RegistryObject<TestDig> TEST_DIG = FEATURES.register("test_dig",
			() -> new TestDig(NoFeatureConfig::deserialize));
	*/

	/*
    public static Feature<NoFeatureConfig> TEST_DIG = new TestDig(NoFeatureConfig::deserialize);

    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    	IForgeRegistry<Feature<?>> registry = event.getRegistry();
    	RegUtil.register(registry, TEST_DIG, "test_dig");
    }
    */
}
