/*
 * @Author: Rashmi Narayan
 */
package com.intershop.saig.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.intershop.saig.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//Read data from Properties file
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/resources/com/intershop/saig/config/config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//Initializing the property file
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		 if(browserName.equalsIgnoreCase("firefox")){
			 System.setProperty("webdriver.gecko.driver", "./src/main/java/com/intershop/saig/resources/geckodriver.exe");
			 driver = new FirefoxDriver();
		 } 
		 else if(browserName.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", "./src/main/java/com/intershop/saig/resources/chromedriver.exe");
			 driver = new ChromeDriver();
			
		 }
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url"));
		 
	 }
	}

