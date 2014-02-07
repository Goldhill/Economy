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
		createConfigs();
	}
	
	public PlayerManager() {
		createConfigs();
	}
	
	private void createConfigs(){
		configFile = new File("plugins/Economy/playerData.yml");
		new File("plugins/config/Economy").mkdirs();
        if(!configFile.exists()) {
        	try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        this.data = YamlConfiguration.loadConfiguration(configFile);
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
			data.set(player+".cash_balance", plugin.config.getConfig("defaultCashBalance"));
			data.set(player+".bank_balance", plugin.config.getConfig("defaultBankBalance"));
			saveFile();
		}
	}
	
	public boolean initPlayer(String player, double bank, double cash) {
		if (data.get(player) == null){
			
			data.set(player+".cash_balance", cash);
			data.set(player+".bank_balance", bank);
			saveFile();
			return true;
		}
		return false;
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
