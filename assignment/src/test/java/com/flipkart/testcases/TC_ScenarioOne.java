package com.flipkart.testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.Reporter;

import com.flipkart.actions.TC_ScenarioOneAction;
import com.flipkart.config.BrowserPropConfig;
import com.flipkart.config.SetUrlConfig;

public class TC_ScenarioOne extends TC_ScenarioOneAction{

	TC_ScenarioOneAction tcActions = new TC_ScenarioOneAction(); 
	SetUrlConfig urlConfig = new SetUrlConfig();

	boolean blnStatus = false;

	@Test
	public void initialization() throws Exception {
		try {
			Reporter.log("Launch the website https://www.flipkart.com");
			urlConfig.launchUrl();
			
			Reporter.log("Click on close button on the login popup");
			blnStatus = tcActions.clickBtnLoginPopupClose();
			Assert.assertTrue(true);
			
			Reporter.log("Hover on Fashion section");
			blnStatus = tcActions.hoverFeshionMenu();
			Assert.assertTrue(true);
			
			Reporter.log("Hover on Kids subsection");
			blnStatus = tcActions.hoverSubMenuKids();
			Assert.assertTrue(true);
			
			Reporter.log("Click on Boys & Girls Jeans under Kids subsection");
			blnStatus = tcActions.clickBoysAndGirlsJeans();
			Assert.assertTrue(true);
			
			Reporter.log("Select Price- Low to High in Sort By section");
			blnStatus = tcActions.clickPriceLowToHigh();
			Assert.assertTrue(true);
			
			FileReader fileReader = new FileReader("src/test/resources/testData/productDetails.json");
			JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(fileReader);
			String strProductBrand = (String) jsonObj.get("productBrand");
			String strProductName = (String) jsonObj.get("productName");
			
			Reporter.log("Click on any item displayed");
			blnStatus = tcActions.clickItem(strProductBrand, strProductName);
			Assert.assertTrue(true);
		
			Reporter.log("Get the price of the item");
			String expectedItemPrice = tcActions.getPriceOfItem(strProductName);
			Assert.assertNotSame(expectedItemPrice, " ");
			
			Reporter.log("Fill all the required field (Select the Size of item)");
			blnStatus = tcActions.clickSelectedItemSize();
			Assert.assertTrue(true);
			
			Reporter.log("Add the item to the cart");
			blnStatus = tcActions.clickAddToCartButton();
			Assert.assertTrue(true);
			
			Reporter.log("Verify the price of item in the checkout page matches with the one we had before added to the item");
			String actualItemPrice = tcActions.verifyItemPriceOnCheckout(strProductName);
			Assert.assertEquals(actualItemPrice, expectedItemPrice);
			
			String strProductNameOnCheckout = (String) jsonObj.get("checkoutPageProductName");
			//Name of item on checkout page is different from the listing page so added a new key in json		
			Reporter.log("Verify the name of item in the checkout page matches with the one we had before added to the item");
			blnStatus = tcActions.verifyItemNameOnCheckout(strProductNameOnCheckout);
			Assert.assertTrue(true);
			
			
			Reporter.log("Click remove of item on checkout page");
			blnStatus = tcActions.clickItemRemoveButton(strProductNameOnCheckout);
			Assert.assertTrue(true);
			
			Reporter.log("Verify if the popup displayed");
			blnStatus = tcActions.verifyremovePopup();
			Assert.assertTrue(true);
			
			Reporter.log("Click on remove button in the popup");
			blnStatus = tcActions.clickRemoveOnPopup();
			Assert.assertTrue(true);
			
			Reporter.log("Verify the success message displayed after removing the product");
			String actualMessage = tcActions.verifyRemovedItemToast(strProductNameOnCheckout);
			Assert.assertTrue(actualMessage.contains("Successfully removed " + strProductNameOnCheckout));
			
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		BrowserPropConfig.driver.quit();}

}
