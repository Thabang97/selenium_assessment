package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


// Deleting the record from the table of records
public class DeleteRecord {
	
	@Test(priority = 21)

	public void delete_record() throws InterruptedException {
		
	//  Identifying a web element by xpath locator
		WebElement check_box = Config.driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectAll\"]"));
		Thread.sleep(2000);
		  check_box.click();
		  
		  Config.driver.findElement(By.id("btnDelete")).click();
		  Thread.sleep(3000);
		  Config.driver.findElement(By.id("dialogDeleteBtn")).click();
		  
		  
	}

}
