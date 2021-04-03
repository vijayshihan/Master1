package com.mt.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {
	
	

	@FindBy(xpath = "//*[@id='uitk-tabs-button-container']/li[2]")
	public WebElement flightTab;
	
	//locators for flight booking
	@FindBy(xpath = "//button[@aria-label='Leaving from']")
	public WebElement fromCity;
	@FindBy(xpath = "//button[@aria-label='Going to']")
	public WebElement toCity;
	@FindBy(xpath = "//button[@data-name='startDate']")
	public WebElement departFlight;
	@FindBy(xpath = "//button[@data-name='endDate']")
	public WebElement returnFlight;
	@FindBy(css = "#flight-adults")
	public WebElement adultCount;
	@FindBy(css = "#flight-children")
	public WebElement childCount;
	@FindBy(css = "button[type='submit']")
	public WebElement search;
	@FindBys({
		@FindBy(css = ".cols-nested.flight-date-fieldset.total-children-2"),
		@FindBy(xpath = "//button[text()='Search']")
	})
	public WebElement firstAge;
	@FindAll({
		@FindBy(css = "#flight-age-select-222"),
		@FindBy(id = "flight-age-select-2")
	})
	
	public WebElement secondAge;
	@FindBy(css = "fieldset.cols-nested.flight-date-fieldset.total-children-2")
	public WebElement block;
	@FindBy(css="a[role='tab']")
	public List<WebElement> tabCount;


}
