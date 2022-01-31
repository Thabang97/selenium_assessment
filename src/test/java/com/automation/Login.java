package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Using the keyword extends to inherit from Config class
public class Login extends Config {
	@Test(priority = 2)
	public void login() {
		
		// Entering username and password to log in
		Config.driver.findElement(By.name(Locators.uname)).clear();
		Config.driver.findElement(By.name(Locators.uname)).sendKeys(Inputs.uname);
		Config.driver.findElement(By.name(Locators.password)).clear();
		Config.driver.findElement(By.name(Locators.password)).sendKeys(Inputs.password);
		Config.driver.findElement(By.name("Submit")).click();
		

	}

	@Test(priority = 3)
	public void Valid_url() {

		// creating a test to validate if URL has dashboard
		Config.test = Config.extent.createTest("Validate URL", "checking the presence of keyword Dashboard in the URL");
		if (Config.driver.getCurrentUrl().contains("dashboard")){

			Config.test_result = true;
			Config.output = "url contains dashboard";  
		}
		else {
			Config.test_result = false;
			Config.output = "url does not contain dashboard"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);  
	}

	// Check if the Admin Tap is one of the taps
	@Test(priority = 4)
	public void check_admin() {
		Config.test = Config.extent.createTest("check admin tap", "checking the presence of admin tap");

		// Identifying a web element by linktext locator
		WebElement admin_tab = Config.driver.findElement(By.linkText("Admin"));

		//checking if Admin Tab is Displayed 
		if(admin_tab.isDisplayed()) {
		Config.test.pass("Admin tab is displayed");
		Config.logger.info("Test Passed. admin tab is available");
		}
	}

	// Checking if the welcome admin is Displayed
	@Test(priority = 5)

	public void check_welcome() {

		//Test Case And Description
		Config.test = Config.extent.createTest("Welcome Admin should display at right panel", "Validate that welcome Admin should display at right panel");



		// Identifying a web element by id locator
		WebElement welcome_admin = Config.driver.findElement(By.id("welcome"));



		//checking if welcome admin Tab is Displayed at Right Panel 
		if(welcome_admin.isDisplayed()) {
			Config.test.pass("welcome Admin is displayed");
			Config.logger.info("Test Passed");
		}
	}
}


