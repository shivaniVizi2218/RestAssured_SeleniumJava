package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	By checkoutBtn= By.id("checkout");
	By firstname_inputFileld= By.id("first-name");
	By lastname_inputField= By.id("last-name");
	By zipCode_inputField= By.id("postal-code");
	By cotinueBtn= By.id("continue");
	By finishBtn= By.id("finish");
	By successMessage= By.xpath("//h2");
	
	public void clickingOnCheckoutBtn() {
		System.out.println("Entered into clickingOnCheckoutBtn function");
		driver.findElement(checkoutBtn).click();
		System.out.println("clicked on checkout btn");
	}
	public void enteringCheckoutDetails(String firstName, String lastName, String zipcode) {
		driver.findElement(firstname_inputFileld).sendKeys(firstName);
		driver.findElement(lastname_inputField).sendKeys(lastName);
		driver.findElement(zipCode_inputField).sendKeys(zipcode);
	}
	public void clickingOnContinueBtn() {
		driver.findElement(cotinueBtn).click();
	}
	public void clickingOnFinishBtn() {
		driver.findElement(finishBtn).click();
		 Assert.assertTrue(driver.findElement(successMessage).isDisplayed(), "The 'Continue Shopping' button is not visible.");
	}
}
