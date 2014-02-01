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
			player = (Player)sender;
		}
		
		
		if (label.equalsIgnoreCase("money")) {
			if (player == null) {
				//console
			} else {
				if (!player.hasPermission("economy.currency.balance")) {
					player.sendMessage("§cYou dont have the right permission to use this command");
					return true;
				}
				player.sendMessage(Double.toString(parent.plugin.api.getBalance(player.getName())));
				
				if (split[0].equalsIgnoreCase("pay")){

					if (!parent.plugin.api.hasAccount(player.getName())) {
						player.sendMessage("You do not have an account!");
						return true;
					}
					if (!Utils.isNumber(split[2])) {
						player.sendMessage("You did not use a number as a parameter");
						return true; 
					}
					if (Utils.isNumber(split[2])) {
						if (parent.plugin.api.getBalance(player.getName()) > Double.parseDouble(split[2])) {
							
							parent.plugin.api.removeBalance(player.getName(), Double.parseDouble(split[2]));
							parent.plugin.api.addBalance(split[1], Double.parseDouble(split[2]));
							player.sendMessage("You have sent " + split[2] + parent.plugin.api.getMoneyName() + " to " + split[1]);
						}
					}
					
				}
			}
			return true;
		}
		
		return false;
	}

}
