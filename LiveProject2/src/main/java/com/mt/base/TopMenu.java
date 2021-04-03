package com.mt.base;

import org.openqa.selenium.WebDriver;

import com.mt.pages.crm.accounts.AccountsPage;

public class TopMenu{

	/*
	 * 
	 * TopMenu ISA Page ???
	 * 
	 * HomePage HASA TopMenu
	 * AccountsPAge HASA TopMenu
	 * 
	 * Page HASA TopMenu
	 * 
	 * 
	 */
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public AccountsPage gotoAccounts() {
		
		
		Page.click("Accountstab_LINKTEXT");
		
		return new AccountsPage();
	}

	public void gotoContacts() {

	}
	
	
	public void signOut(){
		
		
	}

}
