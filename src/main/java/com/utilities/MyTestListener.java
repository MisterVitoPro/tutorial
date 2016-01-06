package com.utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by MisterVitoPro on 8/16/2015.
 */
public class MyTestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult testResult){
        System.out.println(testResult.getName() + " was successful.");
        // Write to Excel sheets
    }

    @Override
    public void onTestFailure(ITestResult testResult){
        System.out.println(testResult.getName() + " was a failure.\n Throwable: "+testResult.getThrowable().getMessage());
        // Screenshots
        // Write to Excel sheets
    }

    @Override
    public void onTestSkipped(ITestResult testResult){
        System.out.println(testResult.getName() + " was skipped.");
    }
}
