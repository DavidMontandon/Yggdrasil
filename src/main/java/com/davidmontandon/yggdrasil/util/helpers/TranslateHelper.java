package com.davidmontandon.yggdrasil.util.helpers;

import net.minecraft.client.resources.I18n;

public class TranslateHelper {

	public static String getTranslate(String tag) {		
				
		try {
			return I18n.format(tag) ; 
		}
		catch (Exception e) {
			return "Can't load translation of " + tag ; 
		}
	}
	
	
}
