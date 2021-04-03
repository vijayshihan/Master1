package com.mt.pages;

import com.mt.base.Page;

public class LoginPage  extends Page{
	
	
	public ZohoAppPage doLogin(String username,String password){
		
		System.out.println("==> Entering the login details : " + username +" : " + password);
		click("email_CSS");
		type("email_CSS",username);
		click("signbtn_CSS");
		type("password_CSS",password);
		click("signbtn_CSS");
		
		return new ZohoAppPage();
	}
	
	
	public void gotoSalesandMarketing(){
		
		
	}
	
	public void gotoFinance(){
		
		
	}
	
}
