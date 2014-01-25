package com.goldhill.economy.bank;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.goldhill.economy.Utils;
import com.goldhill.economy.datahandler.PlayerManager;

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
		
		if (label.equalsIgnoreCase("bank") && split.length > 0) {
			
			if (split[0].equalsIgnoreCase("help")) {
				
			}
			
			if (split[0].equalsIgnoreCase("info")) {
				
			}
			
			if (split[0].equalsIgnoreCase("balance")) {
				
			}
			
			if (split[0].equalsIgnoreCase("withdraw")) {
				if (split.length != 2 || !Utils.isNumber(split[1])){
					sender.sendMessage("§c The correct usage is /bank withdraw <amount>");
					return true;
				}
				if (player == null) {
					sender.sendMessage("you can only use this command as a player!");
					return true;
				}
				Long amount = Long.parseLong(split[1]);
				Long bankMoney = bank.plugin.api.getBankBalance(player.getName());
				
				if (bankMoney > amount) {
					sender.sendMessage("nigga, ur trying to take more money than ur allowed to!");
					return true;
				}
				
				bank.plugin.api.removeBalance(player.getName(), amount);
				bank.plugin.api.addBalance(player.getName(), amount);
				player.sendMessage("Gratz ur money updated, you took");
			}
			
			if (split[0].equalsIgnoreCase("deposit")) {
				
			}
			
			if (split[0].equalsIgnoreCase("wiretransfer")) {
				
			}
			
			if (split[0].equalsIgnoreCase("get")){
				
			}
			
			if (split[0].equalsIgnoreCase("set")){
				
			}
			
			if (split[0].equalsIgnoreCase("add")){
				
			}
			
			if (split[0].equalsIgnoreCase("reove")){
				
			}
			
			if (split[0].equalsIgnoreCase("config")){
				
			}
			/*if (split.length == 1) {
				String par1 = split[0];
				if (par1.equalsIgnoreCase("add")){
					sender.sendMessage("§cPlease define how much you would like to add");
				}
				if (par1.equalsIgnoreCase("balance") && sender.hasPermission("economy.bank.admin.add")) {
					
				}
				if (par1.equalsIgnoreCase("info") && sender.hasPermission("economy.bank.admin.add")) {
					
				}
				if (par1.equalsIgnoreCase("help") && sender.hasPermission("economy.bank.admin.add")) {
					
				}
			}
			if (split.length == 2) {
				String par1 = split[0];
				String par2 = split[1];
				
				if (!Utils.isNumber(par2)){
					sender.sendMessage("The correct usage is /bank "+par1+" <amount>");
					return true;
				}
				
				if (par1.equalsIgnoreCase("get") && sender.hasPermission("economy.bank.admin.add")) {//dis one
					
				}
				
				if (par1.equalsIgnoreCase("set") && sender.hasPermission("economy.bank.admin.add")) {//n dis one
					
				}
				
				if (par1.equalsIgnoreCase("add") && sender.hasPermission("economy.bank.admin.add")) {// n dis one
					
				}
				
				if (par1.equalsIgnoreCase("deposit") && sender.hasPermission("economy.bank.admin.add")) {
					//player cmd (not console)
				}
				
				if (par1.equalsIgnoreCase("withdraw") && sender.hasPermission("economy.bank.admin.add")) {
					//player cmd
				}
				
			}
			if (split.length == 3) {
				String par1 = split[0];
				String par2 = split[1];
				String par3 = split[2];
				
			}*/
			return true;
		} 
		return false;
	}
	
	
	

}
