package com.deedllit.yggdrasil.world.dimensions.muspelheim.generator.layer;


import com.deedllit.yggdrasil.Yggdrasil;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MuspelheimRiverLayer implements ICastleTransformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		   
		   if(MuspelheimLayerUtil.isOcean(center) || MuspelheimLayerUtil.isOcean(north) || MuspelheimLayerUtil.isOcean(west) || MuspelheimLayerUtil.isOcean(south) || MuspelheimLayerUtil.isOcean(east)) {
			   Yggdrasil.LOGGER.info(" OCEAN ");
			   return center ; 
		   }
		   	   
		   if(center != north || center != west || center != south || center != east)  {
			   Yggdrasil.LOGGER.info(" NOT EGAL ");
			   return MuspelheimLayerUtil.RIVER ;  
		   }
			   
		   Yggdrasil.LOGGER.info(" OTHER ");
		   return center ; 
		   
		   
		   /*
	      int i = riverFilter(center);
	      return i == riverFilter(east) && i == riverFilter(north) && i == riverFilter(west) && i == riverFilter(south) ? -1 : MuspelheimLayerUtil.RIVER;
	      */
		   
	   }

	   private static int riverFilter(int p_151630_0_) {
		   /*
 	   Yggdrasil.LOGGER.info(" riverFilter : " + Integer.toString(p_151630_0_)  );
	   Yggdrasil.LOGGER.info(" riverFilter value : " + Integer.toString( 2 + (p_151630_0_ & 1 )))  ;
		   */
		   
		  
		   
		   return MuspelheimLayerUtil.RIVER ; 
		   
	      //return p_151630_0_ >= 2 ? 2 + (p_151630_0_ & 1) : p_151630_0_;
	   }
	}