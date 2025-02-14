package com.swagTest.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class AllureResultsCleanUpListener implements ITestListener {

    private static final String ALLURE_RESULTS_DIR = "allure-results";

    @Override
    public void onStart(ITestContext context) {
        // Clean up Allure results folder before test suite starts
        File allureResultsDir = new File(ALLURE_RESULTS_DIR);
        if (allureResultsDir.exists()) {
            deleteDirectory(allureResultsDir);
        }
        allureResultsDir.mkdirs(); // Recreate the directory
    }

    @Override
    public void onTestFailure(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onFinish(ITestContext context) {}

    // Method to delete directory recursively
    private void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}
