package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;


import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum AsgardPlainsLayer implements IAreaTransformer0 {
	   INSTANCE;

	   public int apply(INoiseRandom context, int x, int z) {
	      if (x == 0 && z == 0) {
	         return AsgardLayerUtil.PLAINS ;
	      } else {
	    	  	    	   
	    	  int i = context.random(10) ;
    	  	    	  
	    	  if(i < 4) {
	    		  return AsgardLayerUtil.SNOW_PLAINS ; 	    		  
	    	  }
	    	      	  
	    	  return  AsgardLayerUtil.PLAINS;
	      }
	   }
}