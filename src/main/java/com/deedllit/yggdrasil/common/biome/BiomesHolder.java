package com.deedllit.yggdrasil.common.biome;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;

public class BiomesHolder {

	private HashMap<String, List<RegistryObject<Biome>>> biomesMap = new HashMap<String, List<RegistryObject<Biome>>>();
	
	public void add(String dimension,  RegistryObject<Biome> biome, int weight) {

		if(! biomesMap.containsKey(dimension)) {
			biomesMap.put(dimension, new ArrayList<RegistryObject<Biome>>()) ; 
		}
		
		for(int i = 0 ; i < weight ; i++)
			biomesMap.get(dimension).add(biome) ; 
		
	}
	
	public HashSet getBiomes(String dimension) {
		if(biomesMap.containsKey(dimension)) {
			return new HashSet(biomesMap.get(dimension)) ;  
		}

		return new HashSet() ;  
		
	}
	
	
}
