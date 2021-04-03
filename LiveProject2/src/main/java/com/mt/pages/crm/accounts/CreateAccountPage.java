package com.mt.pages.crm.accounts;

import com.mt.base.Page;

public class CreateAccountPage  extends Page {
	
	
	public void createAccount(String accountName){
		
		type("accountname_CSS",accountName);
		click("createaccSavebBtn_XPATH");
		
	}

}
