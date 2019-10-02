package com.qa.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.base.TestBase;

public class SearchResultsPage extends TestBase {
	
public SearchResultsPage() throws IOException {
   super();
   PageFactory.initElements(driver,this);
  }
@FindBy(xpath="//h3[contains(@class,'search-results__total')]")
 WebElement search_results_text;
@FindBy(id="feed-tab-icon")
 WebElement home_tab;
public int getResultsCount() {
	//get the results text
	String resText=search_results_text.getText();
	//get the results count
	//split the results text and fetch the count
	//txt="showing","189,990","results";
	String[] str=resText.split(" ");
	//str[]=["showing","189,990","results"]
	String finalResCount=str[1].replace(","," ").trim();
	//convert String into integer
	int i=Integer.parseInt(finalResCount);
	return i;
	}

}
