package com.pageobjects.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

public WebDriver driver;
	
	

	By username = By.id("uid");
	By password = By.id("passw");
	By clicklogin = By.xpath("//input[@name='btnSubmit']");
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}



	public void getEmail(String StrUsername)
	{
		driver.findElement(username).sendKeys(StrUsername);
	}
	

	public void getPassword(String StrPassword)
	{
		driver.findElement(password).sendKeys(StrPassword);
	}
	
	public void clickLogin()
	{
		driver.findElement(clicklogin).click();
	}
	

}
