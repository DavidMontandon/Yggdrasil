package com.deedllit.mythologycraft.dimension;

import java.util.HashMap;
import java.util.Map;

import com.deedllit.yggdrasil.Yggdrasil;
import com.deedllit.yggdrasil.util.holder.DimensionsHolder;
import com.deedllit.yggdrasil.world.dimensions.muspelheim.dimension.MuspelheimModDimension;
import com.deedllit.yggdrasil.world.dimensions.nifelheim.dimension.NifelheimModDimension;
import com.deedllit.yggdrasil.world.dimensions.svartalvheim.dimension.SvartalvheimModDimension;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;

import static com.deedllit.mythologycraft.config.MCConfig.* ; 

public class MCDimensionInit {

    public static DimensionsHolder dh = new DimensionsHolder(Yggdrasil.MOD_ID) ; 
	    
    public void onRegister() {
    	
    	
    	if(config_yggdrasil_world) {
    		
    		if(config_yggdrasil_muspelheim_dimension) {
    	        dh.addDimension("muspelheim", new MuspelheimModDimension()) ;    			
    		}

    		if(config_yggdrasil_nifelheim_dimension) {
    	        dh.addDimension("nivlheim", new NifelheimModDimension()) ;    			
    		}

    		if(config_yggdrasil_svartalfheim_dimension) {
    	        dh.addDimension("nifelheim", new SvartalvheimModDimension()) ;    			
    		}

    	}


    }
    

	
}
