package com.mt.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {

	
	
	@FindBy(css="#header-account-menu")
	public WebElement account;
	
    @FindBy(xpath = "//div[text()='Sign in']")
	public WebElement signinBtn;
    
    @FindBy(xpath = "//a[text()='Sign in']")
	public WebElement signinBtn2;
	
}
