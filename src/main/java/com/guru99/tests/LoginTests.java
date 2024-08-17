package com.guru99.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginTests extends BaseTests{
    @Parameters({"username", "password"})
    @Test
    public void verifyUserLoginWithCorrectCredentials(String username, String password)
    {
        reportUtils.createTestcase("Verify User Login With Correct Credential");
        reportUtils.addtestLog(Status.INFO, "Performing login");

        loginPage.loginToApplication(username, password); //to pass username & pwd & to use other features, it is run through xml file

        String expectedTitle = "Guru99 Bank Home Page";
        String actualTitle = cmnDriver.currentPageTitle();

        reportUtils.addtestLog(Status.INFO, "Comparing expected and actual title");

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
