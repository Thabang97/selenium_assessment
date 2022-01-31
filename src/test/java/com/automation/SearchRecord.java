package com.automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

// Verify that the record is ddeleted
public class SearchRecord {

	
	@Test(priority = 22)

	public void search_deleted() throws InterruptedException {
		Thread.sleep(2000);
		Config.driver.findElement(By.name("searchSystemUser[userName]")).clear();
		Config.driver.findElement(By.name("searchSystemUser[userName]")).sendKeys(Inputs.username);
		
		Config.driver.findElement(By.id("searchBtn")).click();
	}
}
