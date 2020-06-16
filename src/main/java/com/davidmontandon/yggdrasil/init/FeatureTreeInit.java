package com.davidmontandon.yggdrasil.init;

import com.davidmontandon.yggdrasil.world.feature.tree.YggdrasilBigTree;

import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;


public class FeatureTreeInit {

	
	public static final Feature<BaseTreeFeatureConfig> ORIGIN_TREE = new YggdrasilBigTree.Builder()
			.leaves(BlockInit.IRON_WOOD_LEAVES.get().getDefaultState())
			.minHeight(5)
			.maxHeight(8)
			.create();
	
	
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
