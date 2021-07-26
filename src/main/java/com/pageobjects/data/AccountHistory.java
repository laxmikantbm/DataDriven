package com.pageobjects.data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountHistory {
public WebDriver driver;
	
By signout = By.xpath("//font[contains(text(),'Sign Off')]");	
	
	
	public AccountHistory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public void availableBalance() {
		
	List<WebElement> colsWithData=driver.findElements(By.xpath("//tbody/tr[1]/td[1]/table[1]/tbody/tr[4]/td[2]"));
    
    for(int i=0;i<colsWithData.size();i++) {
    	System.out.println(colsWithData.get(i).getText());
 	   Assert.assertFalse(colsWithData.get(i).getText().isEmpty());
    }
	}

    public void electricBill() {
    	
    	List<WebElement> colsWithData1=driver.findElements(By.xpath("//div[@id='debits']/table/tbody/tr[3]/td[4]"));
        
        for(int i=0;i<colsWithData1.size();i++) {
        	System.out.println(colsWithData1.get(i).getText());
     	   Assert.assertEquals(colsWithData1.get(i).getText(),"45.25");
        }
    	
    }
    
    public void user_logout() {
		driver.findElement(signout).click();
	}

  }
