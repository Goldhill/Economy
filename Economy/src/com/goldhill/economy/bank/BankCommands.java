package com.goldhill.economy.bank;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankCommands implements CommandExecutor  {
	
	private Bank bank;
	
	public BankCommands(Bank bank) {
		this.bank = bank;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] split) {
		Player player = null;
		
		if (sender instanceof Player) {
			player = (Player)sender;
		}
		
		if (label.equalsIgnoreCase("bank")) {
			if (split.length == 0) {
				sender.sendMessage("test");
			}
			if (split.length == 1) {
				//command is /bank get|set|add|remove|whatever
			}
			if (split.length == 2) {
				//command is /bank getsetaddremove somethingelse
			}
			return true;
		} 
		return false;
	}
	
	
	

}
