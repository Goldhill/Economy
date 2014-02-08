package com.goldhill.economy.datahandler;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.goldhill.economy.Economy;

public class PlayerManager extends FileManager {

	
	public PlayerManager() {
		super("PlayerManager");
	}
	
	public void initPlayer(String player, Object BankBalance, Object CashBalance) {
		data.set(player+".cash_balance", CashBalance);
		data.set(player+".bank_balance", BankBalance);
	}

}
