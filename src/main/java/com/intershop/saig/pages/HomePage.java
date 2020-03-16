/*
@Author: Rashmi Narayan
*/

package com.intershop.saig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.intershop.saig.base.TestBase;

public class HomePage extends TestBase {
	
//Define the object repository for home page elements
	
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement registerLink;
	
	@FindBy(xpath="//span[contains(text(),'Sign In')]")
	WebElement signInLink;
	
	@FindBy(name="SearchTerm")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@name='search']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[contains(text(),'Trainings')]")
	WebElement trainingsCategoryLink;
	
	@FindBy(xpath="//div[@class='col-sm-3 logo-wrapper hidden-xs']//a//img")
	WebElement saigLogo;
	
//Initializing the Page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Actions to verify the elements of the page
	
	//Verify if the SAIG logo is displayed
	public boolean verifyLogo() {
		return saigLogo.isDisplayed();
	}
	
	//Select the search box and perform search
	public SearchResultsPage searchTerm(String text) {
		searchBox.sendKeys(text);
		searchButton.click();
		return new SearchResultsPage();
	}
	
	//Click on Register link for new user registration
	public CreateAccountPage clickRegisterLink() {
		registerLink.click();
		return new CreateAccountPage();
	}
	
	//Click on Sign In link to the login page for existing users to login
	public LoginPage clickSignInLink() {
		signInLink.click();
		return new LoginPage();
	}
}
