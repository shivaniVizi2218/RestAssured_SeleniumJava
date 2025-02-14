package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage {
	WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By menuIcon= By.xpath("//button[text()='Open Menu']");
	By logout_Label= By.id("logout_sidebar_link");
	
	public void logout() {
		driver.findElement(menuIcon).click();
		driver.findElement(logout_Label).click();	
	}
}
