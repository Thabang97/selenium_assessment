package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Opening the Admin Tap
public class AdminTap extends Config{

	@Test(priority = 6)
	public void admintap() throws InterruptedException {
		Thread.sleep(2000);
		Config.driver.findElement(By.linkText("Admin")).click();

	}
// validate url for admin
	
	@Test(priority = 7)
	public void Validate_adminUrl() {

		Config.test = Config.extent.createTest("Validate admin tap URL", "url should contain admin/viewSystemUsers");


		if (Config.driver.getCurrentUrl().contains("admin/viewSystemUsers")){

			Config.test_result = true;
			Config.output = "url contains admin/viewSystemUsers";  
		}
		else {
			Config.test_result = false;
			Config.output = "url does not contain admin/viewSystemUsers"; 
		}
		assertTrue(Config.test_result);
		Config.test.pass(Config.output);
	}	
	
// validate add button 
	
	@Test(priority = 8)
	public void validateAdd () { 
		Config.test = Config.extent.createTest("Add button should be displayed", "Validate that add button is displayed");
		
		WebElement add = Config.driver.findElement(By.name("btnAdd")); 
		
		if(add.isDisplayed()) {
			
			Config.test.pass("Add button is displayed");
		}
	} 
	
	// validate Delete button
	@Test (priority = 9)
	public void validateDelete() { 
		Config.test = Config.extent.createTest("Delete button should be displayed", "Validate that delete button is displayed"); 
		
		WebElement delete = Config.driver.findElement(By.id("btnDelete")); 
		if(delete.isDisplayed()) {
			
			Config.test.pass("Delete button is displayed");
		}
	} 
	
	// validate search button
	@Test(priority = 10)
	public void validateSearch() {
		Config.test = Config.extent.createTest("Search button should be displayed", "Validate that search button is displayed"); 
		
		WebElement search = Config.driver.findElement(By.id("searchBtn")); 
		
		if(search.isDisplayed()) {
			Config.test.pass("Search button is displayed");
		}
	} 
	
	// validate Reset button
	@Test(priority = 11)
	public void validateReset() { 
		Config.test = Config.extent.createTest("Reset button should be displayed", "Validate that reset button is displayed"); 
		
		WebElement reset = Config.driver.findElement(By.id("resetBtn")); 
		
		if(reset.isDisplayed()) {
			Config.test.pass("Reset button is displayed");
		}
	}


}




