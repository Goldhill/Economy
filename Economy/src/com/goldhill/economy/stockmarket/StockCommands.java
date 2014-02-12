package com.goldhill.economy.stockmarket;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.goldhill.economy.Economy;
import com.goldhill.economy.Utils;

public class StockCommands {
	
	private StockMarket stock;
	
	public StockCommands(StockMarket stock) {
		this.stock = stock;
		
	}
	
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] split) {
		
		Player player = null;
		
		if (sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (label.equalsIgnoreCase("stock") || label.equalsIgnoreCase("stocks")) {
			
			if (split.length == 0) {//This will basically be info about Stocks.
				
			}
			
			if (split[0].equalsIgnoreCase("list")) {
				
			}
			
			if (split[0].equalsIgnoreCase("help")) {
				
			}
			
			if (split[0].equalsIgnoreCase("buy")) {
				
				if (!Utils.isNumber(split[2]) || !Utils.isNumber(split[3])) {
					player.sendMessage("Please use a correct number");
					
					return true;
				}
				
				if (!stock.exist(split[1])) { //I need to add this stock.exist() method to check if a stock exists
					player.sendMessage("That stock does not exist");
					return true;
				}
				
				if ()
				
			}
		}
		
		
		
		return false;
	}

}
