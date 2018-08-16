package com.qa.cucumberpractice.cucumberpractice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefs {
	
	WebDriver driver;
	String url = "ft";
	public ExtentReports report;
	public ExtentTest test;

	@Before
	public void setup(){
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\GoogleSearch.html", true); 
		test = report.startTest("Verify accordion open"); 
		test.log(LogStatus.INFO, "Started the driver");
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^I go to www\\.google\\.com$")
	public void i_go_to_www_google_com() {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "Went to the web page");
		driver.get("https://www.google.com/");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
	   googleHome page = PageFactory.initElements(driver, googleHome.class);
	   page.sendKeysToSearch(arg1);
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()  {
	    // Write code here that turns the phrase above into concrete actions
		
		//test.flush();
		
		test.log(LogStatus.PASS, "Started the driver");
		
		report.endTest(test);		
		
		report.flush();
		
		assertEquals("Dogs", driver.getCurrentUrl());
		
		//assertTrue(url.equals(driver.getCurrentUrl()));
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	

}
