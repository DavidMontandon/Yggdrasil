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
    	
    	
    	if(YGGDRASIL_WORLD.get()) {
    		
    		if(YGGDRASIL_MUSPELHEIM_DIMENSION.get()) {
    	        dh.addDimension("muspelheim", new MuspelheimModDimension()) ;    			
    		}

    		if(YGGDRASIL_NIFELHEIM_DIMENSION.get()) {
    	        dh.addDimension("nivlheim", new NifelheimModDimension()) ;    			
    		}

    		if(YGGDRASIL_SVARTALFHEIM_DIMENSION.get()) {
    	        dh.addDimension("nifelheim", new SvartalvheimModDimension()) ;    			
    		}

    	}


    }
    

	
}
