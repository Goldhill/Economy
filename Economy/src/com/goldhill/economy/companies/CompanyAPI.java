package com.goldhill.economy.companies;

public class CompanyAPI {
	
	public boolean isEmployed(String player) { 
		return false;
	}
	
	public void setEmployed(String player, String company) {
		
	}
	
	public String getCompany(String player) {
		return "";
	}
	
	public void createCompany(String name, String owner) {
		
	}
	
	public void removeCompany(String name) {
		
	}
	
	public String getFunction(String player) {
		return "";
	}
	
	public void addFunction(String company, String name, double payment, int priority) {
		
	}
	
	public void removeFunction(String company, String name) {
		
	}
	
	public double getSalary(String company, String function) {
		return 0;
	}
	
	public void setSalary(String company, String function) {
		
	}
	
	public double getCompanyBalance(String company) {
		return 0;
	}
	
	public void addCompanyBalance(String company, double toAdd) {
		
	}
	
	public void removeCompanyBalance(String company, double toRemove) {
		
	}
	
	public String[] getEmployers(String company) {
		return null;
	}
	
	public String[] getCompanies() {
		return null;
	}
	
	public int getCompanyRank(String company) {
		return 0;
	}
	
	public void setCompanyRank(String company, int rank) {
		
	}
	
	public String[] getCompanyFunctions(String company) {
		return null;
	}
	
	public int getCosts(String companyType) {
		return 0;
	}
	
	public String getCompanyType(String company) {
		return "";
	}
	
	public int getMaxEmployees(String type) {
		return 0;
	}
		
}
