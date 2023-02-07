package com.flipkart.config;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.flipkart.actions.GetConfigDataAction;

public class SetUrlConfig extends GetConfigDataAction{

	GetConfigDataAction getConfigDataAction = new GetConfigDataAction();
	BrowserPropConfig browserPropConfig = new BrowserPropConfig();
	private static String urlValue;

	public void launchUrl() throws FileNotFoundException {

		try {
			browserPropConfig.setupBrowser();
			urlValue = getConfigDataAction.getProperties("/src/test/resources/configFiles/urlconfig.properties", "url").toString();

			BrowserPropConfig.driver.manage().window().maximize();
			BrowserPropConfig.driver.get(urlValue);

			BrowserPropConfig.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
			BrowserPropConfig.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			e.getCause();
			
		}
	}
}
