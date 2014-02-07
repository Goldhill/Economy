package com.goldhill.economy.datahandler;

import java.io.File;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.goldhill.economy.Economy;

public class Configuration {
	
	private Economy plugin;
	private File configFile;
	private FileConfiguration config;
	
	public Configuration(Economy plugin) {
		this.plugin = plugin;

	    if (configFile == null) {
	        configFile = new File(plugin.getDataFolder(), "config.yml");
	        }
	        config = YamlConfiguration.loadConfiguration(configFile);
	     
	        // Look for defaults in the jar
	        InputStream defConfigStream = plugin.getResource("defaultConfig.yml");
	        if (defConfigStream != null) {
	            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	            config.setDefaults(defConfig);
	        }
	}
	
	
	
	public String getConfig(String property) {
		return "1000";
	}

}
//TODO