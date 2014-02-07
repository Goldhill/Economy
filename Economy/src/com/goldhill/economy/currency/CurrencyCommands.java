package com.goldhill.economy.currency;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.goldhill.economy.Utils;

public class CurrencyCommands implements CommandExecutor {

	private Currency parent;

	public CurrencyCommands(Currency parent) {
		this.parent = parent;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] split) {

		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}

		if (label.equalsIgnoreCase("money") && sender.hasPermission("economy.currency.balance")) {
			if (player == null) {
				// console
			} else {
				
				if (split.length == 0) {
					player.sendMessage(Double.toString(parent.plugin.api.getBalance(player.getName())));
				}
				
				if (split[0].equalsIgnoreCase("pay")) {

					if (!parent.plugin.api.hasAccount(player.getName())) {
						player.sendMessage("You do not have an account!");
						return true;
					}
					
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a number as a parameter");
						return true;
					}
					
					if (!parent.plugin.api.hasAccount(split[1])) {
						player.sendMessage("§cThis player does not have an account!");
						return true;
					}
					
					if (parent.plugin.api.getBalance(player.getName()) > Double.parseDouble(split[2])) {
							parent.plugin.api.removeBalance(player.getName(),Double.parseDouble(split[2]));
							parent.plugin.api.addBalance(split[1], Double.parseDouble(split[2]));
							player.sendMessage("You have sent " + split[2]+ parent.plugin.api.getMoneyName() + " to " + split[1]);
					}
					
				}
				if (split[0].equalsIgnoreCase("set") && player.hasPermission("economy.currency.set")) {
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a valid number.");
						return true;
					}
					
					if (!parent.plugin.api.hasAccount(split[1])) {
						player.sendMessage("That player does not have a bank account");
						return true;
					}
						parent.plugin.api.setBalance(split[1], Double.parseDouble(split[2]));
				}
				
				if (split[0].equalsIgnoreCase("get") && player.hasPermission("economy.currency.get")) {
					if (!parent.plugin.api.hasAccount(split[1])){
						player.sendMessage("That player does not have an account");
					}
						player.sendMessage(player.getName() + " has " + parent.plugin.api.getBalance(split[1]));
				}
				
				if (split[0].equalsIgnoreCase("remove") && player.hasPermission("economy.currency.remove")) {
					
					if (!parent.plugin.api.hasAccount(split[1])){
						player.sendMessage("That player does not have an account");
						return true;
						//split[1] is not an account abort the code
					}
					
					if (!Utils.isNumber(split[2])){
						player.sendMessage("Please use a real number");
						return true;
						//split[2] is not a number abort the code
					}
					
					if (parent.plugin.api.getBalance(split[1]) < Double.parseDouble(split[2])) {
						player.sendMessage("You are trying to take away more money then that player has");
						return true;
						//player does not have the money to be taken away abort the code
					}
					
					parent.plugin.api.removeBalance(split[1], Double.parseDouble(split[2]));
					player.sendMessage("You have taken " + Double.parseDouble(split[2]) + " from " + split[1]);
					//everything went smooth here, only need a confirmation message
				}
				
				if (split[0].equalsIgnoreCase("add") && player.hasPermission("economy.currency.add")) {
					
					if (!parent.plugin.api.hasAccount(split[1])) {
						player.sendMessage("That player does not have an account");
						return true;
					}
					
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("Please use a vaild number");
						return true;
					}
					parent.plugin.api.addBalance(split[2], Double.parseDouble(split[2]));
					player.sendMessage("You have added " + Double.parseDouble(split[2]) + " to " + split[1] + "'s account");
					
				}
				
				if (split[0].equalsIgnoreCase("help")) {
					sender.sendMessage("A list of commands for /money");
					sender.sendMessage("/money : Returns your current balance");
					
				}
				
				if (split[0].equalsIgnoreCase("info")) {
					player.sendMessage("EconcomyCraft's currency system ");
					
				}
				
				if(split[0].equalsIgnoreCase("config") && player.hasPermission("econcomy.currency.config")) {
					if (split[1].equalsIgnoreCase("")) {
						
					}
				}
			}
			return true;
		}

		return false;
	}

}
