package com.guru99.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

    ExtentSparkReporter htmlReport;//html report
    ExtentReports extentReports; //generate report
    ExtentTest extentTest; //create testcase

    public ReportUtils(String htmlReportFilename) {
        htmlReportFilename = htmlReportFilename.trim();
        htmlReport = new ExtentSparkReporter(htmlReportFilename);

        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReport);
    }

        public void createTestcase(String testcaseName)
        {
            extentTest = extentReports.createTest(testcaseName);
        }

        public void addtestLog(Status status, String comment)
        {
            extentTest.log(status, comment);
        }

        public void addScreenshotToreport(String filename) throws Exception
        {
            extentTest.addScreenCaptureFromPath(filename);
        }

        public void flushReport()
        {
            extentReports.flush();// close the report
        }
}
