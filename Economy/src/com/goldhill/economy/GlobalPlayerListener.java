package com.goldhill.economy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


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
}
