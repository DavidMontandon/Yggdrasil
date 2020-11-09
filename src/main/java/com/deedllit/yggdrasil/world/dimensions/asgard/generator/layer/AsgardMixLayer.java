package com.deedllit.yggdrasil.world.dimensions.asgard.generator.layer;

import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum AsgardMixLayer implements ICastleTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {

		

		if(context.random(3) == 0) {
	
			if(center == AsgardLayerUtil.PLAINS) {
				
				if(context.random(3) == 0 && 
						(AsgardLayerUtil.isForest(north) || AsgardLayerUtil.isForest(south) || AsgardLayerUtil.isForest(west) || AsgardLayerUtil.isForest(east) )) {
										
					return AsgardLayerUtil.FOREST_PLAINS ; 
				}
				
				if(context.random(3) == 0 && 
						(AsgardLayerUtil.isHotPlain(north) || AsgardLayerUtil.isHotPlain(south) || AsgardLayerUtil.isHotPlain(west) || AsgardLayerUtil.isHotPlain(east) )) {

					return AsgardLayerUtil.SUNFLOWER_PLAINS ; 
				}
				
				if(context.random(3) == 0 && 
						AsgardLayerUtil.isHotPlain(north) && AsgardLayerUtil.isHotPlain(south) && AsgardLayerUtil.isHotPlain(west) && AsgardLayerUtil.isHotPlain(east) ) {
			
						return AsgardLayerUtil.PINK_MANGENTA_PLAINS ; 
				}
				
				if(context.random(3) == 0 && 
						(AsgardLayerUtil.isHotPlain(north) || AsgardLayerUtil.isHotPlain(south) || AsgardLayerUtil.isHotPlain(west) || AsgardLayerUtil.isHotPlain(east) )) {
					
						return AsgardLayerUtil.LAKES ; 
				}

				if(context.random(3) == 0 && 
						(AsgardLayerUtil.isHotPlain(north) || AsgardLayerUtil.isHotPlain(south) || AsgardLayerUtil.isHotPlain(west) || AsgardLayerUtil.isHotPlain(east) )) {
					
						return AsgardLayerUtil.ISLAND ; 
				}
				
				
			}
			
			if(center == AsgardLayerUtil.SNOW_PLAINS) {
				
			}
			
			if(center == AsgardLayerUtil.OAK_FOREST) {

				
				if(context.random(3) == 0 && 
						(AsgardLayerUtil.isHotForest(north) || AsgardLayerUtil.isHotForest(south) || AsgardLayerUtil.isHotForest(west) || AsgardLayerUtil.isHotForest(east) )) {

					
					return AsgardLayerUtil.BIRCH_FOREST ; 
					
				}

				
			}
			
			
		}
		
		
		return center ; 
	}
}
