package com.mt.pages.crm.accounts;

import com.mt.base.Page;

public class AccountsPage  extends Page{
	
	
	
	
	public CreateAccountPage gotoCreateAccounts(){
		
		click("createaccountbtn_XPATH");
		
		return new CreateAccountPage();
	}
	
	
	public void gotoImportAccounts(){
		
		
	}

}
