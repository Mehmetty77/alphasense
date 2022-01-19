package com.ali.tests.smoketest;
import com.ali.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClassUsingListeners {
    @BeforeClass
    public void beforeClass() {

    }


    @Test
    public void testSuccessful(){
        System.out.println("executing successful test method");
        Driver.getDriver().get("https://www.google.com");
    }

    @Test
    public void testFailed(){
        System.out.println("executing failed test method");
        Assert.fail("Executing Failed Test Method");
    }

    @Test
    public void testSkipped(){
        System.out.println("executing skipped test method");
        throw new SkipException("Executing Skipped Test Method");

    }

    @AfterClass
    public void afterClass() {
        Driver.closeDriver();
    }



}