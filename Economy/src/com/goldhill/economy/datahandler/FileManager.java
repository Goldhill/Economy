package com.goldhill.economy.datahandler;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
	
	private File file;
	private String folder = "plugins/config/Economy";
	private String extension = ".yml";
	public FileConfiguration data;
	
	public FileManager(String fileName) {
		this.file = new File(folder+fileName+extension);
		createConfigs();
	}
	
	private void createConfigs() {
		new File(folder).mkdirs();
        if(!file.exists()) {
        	try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        this.data = YamlConfiguration.loadConfiguration(file);
	}
	
	public void setData(String key, Object value) {
		data.set(key, value);
	}
	
	public Object getData(String key) {
		return data.get(key);
	}
	
	public void saveFile() {
		try {
			data.save(file);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void reloadFile() {
		
	}
	
}
