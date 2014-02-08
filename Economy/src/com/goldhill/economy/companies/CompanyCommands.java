package com.goldhill.economy.companies;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CompanyCommands implements CommandExecutor{
	
	private Companies companies;

	public CompanyCommands(Companies companies) {
		this.companies = companies;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] split) { 
		
		Player player = null;

		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (label.equalsIgnoreCase("company") || label.equalsIgnoreCase("co")) {
			
			if (split.length == 0) {
			//TODO company info
				return true;
			}
			
			
			return true;
		}
		return false;
	}

}
