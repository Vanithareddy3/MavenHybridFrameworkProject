package com.qa.linkedin.testcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinHomePage;
import com.qa.linkedin.pages.LinkedinLoggedinPage;
import com.qa.linkedin.pages.LinkedinLoginPage;
import com.qa.linkedin.pages.SearchResultsPage;
import com.qa.linkedin.util.TestUtil;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SearchDDTest extends TestBase{
   LinkedinHomePage hmpg;
   LinkedinLoginPage lpg;
   LinkedinLoggedinPage lggpg;
   SearchResultsPage srpg;
	
 public SearchDDTest() throws IOException {
	 super();
 }
  @Test(dataProvider="dp")
  public void searchTest(String s) throws IOException, InterruptedException {
	Assert.assertTrue(lggpg.verifyProfileCard());
	//boolean b=lggpg.verifyProfileCard();
	//System.out.println("the profile card displayed is "+b);
	lggpg.searchPeople(s);
	int cnt=srpg.getResultsCount();
	System.out.println("the results count for "+s+" is-->"+cnt);
	driver.navigate().back();
	 }
  
  @DataProvider
  public Object[][] dp() throws IOException {
	Object[][] data=TestUtil.getTestData(TestUtil.TESTDATA_SHEET_PATH1,"Sheet1");
	return data;
	}
  
  @BeforeClass
  public void beforeClass() throws IOException {
	System.out.println("abcde");
	initWebdriver();
	hmpg=new LinkedinHomePage();
	lpg=new LinkedinLoginPage();
	lggpg=new LinkedinLoggedinPage();
	srpg=new SearchResultsPage();
	hmpg.clickOnSignInLink();
	lpg.login(prop.getProperty("username"),prop.getProperty("pwd"));
  }

  @AfterClass
  public void afterClass() {
	 lggpg.logOut();
	   }
//search-typeahead-v2__button typeahead-icon
}
