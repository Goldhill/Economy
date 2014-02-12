package com.goldhill.economy.stockmarket;

import com.goldhill.economy.GlobalAPI;
import com.goldhill.economy.datahandler.StockManager;

public class StockAPI extends GlobalAPI{
	
	StockManager stockManager = new StockManager();
	
	public String[] getStocks(String player) {
		return (String[]) manager.getData(player + ".stocks");
		
	}
	
	public String[] getStockers(String stock) {
		return (String[]) stockManager.getData(stock + ".stockers");
	}
	
	public void setInterest(String stock, Double interest) {
		stockManager.setData(stock + ".interest", interest);
	}
	
	public double getStockPrice(String stock) {
		return (Double) stockManager.getData(stock + ".price");
		
	}
	
	public boolean stockExist(String stock) {
		return stockManager.data.contains(stock);
		
	}
	
	public boolean playerHasMax(String player) { // checks if the player has the max amount of stocks
		if ((int) manager.getData(player + ".stocks") >= 5) {
			return true;
		}
		return false;
		
	}
	

}
