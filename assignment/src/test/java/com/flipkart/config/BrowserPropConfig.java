package com.flipkart.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.flipkart.actions.GetConfigDataAction;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPropConfig extends GetConfigDataAction{
	GetConfigDataAction getConfigDataAction = new GetConfigDataAction();

	static Properties propConfig = new Properties();
	static String projectPath = System.getProperty("user.dir");
	public static WebDriver driver = null;
	public String propValue;
	
	public void setupBrowser() throws FileNotFoundException {

		try {
			propValue = getConfigDataAction.getProperties("/src/test/resources/configFiles/browserconfig.properties", "browser").toString();

			if(propValue.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup(); //Initialising and starting the chrome browser
				driver = new ChromeDriver();

			}else if(propValue.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();  //Initialising and starting the firefox browser
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
	}
}