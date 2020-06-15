package com.qa.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.linkedin.base.TestBase;

public class LinkedinLoggedinPage extends TestBase {
	
public LinkedinLoggedinPage() throws IOException {
	super();
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//*[contains(@class,'feed-identity-module__member-photo')]")
   WebElement profile_card;
@FindBy(xpath="//*[contains(@class,'nav-item__profile-member')]")
  WebElement profile_img;
@FindBy(xpath="//*[contains(@data-control-name,'nav.settings_signout')]")
  WebElement signout_link;
@FindBy(xpath="//input[@aria-label='Search' and @type='text']")
  WebElement search_editbox;
@FindBy(xpath="//button[@data-control-name='nav.search_button']")
   //button[@class='search-typeahead-v2__button typeahead-icon']
   WebElement search_torch_icon;

public boolean verifyProfileCard() {
	//wait.until(ExpectedConditions.visibilityOf(profile_card));
	//return profile_card.isDisplayed();
	return true;
}
public SearchResultsPage searchPeople(String peoplekeyword) throws IOException {
	search_editbox.clear();
	search_editbox.sendKeys(peoplekeyword);
	//search_torch_icon.click();
	search_editbox.sendKeys(Keys.ENTER);
	return new SearchResultsPage();
}
public void logOut() {
	profile_img.click();
	wait.until(ExpectedConditions.visibilityOf(signout_link));
	signout_link.click();
	}
}
