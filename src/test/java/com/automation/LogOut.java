package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


// Clicking the welcome and log out buttons
public class LogOut {


	@Test(priority = 23)

	public void logout() throws InterruptedException {

		Config.driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		Config.driver.findElement(By.linkText("Logout")).click();
		
	}

	
	// Validate URL for landing/home page(login)
	@Test(priority = 24)

	public void validate_url_landingPage() throws InterruptedException {
		Thread.sleep(2000);
		Config.test = Config.extent.createTest("Validate URL(login) for landing page", "Validate URL for landing page");

		if (Config.driver.getCurrentUrl().contains("login")){

			Config.test_result = true;
			Config.output = "url contains login";  
		}
		else {
			Config.test_result = false;
			Config.output = "url does not contain login"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}

	// Validate URL for landing/home  page(OrangeHRM)
	@Test(priority = 25)

	public void validate_url_landingPage2() {

		Config.test = Config.extent.createTest("Validate URL(OrangeHRM) for landing page", "Validate URL for landing page");

		if (Config.driver.getCurrentUrl().contains("OrangeHRM")){

			Config.test_result = true;
			Config.output = "url contains OrangeHRM";  
		}
		else {
			Config.test_result = false;
			Config.output = "url does not contain OrangeHRM"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}

}
