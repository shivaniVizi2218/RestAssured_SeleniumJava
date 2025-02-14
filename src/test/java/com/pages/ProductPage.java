package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By productSortContainer = By.xpath("//select[@class='product_sort_container']");
    By priceLowToHigh = By.xpath("//option[@value='lohi']");
    By addToCartBtn = By.xpath("(//button[contains(text(), 'Add to cart')])[1]");
    By shoppingCartLink = By.className("shopping_cart_link");
    By removeBtn = By.xpath("(//button)[3]");
    By continueShoppingBtn = By.id("continue-shopping");

    // Method to add a product to the cart
    public void addingProductToCart(){
        System.out.println("Entered into the addingProductToCart function");
        WebElement sortDropDown = driver.findElement(productSortContainer);
        Select sortOption= new Select(sortDropDown);
        sortOption.selectByValue("lohi");
        driver.findElement(addToCartBtn).click();
        System.out.println("Clicked 'Add to cart' button");
        driver.findElement(shoppingCartLink).click();
        System.out.println("Clicked shopping cart link");
        WebElement continueShopping = driver.findElement(continueShoppingBtn);
        Assert.assertTrue(continueShopping.isDisplayed(), "The 'Continue Shopping' button is not visible.");
    }

    // Method to click on the remove button
    public void clickonRemoveButton() {
        driver.findElement(removeBtn).click();
    }

    // Method to click on the continue shopping button
    public void clickOnContinueShoppingBtn() {
    	driver.findElement(continueShoppingBtn).click();
        System.out.println("Clicked 'Continue Shopping' button");
    }
}
