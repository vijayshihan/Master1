package com.mt.base;

import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.mt.utilities.ExcelReader;
import com.mt.utilities.ExtentManager;
import com.mt.utilities.Utilities;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\mt\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public static TopMenu menu;
	/*
	 * Logs,
	 * Properties - OR, Config
	 * Excel
	 * Implicit and ExplicitWait
	 * Extent Reports
	 * 
	 * 
	 * 
	 * 
	 */

	public Page() {

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir") 
						+ "\\src\\test\\resources\\com\\mt\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\mt\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			
			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				/*System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			*/	
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				log.debug("Chrome Launched !!!");
			}
			
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			System.out.print("testsiteurl :===>" + config.getProperty("testsiteurl") );
			driver.manage().window().maximize();			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			//wait = new WebDriverWait(driver, 5);
			
			menu = new TopMenu(driver);
			System.out.println("end contructor ===>");
		}
	}
	
	
	
	public static void quit(){
		
		driver.quit();
		
	}
	
	
	//Common Keywords
	public static void click(String locator) {
        System.out.println("Cliking on locator..." + OR.getProperty(locator));
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}
		log.debug("Clicking on an Element : "+locator);
		System.out.println("Clicking on an Element : "+locator);
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static void type(String locator, String value) {
		
		System.out.println("Type on locator...");

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		log.debug("Typing in an Element : "+locator+" entered value as : "+value);
		System.out.println("Typing in an Element : "+locator+" entered value as : "+value);
		
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}
	
	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : "+locator+" value as : "+value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

}
}
