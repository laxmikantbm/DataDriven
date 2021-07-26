package com.testcase.data;

import java.io.FileInputStream;
import java.io.IOException;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pageobjects.data.AccountDetails;
import com.pageobjects.data.AccountHistory;
import com.pageobjects.data.LandingPage;
import com.pageobjects.data.LoginPage;






public class TestClass extends Base{




	@Test(dataProvider="inputdata",priority=1)
	public void enter_UserDetails(String userName, String password) throws Exception {
		ExtentTest t = extent.createTest("Data Provider");
		
		LandingPage l = new LandingPage(driver);
		l.getLogin();
	    t.info("Login page loaded !");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail(userName);
	   
		lp.getPassword(password);
		 t.info("User Credentials Enterd successfully !");
		lp.clickLogin();
		 t.info("Clicked on Login button");
		
		
		AccountDetails a = new AccountDetails(driver);
		a.accountDetails();
		 
		a.go();
		t.info("Account Details fetched");
		
		AccountHistory ah = new AccountHistory(driver);
		ah.availableBalance();
		t.info("Avilable Balance fetched");
		ah.electricBill();
		t.info("Electric Bills Fetched");
		ah.user_logout();
		t.info("Clicked on Logout button");
		extent.flush();
		}
	

	@DataProvider(name="inputdata")
	public Object [][] getCellData() throws IOException {
		
		// Using Data Provided 
		/*	return new Object[][] 
    	{
            { "admin", "admin" },
            { "jsmith", "demo1234" },
        }; */
		
		// locate excel file
		FileInputStream file = new FileInputStream("./Data/sampledoc.xlsx");
		
		//create workbook instance
		XSSFWorkbook wb=new XSSFWorkbook(file);
		
		//Go to desired sheet
		XSSFSheet s=wb.getSheet("sheet1");
		
		int rowcount = s.getLastRowNum()+1;
		int cellcount=s.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rowcount][cellcount];
		
		for(int i=0;i<rowcount;i++) {
			Row r = s.getRow(i);
			 
		    for(int j=0;j<cellcount;j++) {
		    	Cell c=r.getCell(j);
		    	data[i][j]=c.getStringCellValue();
		    }
		}
		wb.close();
		return data;
	}

	
	
	
}
