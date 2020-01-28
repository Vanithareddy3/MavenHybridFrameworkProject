package com.qa.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.linkedin.util.ListenerHelper;
import com.qa.linkedin.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
 public static WebDriver driver=null;
 protected static WebDriverWait wait=null;
 public static Properties prop=null;
 public static Logger log=Logger.getLogger("devpinoyLogger");
 
public TestBase() throws IOException{
  //create object for properties class
  prop=new Properties();
  //read the config.properties file
  try {
  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\linkedin\\config\\config.properties");
  //load all the properties
  prop.load(fis);
  }catch(FileNotFoundException e) {
	  e.printStackTrace();
  }
}

public static void initWebdriver() throws IOException {
	//fetch the browser name
  String browserName=prop.getProperty("browser");
//  System.out.println("browser is"+browserName);
//  System.out.println(prop.getProperty("browser"));
  if(browserName.equalsIgnoreCase("firefox")) {
	  WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
  }else if(browserName.equalsIgnoreCase("chrome")) {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }else if(browserName.equalsIgnoreCase("edge")){
	 WebDriverManager.edgedriver().setup();
	 driver=new EdgeDriver();
  }else if(browserName.equalsIgnoreCase("ie")){
	  WebDriverManager.iedriver().setup();
      driver=new InternetExplorerDriver();
}
  log.info("browser is launched");
  //add implicit wait command
  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
 // driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")),TimeUnit.SECONDS);
  //maximize the window
  driver.manage().window().maximize();
  //open the url
  driver.get(prop.getProperty("url"));
  //create object for WebDriverWait class
  wait=new WebDriverWait(driver,TestUtil.EXPLICIT_WAIT);
  //create object for FluentWait class
 // FluentWait fw=new FluentWait(driver);
  // fw.withTimeout(20,TimeUnit.SECONDS);
  // fw.pollingEvery(30,TimeUnit.SECONDS);
 
  //create object for ListenerHelper class
  ListenerHelper lh=new ListenerHelper();
  //create object for EventFiringWebDriver class
  EventFiringWebDriver evnt=new EventFiringWebDriver(driver);
  //register the events
  evnt.register(lh);
  driver=evnt;
  
  }
}
  
  
