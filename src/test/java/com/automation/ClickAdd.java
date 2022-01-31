package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// Clicking the Add button
public class ClickAdd extends Config {
	 @Test(priority = 12)
	  public void clickadd() throws InterruptedException {
		 Thread.sleep(3000);
		 Config.driver.findElement(By.name("btnAdd")).click(); 
	 }
	 
// Validate if Add button URL contains saveSystemUser
	 @Test(priority = 13)
	 
	 public void validate_addbtnUrl() {
		 
		 Config.test = Config.extent.createTest("Validate add button URL", "url should contain saveSystemUser");
		 
			if (Config.driver.getCurrentUrl().contains("saveSystemUser")){

				Config.test_result = true;
				Config.output = "url contains saveSystemUser";  
			}
			else {
				Config.test_result = false;
				Config.output = "url does not contain saveSystemUser"; 
			}
			assertTrue(Config.test_result);
			Config.test.pass(Config.output);
	 }
	 
	 
// Validate if Add User H1 is Displayed 
	 @Test(priority = 14)
		public void validateAdd () { 
			Config.test = Config.extent.createTest("Validate Add User H1", "Add User H1 should display ");
			
			WebElement add_user = Config.driver.findElement(By.id("UserHeading")); 
			
			if(add_user.isDisplayed()) {
				
				Config.test.pass("Add User is displayed");
			}
		} 
	 
	 
		 
		 
}
