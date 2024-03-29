package com.mt.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mt.base.Page;
import com.mt.pages.actions.SigninPage;
import com.mt.utilities.Utilities;

public class SignInTest {

	
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void signInTest(Hashtable<String,String> data) {
		
		if(data.get("runmode").equalsIgnoreCase("N")){			
			throw new SkipException("Skipping the test as the Run mode is NO");			
		}
		Page.initConfiguration();
		SigninPage signin = Page.topNav.gotoSignIn();
		signin.doLogin(data.get("username"), data.get("password"));
		
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}
}
