package com.deedllit.mythologycraft.world.gen;

import java.util.function.LongFunction;

import com.deedllit.mythologycraft.world.layer.ClimateLayer;
import com.deedllit.mythologycraft.world.layer.MythologycraftBiomeLayer;
import com.deedllit.mythologycraft.world.layer.RainfallNoiseLayer;
import com.deedllit.mythologycraft.world.layer.TemperatureNoiseLayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddBambooForestLayer;
import net.minecraft.world.gen.layer.AddIslandLayer;
import net.minecraft.world.gen.layer.AddMushroomIslandLayer;
import net.minecraft.world.gen.layer.DeepOceanLayer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.RareBiomeLayer;
import net.minecraft.world.gen.layer.RemoveTooMuchOceanLayer;
import net.minecraft.world.gen.layer.RiverLayer;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.StartRiverLayer;
import net.minecraft.world.gen.layer.ZoomLayer;

public class DefaultBiomesFactory {

	public static Layer[] getDefaultBiomesFactory(long seed, Biome[] dimensionBiomes, int biomeSize,  int riverSize) {
		
		BiomeLayerUtils biomeLayerUtil = new BiomeLayerUtils(dimensionBiomes); 
		
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);		
		
        biomeSize = LayerUtil.getModdedBiomeSize(WorldType.DEFAULT, biomeSize);

        
        IAreaFactory<LazyArea> landSeaFactory = IslandLayer.INSTANCE.apply(contextFactory.apply(1L));

		//INIT
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);
        landSeaFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        //CLIMATE
        //IAreaFactory<LazyArea> temperatureFactory = TemperatureNoiseLayer.MEDIUM_ZONES.run(contextFactory.apply(4L));
        //IAreaFactory<LazyArea> rainfallFactory = RainfallNoiseLayer.MEDIUM_ZONES.run(contextFactory.apply(4L));
        //IAreaFactory<LazyArea> climateFactory = ClimateLayer.INSTANCE.apply(contextFactory.apply(103L), temperatureFactory, rainfallFactory);
        
        //ISLAND AND OCEAN
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        
        //ALLOCATE BIOME
        //IAreaFactory<LazyAreaT> biomeFactory = MythologycraftBiomeLayer.INSTANCE.apply(contextFactory.apply(200L), landSeaAreaFactory, climateAreaFactory);
        //biomeFactory = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), biomeFactory);
        //biomeFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomeFactory, 2, contextFactory);        
		IAreaFactory<LazyArea> biomesFactory = biomeLayerUtil.apply(contextFactory.apply(200), landSeaFactory);
		//biomesFactory = biomeLayerUtil.apply(contextFactory.apply(200), climateFactory);

		
		//SET RIVER AND SUB BIOME 
        IAreaFactory<LazyArea> riverAndSubBiomesInitFactory = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), landSeaFactory);
        riverAndSubBiomesInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 2, contextFactory);
        IAreaFactory<LazyArea> riversInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, riverSize, contextFactory);
        riversInitFactory = RiverLayer.INSTANCE.apply(contextFactory.apply(1L), riversInitFactory);
        riversInitFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), riversInitFactory);

        
        //MIX BIOMES
        biomesFactory = RareBiomeLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);

		
        for (int i = 0; i < biomeSize; ++i)
        {
            biomesFactory = ZoomLayer.NORMAL.apply(contextFactory.apply((long)(1000 + i)), biomesFactory);
            if (i == 0) 
            	biomesFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), biomesFactory);
        }
		
        biomesFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), biomesFactory);

        biomesFactory = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);
        biomesFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomesFactory, 2, contextFactory);
		        
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomesFactory);
		return new Layer[]{new Layer(biomesFactory), new Layer(voronoizoom)};

		
	}
	
	
}
