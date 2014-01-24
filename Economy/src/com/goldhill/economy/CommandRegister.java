package com.goldhill.economy;

import com.goldhill.economy.bank.BankCommands;
import com.goldhill.economy.currency.CurrencyCommands;

public class CommandRegister {
	
	Economy plugin;
	
	public CommandRegister(Economy plugin) {
		this.plugin = plugin;
	}
	
	public void registerAllCommands() {
		this.loadCurrencyCommands();
		this.loadBankCommands();
	}
	
	private void loadBankCommands() {
		String[] commands = {"bank"};//define commands here
		BankCommands handler = new BankCommands(plugin.bank);
		for (String command : commands) {
			plugin.getCommand(command).setExecutor(handler);
		}
	}

	private void loadCurrencyCommands() {
		String[] commands = {"money"};//define commands here
		CurrencyCommands handler = new CurrencyCommands(plugin.currency);
		for (String command : commands) {
			plugin.getCommand(command).setExecutor(handler);
		}
	}

}
