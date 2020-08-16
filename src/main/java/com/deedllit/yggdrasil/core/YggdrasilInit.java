package com.deedllit.yggdrasil.core;

import java.util.Calendar;

import com.deedllit.yggdrasil.Yggdrasil;

public class YggdrasilInit {

	public void init() {
		Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 4 && calendar.get(5) == 1) { Yggdrasil.isAprilFools = true; }  
	}
	
}
