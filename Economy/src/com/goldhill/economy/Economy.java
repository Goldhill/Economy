package com.goldhill.economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.goldhill.economy.bank.Bank;
import com.goldhill.economy.currency.Currency;
import com.goldhill.economy.datahandler.Configuration;
import com.goldhill.economy.datahandler.PlayerManager;

public class Economy extends JavaPlugin {

	public Configuration config;
	public PlayerManager manager;
	public Currency currency;
	public Bank bank;
	
	public GlobalPlayerListener mainListener;
	
	public MoneyAPI api;//needs to be loaded last
	
	public void onEnable() {
		loadComponents();
		loadCommands();
		loadConfigurations();
		loadHooks();
		
		api = new MoneyAPI();
	}


	public void onDisable() {
		//nothing to log here
	}
	
	private void loadComponents() {
		currency = new Currency(this);
		bank = new Bank(this);
	}
	
	private void loadCommands() {
		CommandRegister register = new CommandRegister(this);
		register.registerAllCommands();
	}
	
	public void loadConfigurations() {
		config = new Configuration(this);
		manager = new PlayerManager(this);
	}
	
	public void loadHooks() {
		mainListener = new GlobalPlayerListener(this);
		Bukkit.getPluginManager().registerEvents(mainListener, this);
	}

}
