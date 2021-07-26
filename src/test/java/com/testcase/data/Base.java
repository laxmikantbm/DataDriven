package com.testcase.data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public ExtentReports extent;



	
	@BeforeTest
	@Parameters("browser")
	public void setup(String br)
	{
		if(br.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver","C:\\Software\\Drivers\\geckodriver.exe");
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Software\\Drivers\\chromedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(br.equalsIgnoreCase("ie"))
		{
			//System.setProperty("webdriver.ie.driver","C:\\Software\\Drivers\\IEDriverServer.exe");
			WebDriverManager.iedriver();
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.testfire.net");
		
		

		ExtentSparkReporter reporter = new ExtentSparkReporter("Reports\\report.html");
		reporter.config().setDocumentTitle("Rest Assured");
		reporter.config().setReportName("Data Driven Framework");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Company Name", "Brillio");
		extent.setSystemInfo("Project Name", "Data Driven Framework");
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
