package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

/**
 * Created by MisterVitoPro on 8/16/2015.
 */
public class MyTestListener extends TestListenerAdapter {

    static MyTestResults results = new MyTestResults();

    @Override
    public void onTestSuccess(ITestResult testResult){
        System.out.println(testResult.getName() + " was successful.");
        // Write to Excel sheets
        results.incrementPassed();
        System.out.println("PASSED TESTS: "+results.getPassed());
        System.out.println("TOTAL TESTS: "+results.getTotalTests());
    }

    @Override
    public void onTestFailure(ITestResult testResult){
        System.out.println(testResult.getName() + " was a failure.\n Throwable: "+testResult.getThrowable().getMessage());
        // Screenshots
        // Write to Excel sheets
        results.incrementFailed();
        System.out.println("FAILED TESTS: "+results.getFailed());
        System.out.println("TOTAL TESTS: "+results.getTotalTests());
    }

    @Override
    public void onTestSkipped(ITestResult testResult){
        System.out.println(testResult.getName() + " was skipped.");
        results.incrementSkipped();
        System.out.println("SKIPPED TESTS: "+results.getSkipped());
        System.out.println("TOTAL TESTS: "+results.getTotalTests());
    }

    @Override
    public void onFinish(ITestContext testContext){
        try {
            results.write();
            results.writeToCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
