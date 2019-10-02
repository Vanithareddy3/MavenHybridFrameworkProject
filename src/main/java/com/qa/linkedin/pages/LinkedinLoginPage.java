package com.qa.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.base.TestBase;

public class LinkedinLoginPage extends TestBase {
	
public LinkedinLoginPage() throws IOException {
	super();
	PageFactory.initElements(driver,this);
}
@FindBy(id="username")
WebElement email_editbox;
@FindBy(id="password")
WebElement pwd_editbox;
@FindBy(css="button[type='submit']")
WebElement signin_btn;

public String getLinkedinLoginPageTitle() {
	return driver.getTitle();
}
public LinkedinLoggedinPage login(String username,String pwd) throws IOException {
	email_editbox.clear();
	email_editbox.sendKeys(username);
	pwd_editbox.clear();
	pwd_editbox.sendKeys(pwd);
	signin_btn.click();
	return new LinkedinLoggedinPage();
	}

}
