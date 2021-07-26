package com.pageobjects.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountDetails {
public WebDriver driver;
	
	WebElement account; 
	By goButton = By.id("btnGetAccount");
	
	public AccountDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public void accountDetails() {
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='listAccounts']")));
		dropdown.selectByIndex(1);
		
	}

	public void go() {
		driver.findElement(goButton).click();
	}

}
