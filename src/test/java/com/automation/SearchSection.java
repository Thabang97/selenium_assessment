package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchSection {

// Method for Searching the record
	@Test(priority = 17)

	public void click_search() throws InterruptedException {
		Thread.sleep(2000);
		Config.driver.findElement(By.name("searchSystemUser[userName]")).clear();
		Config.driver.findElement(By.name("searchSystemUser[userName]")).sendKeys(Inputs.username);

		Config.driver.findElement(By.id("searchBtn")).click();
	}

	// Verify if usernames are matching
	@Test(priority = 18)

	public void validate_username() {

		Config.test = Config.extent.createTest("Validate if usernames are matching", "Verify if usernames are matching");

		WebElement user_table = Config.driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a"));


		if (user_table.getText().equalsIgnoreCase(Inputs.username)) {

			Config.test_result = true;
			Config.output = "Usernames are matching";
		}
		else {

			Config.test_result = false;
			Config.output = "Usernames are NOT matching"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}

	
// Verify if employee name is Alice Duval
	@Test(priority = 19)

	public void validate_employeeName() throws InterruptedException {

		Config.test = Config.extent.createTest("Validate employee name", "Verify if employee name is Alice Duval");
		
		// Identifying a web element by xpath locator
		Thread.sleep(2000);
		WebElement emp_table = Config.driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[4]"));


		if (emp_table.getText().equalsIgnoreCase("Alice Duval")) {

			Config.test_result = true;
			Config.output = "employee names are matching";
		}
		else {

			Config.test_result = false;
			Config.output = "employee names are NOT matching"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}

	// Verify if status is enabled
	@Test(priority = 20)

	public void validate_status() {

		Config.test = Config.extent.createTest("Validate if status is enabled", "Verify if status is enabled");

		//  Identifying a web element by xpath locator
		WebElement status_table = Config.driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[5]"));


		if (status_table.getText().equalsIgnoreCase(Inputs.status)) {

			Config.test_result = true;
			Config.output = "status is enabled";
		}
		else {

			Config.test_result = false;
			Config.output = "status is NOT enabled"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}	
}
