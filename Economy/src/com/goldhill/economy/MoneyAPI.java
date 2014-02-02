package com.goldhill.economy;

import com.goldhill.economy.datahandler.PlayerManager;

public class MoneyAPI {
	
	private PlayerManager manager = new PlayerManager();
	
	public String getMoneyName() {
		return "Cash";
		//TODO
	}
	
	public String getCentName() {
		return "Cents";
		//TODO
	}
	
	public boolean hasAccount(String player) {
		return manager.data.contains(player);
	}
	
	public boolean createAccount(String player, double cashBalance, double bankBalance) {
		return manager.initPlayer(player, bankBalance, cashBalance);
	}
	
	public double getDefaultBalance() {
		return 0;
		//TODO
	}
	
	public double getDefaultBankBalance() {
		return 0;
		//TODO
	}
	
	public double getSalary(String group) {
		return 0;
		//TODO
	}
	
	public double getBalance(String player) {
		return Double.parseDouble(manager.getConfig(player, "cash_balance"));
	}
	
	public void setBalance(String player, double amount) {
		manager.setConfig(player, "cash_balance", Double.toString(amount));
	}
	
	public void addBalance(String player, double amount) {
		double balance = Double.parseDouble(manager.getConfig(player, "cash_balance"));
		double transact = balance+amount;
		manager.setConfig(player, "cash_balance", Double.toString(transact));
	}
	
	public void removeBalance(String player, double amount) {
		double balance = Double.parseDouble(manager.getConfig(player, "cash_balance"));
		double transact = balance-amount;
		manager.setConfig(player, "cash_balance", Double.toString(transact));
	}
	
	public double getinterestRate() {
		return -1;
		//TODO
	}
	
	public double getBankBalance(String player) {
		return Double.parseDouble(manager.getConfig(player, "bank_balance"));
	}
	
	public void setBankBalance(String player, double amount) {
		manager.setConfig(player, "bank_balance", Double.toString(amount));
	}
	
	public void addBankBalance(String player, double amount) {
		double balance = Double.parseDouble(manager.getConfig(player, "bank_balance"));
		double transact = balance+amount;
		manager.setConfig(player, "bank_balance", Double.toString(transact));
	}
	
	public void removeBankBalance(String player, double amount) {
		double balance = Double.parseDouble(manager.getConfig(player, "bank_balance"));
		double transact = balance-amount;
		manager.setConfig(player, "bank_balance", Double.toString(transact));
	}
}
