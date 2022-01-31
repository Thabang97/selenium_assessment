package com.automation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

// Method for filling in details 
public class EnterInfo {
		  @Test(priority = 15)
		  public void enter_info() throws InterruptedException {
			  
			  Select role = new Select(Config.driver.findElement(By.name(Locators.role)));
				role.selectByVisibleText(Inputs.role);
			  Config.driver.findElement(By.name(Locators.emp_name)).clear();
			  Config.driver.findElement(By.name(Locators.emp_name)).sendKeys(Inputs.emp_name); 
			  
			  Config.driver.findElement(By.name(Locators.username)).clear();
			  Config.driver.findElement(By.name(Locators.username)).sendKeys(Inputs.username);
			  
			  Select status = new Select(Config.driver.findElement(By.name(Locators.status)));
				status.selectByVisibleText(Inputs.status);
			  
				
			  
			  Config.driver.findElement(By.name(Locators.pword)).clear();
			  Config.driver.findElement(By.name(Locators.pword)).sendKeys(Inputs.pword);
			  
			  Config.driver.findElement(By.name(Locators.re_pword)).clear();
			  Config.driver.findElement(By.name(Locators.re_pword)).sendKeys(Inputs.re_pword);
			  
			  Thread.sleep(2000);
			  WebElement save = Config.driver.findElement(By.name("btnSave"));
			  save.click();	  
		  }
		  
		  
// Verify Status dropdown is Selected to enable
		  @Test(priority = 16)
		  public void validate_status() {
			  
			  Config.test = Config.extent.createTest("Validate dropdown status", "Verify Status dropdown is Selected to enable.");
				 
			  Select status = new Select(Config.driver.findElement(By.name(Locators.status)));
				if (status.getFirstSelectedOption().getText().equalsIgnoreCase("Enabled")) {

					Config.test_result = true;
					Config.output = "status dropdown is selected to enabled";  
				}
				else {
					Config.test_result = false;
					Config.output = "status dropdown is not selected to enabled"; 
				}
				assertTrue(Config.test_result);
				Config.test.pass(Config.output);
			 
		  }

}
