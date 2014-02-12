package com.goldhill.economy.stockmarket;

import java.util.HashMap;

import com.goldhill.economy.datahandler.FileManager;
import com.goldhill.economy.datahandler.PlayerManager;
import com.goldhill.economy.datahandler.StockManager;

public class StockAPI extends FileManager {
	
	public StockAPI(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}

	private PlayerManager manager = new PlayerManager();
	public StockManager smanager = new StockManager();
	public HashMap<String, String> stocks = new HashMap<String, String>();
	
	public String[] getStocks(String player) {
		return (String[]) manager.getData(player + ".stocks");
		
	}
	
	public String[] getStockers(String stock) {
		return (String[]) smanager.getData(stock + ".stockers");
	}
	
	public void setInterest(String stock, Double interest) {
		smanager.setData(stock + ".interest", interest);
	}
	
	public double getStockPrice(String stock) {
		return (Double) smanager.getData(stock + ".price");
		
	}
	
	public boolean stockExist(String stock) {
		return smanager.data.contains(stock);
		
	}
	
	public boolean playerHasMax(String player) { // checks if the player has the max amount of stocks
		if ((int) manager.getData(player + ".stocks") >= 5) {
			return true;
		}
		return false;
		
	}
	

}
