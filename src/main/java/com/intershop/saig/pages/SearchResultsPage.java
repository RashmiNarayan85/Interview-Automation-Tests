/*
@Author: Rashmi Narayan
*/

package com.intershop.saig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.intershop.saig.base.TestBase;

public class SearchResultsPage extends TestBase {

//Initializing the Page factory
public SearchResultsPage() {
	PageFactory.initElements(driver, this);
	}

//object repository
@FindBy(xpath="//div[@class='search-product-list']//div[contains(text(),'Refine Your Search')]")
WebElement refineSearchHeading;

@FindBy(xpath="//label[contains(text(),'Content')]")
WebElement contentLabel;

@FindBy(xpath="//label[contains(text(),'Products')]")
WebElement productsLabel;

//Actions to verify the elements of the page
public void searchHeading() {
	boolean objVisible = refineSearchHeading.isDisplayed();
	if(objVisible) {
		System.out.println("Search Results page is displayed");
	}
	else {
		System.out.println("Error finding the search results");
	}
}

public void contentHeading() {
	boolean contentVisible = contentLabel.isDisplayed();
	if(contentVisible) {
		System.out.println("Search Results content is displayed");
	}
	else {
		System.out.println("search content is unavailable");
	}
}

		
}
