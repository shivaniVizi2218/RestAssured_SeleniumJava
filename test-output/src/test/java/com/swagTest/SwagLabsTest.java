package com.swagTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.pages.CheckOutPage;
import com.pages.LogOutPage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.swagTest.utils.ClearLogs;


public class SwagLabsTest extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	private static final Logger logger = LogManager.getLogger(SwagLabsTest.class);
	ProductPage productpage;
	
	@Parameters("url")
	@Test(priority = 0)
	public void launchApp(String url) {
		driver.get(url);
		logger.info("Application launched successfully");
	}
	@Parameters({ "username", "password" })
	@Test(priority = 1)
	public void Swaglogin(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.swagLabsLogin(username, password);
		logger.info("Login is successful");
	}

	@Test(priority = 2)
	public void addingProductToCartAndRemove() {
		productpage= new ProductPage(driver);
		productpage.addingProductToCart();
		productpage.clickonRemoveButton();
		logger.info("Item added to cart and removed it");
	}

	@Test(priority = 3)
	public void addProductToCart() {
		productpage.clickOnContinueShoppingBtn();
		productpage.addingProductToCart();
		logger.info("Item added to cart");
	}

	@Parameters({ "firstname", "lastname", "zipcode" })
	@Test(priority = 4)
	public void checkOutTheProduct(String firstname, String lastname, String zipcode) {
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.clickingOnCheckoutBtn();
		checkoutpage.enteringCheckoutDetails(firstname, lastname, zipcode);
		checkoutpage.clickingOnContinueBtn();
		checkoutpage.clickingOnFinishBtn();
		logger.info("Item is checked-out and entered the details");
	}

	@Test(priority = 5)
	public void logOutApplication() {
		LogOutPage logout = new LogOutPage(driver);
		logout.logout();
		logger.info("Successfully logged out from the application");
	}
}
