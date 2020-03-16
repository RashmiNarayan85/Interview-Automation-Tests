/*
@Author: Rashmi Narayan
*/
package com.intershop.saig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.intershop.saig.base.TestBase;

public class MyAccountOverview extends TestBase {
	
//Objects
@FindBy(xpath="//body//h1[1]")
WebElement welcomeText;
	
@FindBy(xpath="//li[@class='active']//a[contains(text(),'My Account')]")
WebElement myAccountLink;
	
	
//Initializing the Page factory
public MyAccountOverview() {
	PageFactory.initElements(driver, this);
}


public void myAccountHeading() {
	 boolean objVisible = welcomeText.isDisplayed();
	if(objVisible) {
		System.out.println("User is successfully logged into the site");
	}
	else {
		System.out.println("Error with user login");
	}
}
}

