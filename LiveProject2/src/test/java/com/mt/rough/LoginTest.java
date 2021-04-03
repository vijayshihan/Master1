package com.mt.rough;

import com.mt.base.Page;
import com.mt.pages.HomePage;
import com.mt.pages.LoginPage;
import com.mt.pages.ZohoAppPage;
import com.mt.pages.crm.accounts.AccountsPage;
import com.mt.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) {


		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zp = lp.doLogin("shindevs87@gmail.com", "zoho@123");
		zp.gotoCRM();
		AccountsPage account = Page.menu.gotoAccounts();
		CreateAccountPage cap = account.gotoCreateAccounts();
		cap.createAccount("Raman");
		
		//driver.manage.window.maximze()

		
		
	}

}
