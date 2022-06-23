package org.commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CommonFunctions {
	public static Properties properties = null;
	public static WebDriver driver = null;
	static Logger logger=Logger.getLogger(CommonFunctions.class);

	public static Properties loadPropertyFile() throws IOException {
		FileInputStream f = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(f);
		return properties;

	}

	@BeforeSuite
	public void launchBrowser() throws IOException, InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Orange HRM Test Begins");
		logger.info("Loading the property file");
		loadPropertyFile();
		String browser=properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverLocation=properties.getProperty("DriverLocation");

	/*	if (browser.equalsIgnoreCase("chrome")) {*/
			System.setProperty("webdriver.chrome.driver","C:\\Users\\balua\\eclipse-workspace\\POMLiveProject\\Driver2\\chromedriver.exe");
			logger.info("Launching chrome");
		    driver = new ChromeDriver();
		/*	
		}else if (browser.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver",driverLocation);
			driver= new FirefoxDriver();
		}*/
		

		
		driver.manage().window().maximize();
		logger.info("Navigating to Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		

	}

	@AfterSuite
	public void tearDown() {
		logger.info("Execution done.Application closed");
		driver.quit();

	}


}
