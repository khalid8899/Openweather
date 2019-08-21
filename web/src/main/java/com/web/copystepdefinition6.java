package com.web;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class copystepdefinition6 {
private Logger log = Logger.getLogger(copystepdefinition6.class.getName());
protected WebDriver driver;
private pageObjectClass pageObject;

@Before
public void setDriver()
{
	System.setProperty("webdriver.chrome.driver","C:\\Components\\chromedriver_win32\\chromedriver.exe");
	// Initialize browser
	driver=new ChromeDriver();
	
}

@Given("^Enter Below Details$")
public void Enter_Below_Details(DataTable table) throws Throwable
{
	try {
		Thread.sleep(2000);
		List<Map<String, String>> data = table.asMaps(String.class,String.class);
		Map<String, String> cucumberRow = data.get(0);
		Thread.sleep(3000);
		pageObject = new pageObjectClass(driver);
		pageObject.EnterDetails(cucumberRow);
	    }
		
	 catch(Exception e)
	{
		Assert.fail(e.getMessage());
	 }

}

/*@And("^Enter_Search_Details as \"([^\"]*)\"$")
public void search_details(String opt) throws Throwable
{
	try {
		Thread.sleep(2000);
		pageObject = new pageObjectClass(driver);
		pageObject.searchDetails(opt);
	    }
		
	 catch(Exception e)
	{
		//Assert.fail(e.getMessage());
	 }
	
}*/

	@When("^User is on home page$")
	public void user_homePage()
	{
		try{
			pageObject = new pageObjectClass(driver);
			pageObject.userhomePage();
		}
		catch (Exception e) {
			
		//	Assert.fail(e.getMessage());
		}
	}
	
	@Given("^Navigate to openweathermap$")
	public void navigat_to_openweathermap()
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.navigateToWeatherMap();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	
	@And("^Validate below details$")
	public void validate_below_details(DataTable table) throws Throwable
	{
		try {
			Thread.sleep(2000);
		//	List<Map<String, String>> data = table.asMaps(String.class,String.class);
			List<List<String>> data = table.asLists(String.class);
		//	Map<String, String> cucumberRow = data.get(0);
			Thread.sleep(3000);
			pageObject = new pageObjectClass(driver);
			pageObject.validateWeatherFields(data);
		    }
		 catch(Exception e)
			{
		//	Assert.fail(e.getMessage());
			}
	}

	
	
	@And("^Validate UI Fields$")
	public void validate_UI_Fields()
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.validateUIFields();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Enter_City_name as \"([^\"]*)\"$")
	public void enterCityName(String City)
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.enterCityName(City);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Click_Search_Weather_Btn$")
	public void searchWeather()
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.clkSearchWeather();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Validate_Website_Suggestion as \"([^\"]*)\"$")
	public void checkSearchResult(String result)
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.checkSearchResult(result);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	
	@And("^Check_City_temp$")
	public void checkCityTemp()
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.checkCityTemp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	@And("^Connect to WeatherAPI$")
	public void connectWeatherAPI()
	{
		try
		{
			pageObject = new pageObjectClass(driver);
			pageObject.connectWeatherAPI();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@When("^Check_Registration_Details$")
	public void Check_Registration_Details()
	{
		try{
			pageObject = new pageObjectClass(driver);
			pageObject.Check_Registration_Details();
		}
		catch (Exception e) {
			
		//	Assert.fail(e.getMessage());
		}
	}
	
	
	@After
	public void closebrowser()
	{
		driver.quit();
		System.out.println("browser closed successfully");
	}
	
	
	
}







