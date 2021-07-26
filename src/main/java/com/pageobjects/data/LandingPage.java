package com.pageobjects.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	
	By signin=By.xpath("//font[contains(text(),'Sign In')]");
	
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	public void getLogin()
	{
		 driver.findElement(signin).click();
		 
	}

}
