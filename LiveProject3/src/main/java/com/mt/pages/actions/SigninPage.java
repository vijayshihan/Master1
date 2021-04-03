package com.mt.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.mt.base.Page;
import com.mt.pages.locators.SigninPageLocators;

public class SigninPage extends Page {
	
	
	public SigninPageLocators signinPage;
	

	public SigninPage(){
		
		this.signinPage = new SigninPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.signinPage);
		
	}
	
	public void doLogin(String username,String password){
		
	    driver.navigate().to("https://www.expedia.co.in/user/signin");
		System.out.println("DOne clicking on second signin button...");
		type(signinPage.email,username);

		
		type(signinPage.password,password);
		click(signinPage.submit);
		System.out.println("Successfully logged in...");
			
	}

}
