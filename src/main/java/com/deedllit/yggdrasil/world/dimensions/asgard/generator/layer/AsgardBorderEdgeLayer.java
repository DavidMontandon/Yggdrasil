package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum AsgardBorderEdgeLayer implements ICastleTransformer {
    INSTANCE;

	@Override
	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		
		int c = 0 ;
		
		if( AsgardLayerUtil.isForest(center) || AsgardLayerUtil.isPlain(center)) {
			if(AsgardLayerUtil.contains(AsgardLayerUtil.MOUNTAIN, north, east, south, west) || 
					AsgardLayerUtil.contains(AsgardLayerUtil.SNOWY_MOUNTAIN, north, east, south, west)) {
				
				c = AsgardLayerUtil.countSnowy(center, north, east, south, west) ;
				
				if(c >= 3) {
					return AsgardLayerUtil.SNOWY_HILLS ; 				
				}
				else {
					return AsgardLayerUtil.HILLS ; 				
				}
				
			}
		}
		
		if(AsgardLayerUtil.isMoutain(center)) {
			if(AsgardLayerUtil.surroundBy(AsgardLayerUtil.MOUNTAIN, north, east, south, west)) {
				 return AsgardLayerUtil.EXTREME_MOUNTAIN ; 				
			}			
			if(AsgardLayerUtil.surroundBy(AsgardLayerUtil.SNOWY_MOUNTAIN, north, east, south, west)) {
				 return AsgardLayerUtil.SNOWY_EXTREME_MOUNTAIN ; 				
			}			
		}
		
		
		
		return center ;
	}
	
	

}
