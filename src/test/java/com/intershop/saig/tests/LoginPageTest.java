/*
@Author: Rashmi Narayan
*/
package com.intershop.saig.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intershop.saig.base.TestBase;
import com.intershop.saig.pages.HomePage;
import com.intershop.saig.pages.LoginPage;
import com.intershop.saig.pages.MyAccountOverview;
import com.intershop.saig.util.TestUtil;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	MyAccountOverview myAccount;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	 	homePage = new HomePage();
	 	loginPage = new LoginPage();
	 	myAccount = new MyAccountOverview();
	 }
	
	/*
	@Test(testName="TC001 - Login", description = "Login to the site", priority = 0)
	public void loginTest() throws InterruptedException {
		homePage.clickSignInLink();
		loginPage.login("r.narayan@intershop.com", "intershop123");
		myAccount.myAccountHeading();
	}
	*/
	
	@DataProvider
	public Object[][] getLoginData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData("login");
		return data;
	}
	
	//@Test(dataProvider = "getLoginData", testName="TC001 - Login", description = "Login to the site", priority = 0)
	@Test(dataProvider = "getLoginData")
	public void loginTest(String eMail, String pwd) throws InterruptedException {
		homePage.clickSignInLink();
		loginPage.login(eMail,pwd);
		myAccount.myAccountHeading();
	}
	
	
	 @AfterMethod
	 public void tearDown() {
	 	driver.quit();
		 }

}
