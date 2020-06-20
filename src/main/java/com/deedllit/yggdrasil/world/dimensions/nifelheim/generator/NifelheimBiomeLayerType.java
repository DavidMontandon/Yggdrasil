package com.deedllit.yggdrasil.world.dimensions.nifelheim.generator;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;

import java.util.function.IntFunction;
import java.util.function.LongFunction;

import com.deedllit.yggdrasil.common.biome.BiomeLayers;
import com.deedllit.yggdrasil.common.biome.BiomeProcedure;
import com.deedllit.yggdrasil.common.biome.IYggdrasilBiomeLayerType;
import com.deedllit.yggdrasil.common.biome.cavern.CavernousBiome;

/*
 * Strongly inspired by The-MidNight Mod (https://github.com/Cryptic-Mushroom/The-Midnight)  
 */

public final class  NifelheimBiomeLayerType<T> implements IYggdrasilBiomeLayerType<T> { 
    public static final NifelheimBiomeLayerType<Biome> SURFACE = null ; 
    public static final NifelheimBiomeLayerType<CavernousBiome> UNDERGROUND = null ; 

    private static final int MAX_CACHE_SIZE = 25;

    private final Class<T> type;
    private final ProcedureFactory procedureFactory;
    private final IntFunction<T> function;
    private final T defaultValue;

    private NifelheimBiomeLayerType(Class<T> type, ProcedureFactory procedureFactory, IntFunction<T> function, T defaultValue) {
        this.type = type;
        this.procedureFactory = procedureFactory;
        this.function = function;
        this.defaultValue = defaultValue;
    }

    public static <T> NifelheimBiomeLayerType<T> create(Class<T> type, ProcedureFactory procedureFactory, IntFunction<T> function, T defaultValue) {
        return new NifelheimBiomeLayerType<>(type, procedureFactory, function, defaultValue);
    }

    public BiomeLayers<T> make(long worldSeed) {
    	
    	//TODO
    	
    	return null ; 

    }

    public interface ProcedureFactory {
        <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> create(LongFunction<C> contextFactory);
    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> buildSurface(LongFunction<C> contextFactory) {
    	
    	//TODO 
    	return null ; 
    	
    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> BiomeProcedure<A> buildUnderground(LongFunction<C> contextFactory) {
    	
    	//TODO
    	return null ; 
    	

    }

    private static <A extends IArea, C extends IExtendedNoiseRandom<A>> IAreaFactory<A> buildEdgeHighlightLayer(LongFunction<C> contextFactory, long seed) {
        
    	//TODO
    	return null ; 

    }
}

