package com.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Config {

	//global variables
		static ExtentReports extent;
		static WebDriver driver;
		static ExtentTest test;
		static Logger logger;
		static String output;
		static boolean test_result;
		
		@BeforeSuite
		public void setup() {
			//starts reports
			ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/Spark.html");



			//create extent reports and attach reporters
			extent = new ExtentReports();
			extent.attachReporter(spark);

			// launch browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			//logger
			logger = LogManager.getLogger(PageTitle.class);
			logger = LogManager.getLogger(Login.class);

		}
		@AfterMethod
		public void check_result(ITestResult result) {
			
			if (result.getStatus() == ITestResult.FAILURE) {
				test.fail(output);
			}
		}
		
		@AfterSuite
		public void flushing() {
			//calling flush writes everything to the log file
			extent.flush();
		}
		
}
