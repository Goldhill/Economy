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
	
	public void createAccount(String player, double cashBalance, double bankBalance) {
		manager.initPlayer(player, bankBalance, cashBalance);
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
		return (Double)manager.getData(player+".cash_balance");
	}
	
	public void setBalance(String player, double amount) {
		manager.setData(player+".cash_balance", amount);
	}
	
	public void addBalance(String player, double amount) {
		double balance = (Double)manager.getData(player+".cash_balance");
		double transact = balance+amount;
		manager.setData(player+".cash_balance", transact);
	}
	
	public void removeBalance(String player, double amount) {
		double balance = (Double)manager.getData(player+".cash_balance");
		double transact = balance-amount;
		manager.setData(player+".cash_balance", transact);
	}
	
	public double getinterestRate() {
		return -1;
		//TODO
	}
	
	public double getBankBalance(String player) {
		return (Double)manager.getData(player+".bank_balance");
	}
	
	public void setBankBalance(String player, double amount) {
		manager.setData(player+".bank_balance", amount);
	}
	
	public void addBankBalance(String player, double amount) {
		double balance = (Double)manager.getData(player+".bank_balance");
		double transact = balance+amount;
		manager.setData(player+".bank_balance", transact);
	}
	
	public void removeBankBalance(String player, double amount) {
		double balance = (Double)manager.getData(player+".bank_balance");
		double transact = balance-amount;
		manager.setData(player+".bank_balance", transact);
	}
}
