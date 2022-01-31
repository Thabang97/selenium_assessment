package com.automation;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PageTitle {
	
	// The first test
	@Test(priority = 1)
	
	public void first_test() {
		
		// Creating a test for opening URL
		Config.test = Config.extent.createTest("Open orangeHRM URL", " get the title of the current page.");

		//URL to the website
		Config.driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		String actualTitle = Config.driver.getTitle();
		String expectedTitle = "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);

		Config.test.pass("Test Passed");
	}

	@AfterMethod
	public void EvaluateResult(ITestResult Results) {

		if(Results.getStatus() == ITestResult.FAILURE) {
			Config.test.fail("Test Failed");
			Config.logger.info("Test Failed");
		}
		
	}

	

}
