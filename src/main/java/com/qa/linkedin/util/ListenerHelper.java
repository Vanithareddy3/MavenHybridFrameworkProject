package com.qa.linkedin.util;

import java.io.IOException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.linkedin.base.TestBase;

public class ListenerHelper extends TestBase implements WebDriverEventListener {
 public ListenerHelper() throws IOException {
	 super();
 }
public void beforeNavigateTo(String url,WebDriver driver) {
  System.out.println("Before navigating to: '"+url+"'");
 }
public void afterNavigateTo(String url,WebDriver driver) {
  System.out.println("Before navigating to: '"+url+"'");
 }
public void beforeChangeValueOf(WebElement element,WebDriver driver) {
  System.out.println("value of the:"+element.toString()+"before any changes made");
 }
public void afterChangeValueOf(WebElement element,WebDriver driver) {
  System.out.println("element value changed to:"+element.toString());
  }

public void beforeClickOn(WebElement element,WebDriver driver) {
  System.out.println("trying to click on: "+element.toString());
  }
public void afterClickOn(WebElement element,WebDriver driver) {
  System.out.println("clicked on: "+element.toString());
  }
public void beforeNavigateBack(WebDriver driver) {
	  System.out.println("navigating back to previous page");
	 }
public void afterNavigateBack(WebDriver driver) {
	  System.out.println("navigated back to previous page");
	 }
public void beforeNavigateForward(WebDriver driver) {
	  System.out.println("navigating forward to next page");
	 }
public void afterNavigateForward(WebDriver driver) {
	  System.out.println("navigated forward to next page");
	 }
public void onException(Throwable error,WebDriver driver) {
	  System.out.println("Exception occured: "+error);
	  try {
		  TestUtil.takeScreenshotAtEndOfTest();
	  }catch(IOException e) {
		  e.printStackTrace();
	  }
	 }
public void beforeFindBy(By by,WebElement element, WebDriver driver) {
   System.out.println("trying to find element By :"+by.toString());
  }
public void afterFindBy(By by, WebElement element, WebDriver driver) {
	System.out.println("Found Element By :"+by.toString());
  }
/*
 *non overridden methods of WebDriverListener interface
 */
public void beforeAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterAlertAccept(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void beforeAlertDismiss(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void beforeNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterNavigateRefresh(WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	
}
public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	// TODO Auto-generated method stub
	
}
public void beforeScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterScript(String script, WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterSwitchToWindow(String windowName, WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public <X> void beforeGetScreenshotAs(OutputType<X> target) {
	// TODO Auto-generated method stub
	
}
public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	// TODO Auto-generated method stub
	
}
public void beforeGetText(WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public void afterGetText(WebElement element, WebDriver driver, String text) {
	// TODO Auto-generated method stub
	
}
}
