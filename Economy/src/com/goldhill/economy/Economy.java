package com.goldhill.economy;

import org.bukkit.plugin.java.JavaPlugin;

import com.goldhill.economy.bank.Bank;
import com.goldhill.economy.currency.Currency;

public class Economy extends JavaPlugin {//bukkit shit to make it a legit plugin (define main class)

	public Currency currency;
	public Bank bank;
	
	public void onEnable() {
		loadComponents();
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

}
