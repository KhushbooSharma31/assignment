package com.flipkart.actions;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.config.BrowserPropConfig;

public class TC_ScenarioOneAction {
	WebDriverWait wait;
	Actions action;
	String winHandleBefore;

	public static final String btnLoginPopupCloseXpath = "//button[@class='_2KpZ6l _2doB4z' and text()='✕']";
	public static final String menuFashionXpath = "//*[@id='container']/div/div[2]/div/div/div[3]/a";
	public static final String subMenuKidsLinkText = "Kids";
	public static final String boysAndGirlJeansLinkText = "Boys & Girls Jeans";
	public static final String priceLowToHighXpath = "//span[text()='Sort By']//..//div[text()='Price -- Low to High']";
	public static final String selectItemXpath = "//div[text()='{0}']//..//a[text()='{1}']";
	public static final String selectedItemPriceXpath = "//span[text()='{0}']//..//..//..//div[@class='_30jeq3 _16Jk6d']";
	public static final String selectedItemSizeXpath = "//*[contains(@id, 'swatch-')]/a[@class='_1fGeJ5 _2UVyXR _31hAvz']";
	public static final String btnAddToCartXpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][text()='Add to cart']";
	public static final String itemNameOnCheckoutXpath = "//div[@class='_2nQDXZ']//a[text()='{0}']";
	public static final String itemPriceOnCheckoutXpath = "//div[@class='_3fSRat']//span[@class='_2-ut7f _1WpvJ7']";
	public static final String itemRemoveXpath = "//a[text()='{0}']//..//..//..//..//div[text()='Remove']";
	public static final String removePopupXpath = "//div[@class='_2_e-g9 _2WFwmV']";
	public static final String btnPopupRemoveXpath = "//div[@class='_2_e-g9 _2WFwmV']//div[@class='_3dsJAO _24d-qY FhkMJZ'][text()='Remove']";
	public static final String removedItemToastMsgXpath = "//div[@class='_2sKwjB'][contains(text(), 'Successfully removed {0}')]";



	public boolean clickBtnLoginPopupClose() throws IOException{
		try {
			Thread.sleep(2000);
			WebElement clickPopupClose = BrowserPropConfig.driver.findElement(By.xpath(btnLoginPopupCloseXpath));
			clickPopupClose.click();
			//clickPopupClose.sendKeys(Keys.ESCAPE);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean hoverFeshionMenu() throws InterruptedException{
		boolean hoverStatus = false;
		try {	
			hoverStatus = hover(menuFashionXpath, "xpath");
			return hoverStatus;
		}catch(Exception e) {
			e.printStackTrace();
			return hoverStatus;
		}
	}

	public boolean hoverSubMenuKids() throws InterruptedException{
		boolean hoverStatus = false;
		try {	
			hoverStatus = hover(subMenuKidsLinkText, "linkText");
			return hoverStatus;
		}catch(Exception e) {
			e.printStackTrace();
			return hoverStatus;
		}
	}

	public boolean clickBoysAndGirlsJeans() throws InterruptedException{
		boolean hoverStatus = false;
		try {	
			Thread.sleep(2000);
			hoverStatus = hover(boysAndGirlJeansLinkText, "linkText");
			return hoverStatus;
		}catch(Exception e) {
			e.printStackTrace();
			return hoverStatus;
		}
	}

	public boolean clickPriceLowToHigh() throws IOException{
		try {
			Thread.sleep(2000);
			WebElement clickPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLowToHighXpath)));
			clickPrice.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickItem(String strProductBrand, String strProductName) throws IOException{
		try {
			Thread.sleep(2000);
			String dynamicXpath = createXpath(selectItemXpath, strProductBrand, strProductName);
			WebElement clickProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			clickProduct.click();

			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getPriceOfItem(String  strProductName) throws IOException{
		String getItemPrice = "";
		try {
			Thread.sleep(2000);
			windowHandle();

			String dynamicXpath = createXpath(selectedItemPriceXpath, strProductName);
			WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			getItemPrice = itemElement.getText().trim();
			return getItemPrice;
		}catch(Exception e) {
			e.printStackTrace();
			return getItemPrice;
		}
	}

	public boolean clickSelectedItemSize() throws IOException{
		try {
			Thread.sleep(2000);
			WebElement clickItemSize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedItemSizeXpath)));
			clickItemSize.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean clickAddToCartButton() throws IOException{
		try {
			Thread.sleep(2000);
			WebElement clickAddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnAddToCartXpath)));
			clickAddToCart.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String verifyItemPriceOnCheckout(String strItemPrice) throws IOException{
		String itemPrice = null;
		try {

			WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemPriceOnCheckoutXpath)));
			itemPrice = itemElement.getText().trim();
			return itemPrice;
		}catch(Exception e) {
			e.printStackTrace();
			return itemPrice;
		}
	}

	public boolean verifyItemNameOnCheckout(String strProductNameOnCheckout) throws IOException{
		boolean itemDispalyed = false;
		try {
			String dynamicXpath = createXpath(itemNameOnCheckoutXpath, strProductNameOnCheckout);
			WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			itemDispalyed = itemElement.isDisplayed();
			return itemDispalyed;
		}catch(Exception e) {
			e.printStackTrace();
			return itemDispalyed;
		}
	}

	public boolean clickItemRemoveButton(String strProductName) throws IOException{
		try {
			String dynamicXpath = createXpath(itemRemoveXpath, strProductName);
			WebElement clickProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			clickProduct.click();

			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyremovePopup() throws IOException{
		boolean itemDispalyed = false;
		try {
			
			WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(removePopupXpath)));
			itemDispalyed = itemElement.isDisplayed();
			return itemDispalyed;
		}catch(Exception e) {
			e.printStackTrace();
			return itemDispalyed;
		}
	}

	public boolean clickRemoveOnPopup() throws IOException{
		try {
			Thread.sleep(2000);
			WebElement clickProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnPopupRemoveXpath)));
			clickProduct.click();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String verifyRemovedItemToast(String strProductNameOnCheckout) throws IOException{
		String message = null;
		try {
			Thread.sleep(1000);

			String dynamicXpath = createXpath(removedItemToastMsgXpath, strProductNameOnCheckout);
			WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
			message = itemElement.getText().trim();
			return message;
		}catch(Exception e) {
			e.printStackTrace();
			return message;
		}
	}

	public boolean hover(String hoverElement, String locatorType) throws InterruptedException{
		wait = new WebDriverWait(BrowserPropConfig.driver, Duration.ofSeconds(20));
		WebElement hoverElem = null;
		try {
			switch(locatorType) {
			case "xpath":
				hoverElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hoverElement)));
				hoverElem = BrowserPropConfig.driver.findElement(By.xpath(hoverElement));
				break;
			case "linkText":
				hoverElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(hoverElement)));
				hoverElem = BrowserPropConfig.driver.findElement(By.linkText(hoverElement));
				break;	
			}
			action = new Actions(BrowserPropConfig.driver);
			action.moveToElement(hoverElem).build().perform(); 

			if(hoverElement.equals(boysAndGirlJeansLinkText)) {
				hoverElem.click();
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public String createXpath(String xpathExp, Object ...args) {
		for(int i=0; i<args.length; i++) {
			xpathExp = xpathExp.replace("{"+i+"}", (CharSequence) args[i]);
		}
		return xpathExp;
	}

	public void windowHandle() {
		winHandleBefore = BrowserPropConfig.driver.getWindowHandle();
		for(String winHandle : BrowserPropConfig.driver.getWindowHandles()){
			BrowserPropConfig.driver.switchTo().window(winHandle);
		}

	}

}
