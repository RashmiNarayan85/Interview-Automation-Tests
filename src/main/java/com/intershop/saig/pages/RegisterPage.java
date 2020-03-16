/*
 * @Author: Rashmi Narayan
 */
package com.intershop.saig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.intershop.saig.base.TestBase;

public class RegisterPage extends TestBase{
	
	//Defining the Objects (Object Repository)

	@FindBy(xpath="//h1[contains(text(),'Create a New Account')]")
	WebElement createAccountHeading;

    @FindBy(xpath="//h2[contains(text(),'E-mail & Password')]")
    WebElement emailHeading;
	
	@FindBy(id="RegisterUserFullEmail_Login")
	WebElement emailAddress;
	
	@FindBy(id="RegisterUserFullEmail_EmailConfirmation")
	WebElement emailAddressConfirm;
	
	@FindBy(id="RegisterUserFullEmail_Password")
	WebElement password;
	
	@FindBy(id="RegisterUserFullEmail_PasswordConfirmation")
	WebElement confirmPassword;
	
	@FindBy(id="AddressForm_CountryCode")
	WebElement countryDropdown;
	
	@FindBy(xpath="//select[@id='AddressForm_CountryCode']//option[contains(text(),'Australia')]")
	WebElement selectAustralia;
	
	@FindBy(id="AddressForm_FirstName")
	WebElement firstName;
	
	@FindBy(id="AddressForm_LastName")
	WebElement lastName;
	
	@FindBy(id="AddressForm_Address1")
	WebElement address1;
	
	@FindBy(id="AddressForm_PostalCode")
	WebElement postCode;
	
	@FindBy(id="AddressForm_State")
	WebElement state;
			
	@FindBy(id="AddressForm_City")
	WebElement city;
	
	@FindBy(id="AddressForm_PhoneHome")
	WebElement phone;
	
	@FindBy(name="a-dju06g6gk5h4")
	WebElement robotCheckbox;
	
	@FindBy(id="recaptcha-anchor")
	WebElement captchaCheckbox;
	
	@FindBy(name="CreateAccount")
	WebElement createAccountButton;
	
	
	//Initializing the page factory
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	//Verify if the create account heading is displayed
	public void createAccountHeading() {
		boolean objVisible = createAccountHeading.isDisplayed();
		if(objVisible) {
			System.out.println("Create Account Page is displayed");
		}
		else {
			System.out.println("Error with registration page display");
		}
	}
	
	//verify the email address label 
	public void emailPasswordHeading() {
		boolean objVisible = emailHeading.isDisplayed();
		if(objVisible) {
			System.out.println("E-mail & Password is displayed");
		}
		else {
			System.out.println("E-mail & Password is not displayed");
		}
	}
	
	//Create Account
	public void createNewAccount(String eMail, String eMailConfirm, String pwd, String confPwd,
			String ctry, String fn, String ln, String add1, String pc,String stat, String cty, String phne) throws InterruptedException {
		emailAddress.sendKeys(eMail);
		emailAddressConfirm.sendKeys(eMailConfirm);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confPwd);
		Select countrySelect = new Select (countryDropdown);
		countrySelect.selectByVisibleText(ctry);
		Thread.sleep(3000);
		firstName.sendKeys(fn);
		Thread.sleep(3000);
		lastName.sendKeys(ln);
		Thread.sleep(3000);
		address1.sendKeys(add1);
		Thread.sleep(3000);
		city.sendKeys(cty);
		Thread.sleep(3000);
		postCode.sendKeys(pc);
		Thread.sleep(3000);
		Select stateSelect = new Select (state);
		stateSelect.selectByVisibleText(stat);
		phone.sendKeys(phne);
		Thread.sleep(3000);
		//builder.moveToElement.
		Thread.sleep(3000);
		//driver.switchTo().frame(robotCheckbox);
		Thread.sleep(3000);
		//captchaCheckbox.click();
		Thread.sleep(3000);
		createAccountButton.click();
		Thread.sleep(3000);
	}
}
