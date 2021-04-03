package com.mt.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mt.base.Page;
import com.mt.errorcollectors.ErrorCollector;
import com.mt.pages.actions.HomePage;
import com.mt.utilities.Utilities;

public class FlightSearchTest {
	
	@BeforeTest
	public void setUp(){
		
		Page.initConfiguration();
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void flightSearchTest(Hashtable<String,String> data) {
		
		
		//System.out.println("Printing no of adults and children : "+data.get("noOfAdults")+"---"+ data.get("noOfChildern"));
		
		HomePage home = new HomePage();
		//Assert.assertEquals(home.findTabCount(), 7);
	/*	ErrorCollector.verifyEquals(home.findTabCount(), 6);
		ErrorCollector.verifyEquals(home.findTabCount(), 7);
		ErrorCollector.verifyEquals(home.findTabCount(), 8);*/
		ErrorCollector.verifyEquals(home.findTabCount(), 5);
		home.gotoFlights().bookAFlight(data.get("fromCity"), data.get("toCity"), data.get("fromDate"), data.get("toDate"), data.get("noOfAdults"), data.get("noOfChildern"));
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		if(Page.driver!=null){
		Page.quitBrowser();
		}
	}
	

}
