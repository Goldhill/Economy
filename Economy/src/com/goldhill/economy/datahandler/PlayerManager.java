package com.goldhill.economy.datahandler;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.goldhill.economy.Economy;

public class PlayerManager {
	
	public FileConfiguration data;
	private File configFile;
	private Economy plugin;

	public PlayerManager(Economy plugin) {
		this.plugin = plugin;
		configFile = new File(plugin.getDataFolder(), "playerData.yml");
		 
        if(!configFile.exists()) {
                plugin.saveResource("playerData", false);
        }
        this.data = YamlConfiguration.loadConfiguration(configFile);
		
	}
	
	public PlayerManager() {
		
	}
	
	public String getConfig(String player, String property ) {
		return data.getString(player+"."+property);
	}
	
	public void setConfig(String player, String property, String value) {
		data.set(player+"."+property, value);
		saveFile();
	}
	
	public void initPlayer(String player) {
		if (data.get(player) == null){
			data.set(player+".balance", plugin.config.getConfig("defaultCashBalance"));
			data.set(player+".bank", plugin.config.getConfig("defaultBankBalance"));
			saveFile();
		}
	}
	
	public void saveFile() {
		try {
			data.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reloadFile() {
		//TODO
	}

}
