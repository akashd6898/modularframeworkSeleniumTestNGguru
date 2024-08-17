package com.guru99.tests;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;
import com.guru99.utils.ReportUtils;
import com.guru99.utils.ScreeshotUtils;
import commonLibs.Utils.ConfigUtils;
import commonLibs.implementation.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;


public class BaseTests {
    CommonDriver cmnDriver;
    String url;
    String browserType;
    WebDriver driver;
    LoginPage loginPage;
    String currentDirectory;

    Properties configProperty;
    String configFilename;

    String reportFilename;
    ReportUtils reportUtils;

    ScreeshotUtils screenshot;

    @BeforeSuite
    public void preSetup() throws IOException {
        currentDirectory = System.getProperty("user.dir");
        configFilename = currentDirectory+"/config/config.properties";
        reportFilename = currentDirectory+"/reports/guru99TestReport.html";

        configProperty = ConfigUtils.readProperties(configFilename);

        reportUtils = new ReportUtils(reportFilename);//generate report


    }

    @BeforeClass
    public void setup() throws Exception {
        url = configProperty.getProperty("baseURL");
        browserType = configProperty.getProperty("browserType");
        cmnDriver = new CommonDriver(browserType);
        driver = cmnDriver.getDriver();
        loginPage = new LoginPage(driver);
        screenshot = new ScreeshotUtils(driver);
        cmnDriver.navigateToURL(url);
    }

    @AfterMethod
    public  void postTestAction(ITestResult result) throws Exception {
        String testcasename = result.getName();
        long executionTime = System.currentTimeMillis();

        String screenshotFilename = currentDirectory+"/reports/"+ testcasename + executionTime +".jpeg";
        String screenshotName = testcasename + executionTime +".jpeg";

        if (result.getStatus() == ITestResult.FAILURE)
        {
            reportUtils.addtestLog(Status.FAIL, "One or more step failed");
            screenshot.captureAndSaveScreenshot(screenshotFilename);
        }
        screenshot.captureAndSaveScreenshot(screenshotFilename);
        reportUtils.addScreenshotToreport(screenshotName);
    }

    @AfterClass
    public void tearDown()
    {
        cmnDriver.closeAllBrowser();
    }

    @AfterSuite
    public void postTearDown(){//close report
        reportUtils.flushReport();
    }
}
