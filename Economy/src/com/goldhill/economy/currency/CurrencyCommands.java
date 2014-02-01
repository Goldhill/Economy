package com.goldhill.economy.currency;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


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
				//show player balance
			}
			return true;
		}
		
		return false;
	}

}
