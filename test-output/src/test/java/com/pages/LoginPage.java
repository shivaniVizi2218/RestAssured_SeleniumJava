package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.swagTest.utils.JsonDataReader;

public class LoginPage {
	WebDriver driver;
    private JsonDataReader jsonDataReader;
    
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		this.jsonDataReader = new JsonDataReader("data.json");
	}
	By userNameField= By.id("user-name");
	By passwordField= By.id("password");
	By loginButton= By.name("login-button");
	public void swagLabsLogin(String username, String password) {
		driver.findElement(userNameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
//		System.out.println("Title is @@@@@@@@@@@@@@@@@@@@@@@@ " + jsonDataReader.getTitle());
	    Assert.assertEquals(driver.getTitle(), jsonDataReader.getTitle());
	}
}
