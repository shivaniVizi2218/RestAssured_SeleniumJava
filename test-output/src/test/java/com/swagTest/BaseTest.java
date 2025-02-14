package com.swagTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void intialBrowserSetUp( @Optional("firefox") String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("Browser name is invalid");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	public void captureScreenshot(String filename) {
		 File screenshotDir = new File("./screenshots");
	        if (!screenshotDir.exists()) {
	            screenshotDir.mkdirs(); // Ensure directory exists
	        }
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	        File destFile = new File(screenshotDir, filename);

	        try {
	            FileUtils.copyFile(sourceFile, destFile);
	            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
