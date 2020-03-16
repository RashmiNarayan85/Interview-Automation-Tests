/*
Author: Rashmi Narayan
*/

package com.intershop.saig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.intershop.saig.base.TestBase;

public class LoginPage extends TestBase {
	
	//Object Repository
	@FindBy(xpath="//h1[contains(text(),'Login')]")
	WebElement loginLabel;
	
	@FindBy(id="ShopLoginForm_Login")
	WebElement emailAddress;
	
	@FindBy(id="ShopLoginForm_Password")
	WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[@class='btn btn-default']")
	WebElement createAccountButton;
	
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotPasswordLink;
	
	//initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
		//Verify if the login heading is displayed
		public void loginHeading() {
			boolean objVisible = loginLabel.isDisplayed();
			if(objVisible) {
				System.out.println("Login Page is displayed");
			}
			else {
				System.out.println("Error with Login page");
			}
		}
	
	//Login to the site
		public void login(String eMail, String pwd) {
			emailAddress.sendKeys(eMail);
			password.sendKeys(pwd);
			signInButton.click();
			
		}
}
