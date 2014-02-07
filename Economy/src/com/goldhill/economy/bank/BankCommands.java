package com.goldhill.economy.bank;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.goldhill.economy.Utils;

public class BankCommands implements CommandExecutor {

	private Bank bank;

	public BankCommands(Bank bank) {
		this.bank = bank;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] split) { 
		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (label.equalsIgnoreCase("bank")) {
			
			if (player == null) {
				sender.sendMessage("You can only use this command as a player!");
				return true;
			}
			
			
			if (split.length == 0) {
				sender.sendMessage("You have " + bank.plugin.api.getBankBalance(player.getName()));
			}
			
			if (split.length >= 1) {

				if (split[0].equalsIgnoreCase("help")) {
					sender.sendMessage("Commands related to banks and shit");
					sender.sendMessage("do /bank to see your bank balance");
	
				}
	
				if (split[0].equalsIgnoreCase("info")) {
					
				}
				
				if (split[0].equalsIgnoreCase("withdraw")) {
					if (split.length != 2 || !Utils.isNumber(split[1])) {
						sender.sendMessage("�c The correct usage is /bank withdraw <amount>");
						return true;
					}
					double amount = Double.parseDouble(split[1]);
					double bankMoney = bank.plugin.api.getBankBalance(player.getName());
		
					if (bankMoney < amount) {
						sender.sendMessage("nigga, ur trying to take more money than ur allowed to!");
						return true;
					}
		
					bank.plugin.api.removeBankBalance(player.getName(), amount);
					bank.plugin.api.addBalance(player.getName(), amount);
					player.sendMessage("You withdrew " + amount + " from the bank.");
				}
		
				if (split[0].equalsIgnoreCase("deposit")) {
					if (split.length != 2 || !Utils.isNumber(split[1])) {
						sender.sendMessage("�c The correct usage is /bank deposit <amount>");
						return true;
					}
					double amount = Double.parseDouble(split[1]);
					double balance = bank.plugin.api.getBalance(player.getName());
					
					if (balance < amount) {
						sender.sendMessage("nigga, ur trying to take more money than ur allowed to!");
						return true;
					}
		
					bank.plugin.api.addBankBalance(player.getName(), amount);
					bank.plugin.api.removeBalance(player.getName(), amount);
					player.sendMessage("You deposited " + amount + " on the bank.");
		
				}
		
				if (split[0].equalsIgnoreCase("wiretransfer")) {
					String var1 = split[1];
					Double var2 = Double.parseDouble(split[2]);
		
					if (!bank.plugin.api.hasAccount(var1)) {
						player.sendMessage("This person does not have a bank account!");
						return true;
					}
					
					if (bank.plugin.api.getBankBalance(player.getName()) > var2) {
						player.sendMessage("You are trying to send more money then you have.");
						return true;
					}
					
					bank.plugin.api.removeBankBalance(player.getName(), var2);
					bank.plugin.api.addBankBalance(var1, var2);	
				}
		
				if (split[0].equalsIgnoreCase("get") && player.hasPermission("economy.bank.get")) {
					String var1 = split[1];
					if (bank.plugin.api.hasAccount(var1)) {
						bank.plugin.api.getBankBalance(var1);
					}
				}
		
				if (split[0].equalsIgnoreCase("set") && player.hasPermission("economy.bank.set")) {
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a valid number.");
						return true;
					}
					if (!bank.plugin.api.hasAccount(split[1])) {
						player.sendMessage("That player does not have a bank account");
						return true;
					}
					bank.plugin.api.setBankBalance(split[1], Double.parseDouble(split[2]));
				}
		
				if (split[0].equalsIgnoreCase("add") && player.hasPermission("economy.bank.add")) {
		
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a valid number.");
						return true;
					}
					
					if (!bank.plugin.api.hasAccount(split[1])) {
						player.sendMessage("That player does not have a bank account");
						return true;
					}
		
					bank.plugin.api.addBankBalance(split[1], Double.parseDouble(split[2]));
					sender.sendMessage("confirmed action");
				}
		
				if (split[0].equalsIgnoreCase("remove") && player.hasPermission("economy.bank.remove")) {
					
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a valid number.");
						return true;
					}
		
					if (!bank.plugin.api.hasAccount(split[1])) {
						player.sendMessage("That player does not have a bank account");
						return true;
					}
					
					bank.plugin.api.removeBankBalance(split[1], Double.parseDouble(split[2]));
				}
		
				if (split[0].equalsIgnoreCase("config")) {// idk how to do this
					String var1 = split[1];
					
					if (player.hasPermission("admin")){
						
					}
		
				}
			}
			return true;
		}
		return false;
	}
}
