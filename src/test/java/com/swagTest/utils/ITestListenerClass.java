package com.swagTest.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.swagTest.BaseTest;

public class ITestListenerClass implements ITestListener {

    private BaseTest baseTest = new BaseTest(); // Composition instead of inheritance

    @Override
    public void onTestFailure(ITestResult result) {
        // Use the WebDriver instance from the test class
        BaseTest testClass = (BaseTest) result.getInstance();
        if (testClass != null && testClass.driver != null) {
            // Capture screenshot using the WebDriver instance from the test class
            testClass.captureScreenshot(result.getMethod().getMethodName() + ".jpg");
        } else {
            System.out.println("Driver instance is null. Screenshot cannot be taken.");
        }
    }
    
    
    
    
    public void onStart(ITestContext context) {
        clearLogFile();
    }

    // Implement other methods as needed

    private void clearLogFile() {
        File logFile = new File("logs/test-log.log");
        try (FileWriter writer = new FileWriter(logFile, false)) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
