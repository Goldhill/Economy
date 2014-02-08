package com.goldhill.economy.datahandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.goldhill.economy.Economy;

public class Configuration {

	File file;
	String path = "plugins/config/Economy/";
	public FileConfiguration data;
	
	public Configuration() {
		new File(path).mkdirs();
		file = new File(path+"config.yml");
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        InputStream defConfigStream = Economy.class.getResourceAsStream("defaultConfig.yml");
	        
	        if (defConfigStream != null) {
	            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	            data.setDefaults(defConfig);
	        }
		}
		this.data = YamlConfiguration.loadConfiguration(file);
	}
	
	public Object getData(String key) {
		return data.get(key);
	}
}