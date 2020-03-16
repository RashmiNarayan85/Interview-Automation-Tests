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
import com.intershop.saig.pages.RegisterPage;
import com.intershop.saig.util.TestUtil;

public class RegisterPageTest extends TestBase{
     HomePage homePage;
     RegisterPage register;
	 
	 
public RegisterPageTest() {
		 super();
	 }
	
@BeforeMethod
public void setUp() {
	initialization();
 	homePage = new HomePage();
 	register = new RegisterPage();
 }
	
	
	@DataProvider
	public Object[][] getRegistrationData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData("register");
		return data;
	}
	
	//@Test(dataProvider = "getLoginData", testName="TC001 - Login", description = "Login to the site", priority = 0)
	@Test(dataProvider = "getRegistrationData")
	public void createNewAccountTest(String email,String confirmEmail,String password,String confirmPassword,String country,
			String firstName,String lastName,String Address1,String Postcode,String state,String city,String phone) throws InterruptedException {
		homePage.clickRegisterLink();
		register.createNewAccount(email,confirmEmail,password,confirmPassword,country,firstName,lastName,Address1,Postcode,state,city,phone);
		
	}


 @AfterMethod
 public void tearDown() {
 	driver.quit();
	 }
	
}
