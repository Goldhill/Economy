package com.goldhill.economy;

import org.bukkit.Bukkit;

public class Utils {
	
	public static boolean isPlayer(String param) {
		return (Bukkit.getServer().matchPlayer(param) != null);
	}
	
	public static boolean isNumber (String param) {
		try {
			Long.parseLong(param);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

}
