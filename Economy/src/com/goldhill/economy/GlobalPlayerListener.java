package com.goldhill.economy;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.goldhill.economy.bank.BankSigns;


public class GlobalPlayerListener implements Listener {
	
	private Economy plugin;
	
	
	public GlobalPlayerListener(Economy plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerJoinEvent event) {
		if (!plugin.api.hasAccount(event.getPlayer().getName())){
			plugin.manager.initPlayer(event.getPlayer().getName());
		}
	}
	
	@EventHandler
	public void onSignInteract(PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		Action act = event.getAction();
		
		if (act == Action.RIGHT_CLICK_BLOCK) {
			if (block.getState().getType() == Material.SIGN) {
				Sign sign = (Sign) block;
				if (sign.getLine(0).equalsIgnoreCase("§f[Bank]")){
					new BankSigns(event);
				}
				
				if (sign.getLine(0).equalsIgnoreCase("§f[Eco]")) {
					
				}
			}
		}
	}
	
	@EventHandler
	public void onSignCreate(SignChangeEvent event) {
		Player player = event.getPlayer();
		Sign sign = (Sign) event.getBlock();
		//TODO actions
	}
	
}
