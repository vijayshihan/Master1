package com.mt.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageLocators {
	
	
	@FindBy(css="#signin-loginid")
	public WebElement email;
	@FindBy(css="#signin-password")
	public WebElement password;
	@FindBy(css="#submitButton")
	public WebElement submit;
	
    @FindBy(xpath = "//a[text()='Sign in']")
	public WebElement signinBtn2;

}
