/**
 * @author D E L L
 *
 */
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringObj;
	public static WebEventListener eventListenerObj;
	static String currentUsersHomeDir;
	
	public TestBase() throws IOException {
		prop=new Properties();	
		currentUsersHomeDir = System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(currentUsersHomeDir +"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
	}
	
	public static void initialization() throws Exception {
		String browserName=prop.getProperty("browser");
		switch(browserName)
		{
		   	case "chrome" :
			System.setProperty("webdriver.chrome.driver", "C:\\Shruti\\Study\\Selenium\\Selenium Downloads\\Driver\\chromedriver_win32\\chromedriver_win32_2.37\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		   	case "firefox" :
			System.setProperty("webdriver.gecko.driver", "C:\\Shruti\\Study\\Selenium\\Selenium Downloads\\Driver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
			
		   	case "iexplorer" :
				System.setProperty("webdriver.ie.driver", "C:\\Shruti\\Study\\Selenium\\Selenium Downloads\\Driver\\IEDriver\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				break;
				
			default:
			System.setProperty("webdriver.chrome.driver", "C:\\Shruti\\Study\\Selenium\\Selenium Downloads\\Driver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver=new ChromeDriver();
			break;
		}
		
		//To create a event log on console at every action that happens on web browser
		eventFiringObj=new EventFiringWebDriver(driver);
		eventListenerObj=new WebEventListener();
		//Register EventListenerHandler with EventFiringWebDriver
		eventFiringObj.register(eventListenerObj);
		driver=eventFiringObj; 
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}