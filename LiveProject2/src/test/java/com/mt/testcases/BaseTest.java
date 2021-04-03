package com.mt.testcases;

import org.testng.annotations.AfterSuite;

import com.mt.base.Page;

public class BaseTest {
	
	
	@AfterSuite
	public void tearDown(){
		
		Page.quit();
		
	}

}
