/*
@Author: Rashmi Narayan
*/

package com.intershop.saig.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.intershop.saig.base.TestBase;
import com.intershop.saig.pages.HomePage;
import com.intershop.saig.pages.LoginPage;
import com.intershop.saig.pages.RegisterPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	RegisterPage regPage;
	LoginPage loginPage;
	
public HomePageTest() {
	super();
}
	
@BeforeMethod
public void setUp() {
	initialization();
	homePage = new HomePage();
	regPage = new RegisterPage();
	loginPage = new LoginPage();
}

@Test(testName = "TC001 - Verify Logo", description = "Logo Image is displayed" , priority = 0)
public void verifySAIGLogo() {
	homePage.verifyLogo();
}

@Test(testName="TC002 - Register Link", description = "Click on register link", priority = 1)
public void clickRegisterLinkTest() {
	homePage.clickRegisterLink();
	regPage.createAccountHeading();
}

@Test(testName="TC003 - Sign-In Link", description = "Click on Sign-In link", priority = 2)
public void clickSignInLinkTest() {
	homePage.clickSignInLink();
	loginPage.loginHeading();
}

@Test(testName="TC004 - Search test", description = "Searching for keywords", priority = 3)
public void searchTermTest() {
	homePage.searchTerm("ISO");
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
	
}
