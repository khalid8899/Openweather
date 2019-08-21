package com.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Iterator;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pageObjectClass {
	protected WebDriver driver;
    static Logger log = Logger.getLogger(pageObjectClass.class);
	
	public pageObjectClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//facebook
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='reg_email_confirmation__']")
	private WebElement confirmemailField;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	private WebElement passwordField;
	
	@FindBy(xpath="//select[@name='birthday_day']")
	private WebElement birthdayField;
	
	@FindBy(xpath="//option[@value='26']")
	private WebElement selectDate;
	
	@FindBy(xpath="//font[text()='Dec']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//font[text()='1993']/../..")
	private WebElement selectyear;
	
	@FindBy(xpath="//select[@name='birthday_month']")
	private WebElement birthdaymonthField;
	
	@FindBy(xpath="//select[@name='birthday_year']")
	private WebElement birthdayyearField;
	
	@FindBy(xpath="(//input[@name='sex'])[2]")
	private WebElement genderField;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement signUpBtn;
	
	
	//
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//li[contains(@class,'nav__item')]")
	private List<WebElement> navigationItems;
	
	@FindBy(xpath="//input[@placeholder='Your city name']")
	private WebElement cityNameField;

	@FindBy(xpath="//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath="//button[text()='  Current location']")
	private WebElement currentLocationlk;
	
	@FindBy(xpath="//a[text()=' Sign In']")
	private WebElement signinBtn;
	
	@FindBy(xpath="//a[text()=' Sign Up']")
	private WebElement signupBtn;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement alertmsg;
	
	@FindBy(xpath="(//div[@class='tab-pane active']//following-sibling::p)[1]")
	private WebElement tempDetailsField;
	


	public void userhomePage() throws InterruptedException
	{
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		log.info("aa");
		System.out.println("Current title" +driver.getTitle());
		
	}

	public void EnterDetails(Map<String, String> cucumberRow) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(cucumberRow.get("firstName").toString());
		
		wait.until(ExpectedConditions.visibilityOf(lastname));
		lastname.sendKeys(cucumberRow.get("LastName").toString());
		
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.sendKeys(cucumberRow.get("Email Address").toString());
		
		wait.until(ExpectedConditions.visibilityOf(confirmemailField));
		confirmemailField.sendKeys(cucumberRow.get("Re-enter email Address").toString());
		
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(cucumberRow.get("Password").toString());
		Thread.sleep(2000);
		//select bdaee
	//	Select s=new Select(birthdayField);
	//	s.selectByValue("26");
		birthdayField.click();
		Thread.sleep(2000);
		selectDate.click();
		Thread.sleep(3000);
		//Select s1=new Select(birthdaymonthField);
		//s1.selectByValue("Dec");
		//birthdaymonthField.click();
		Thread.sleep(30000);
		//selectMonth.click();
		Thread.sleep(2000);
		//Select s2=new Select(birthdayyearField);
		//s2.selectByValue("1993");
	//	birthdayyearField.click();
		Thread.sleep(2000);
	//	selectyear.click();
		Thread.sleep(2000);
		//select gender
		genderField.click();
		Thread.sleep(4000);
		//click on signup btn
		signUpBtn.click();
		Thread.sleep(10000);
		System.out.println("signup btn click");
		
		
	}

	public void Check_Registration_Details() {
		if(driver.getTitle().equalsIgnoreCase("Facebook – log in or sign up"))
		{
			System.out.println("Test case pass ,"+"user is on:"+driver.getTitle()+"page");
		}
		else
		{
			Assert.fail("Registration is successful ,user is on main page");
			
		}
		
	}
	//dynmic wait function
	public void waitForElementVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		log.debug("Inside the waitforelementvisible  method");
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void navigateToWeatherMap() throws InterruptedException {
		Thread.sleep(2000);
	    driver.get("https://openweathermap.org/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//log.info("Current title is:" +driver.getTitle());
		//System.out.println("Current title is:" +driver.getCurrentUrl());
		
	}

	public void validateWeatherFields(List<List<String>> data) {
		//getting navigation items from UI
		List<WebElement> totalItems=driver.findElements(By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[contains(@class,'nav__item')]"));
		System.out.println("Toal navigation item is:"+totalItems.size());
		//check all navigation fields
		if (totalItems.size() > 0)
		{
			int i=0;
			for(WebElement element: totalItems)
			{ 	
				while(i<totalItems.size())
				{
			//  Validating UI items from Datatable items
				String itemFromUI=element.getText();
				String itemFromDT=data.get(1).get(i);
				if(itemFromUI.equalsIgnoreCase(itemFromDT));
				{	
					System.out.println("Item From UI are:"+itemFromUI);
					System.out.println("Item From Datatable"+itemFromDT);
					break;
			    }
				}
				i++;
		    }
			
		}
		
	}

	public void validateUIFields() {
		//check for page title
		try
		{
		String title=driver.getTitle();
		if(title!=null)
		{
		System.out.println("Title of page is:"+title);
		}
		//check for city name input field 
		if(cityNameField!=null)
		{
		System.out.println("cityNameField is present");
		}
		//check for search button
		if(searchBtn!=null)
		{
		System.out.println("SearchBtn is present");
		}
		//check for current location link
		if(currentLocationlk!=null)
		{
		System.out.println("current location link is present");
		}
		//check for signIn Button
		if(signinBtn!=null)
		{
		System.out.println("signinBtn is present");
		}
		//check for signUp Button
		if(signupBtn!=null)
		{
		System.out.println("signupBtn is present");
		}
		}
		catch(Exception e)
		{
		Assert.fail();
		}
	}

	public void enterCityName(String city) {
		try
		{
		//enter city name 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		waitForElementVisible(cityNameField);
		System.out.println("city is:"+city);
		cityNameField.sendKeys(city);
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
	}

	public void clkSearchWeather() {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		waitForElementVisible(searchBtn);
		searchBtn.click();
		}
		catch(Exception e)
		{
		Assert.fail();	
		}
		
	}

	public void checkSearchResult(String result) {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String Result=alertmsg.getText();
		if(Result.contains(result))
		{
		System.out.println("City details:"+Result);
		}
		}
		catch(Exception e)
		{
		Assert.fail();		
		}
		
	}

	public void checkCityTemp() {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		waitForElementVisible(tempDetailsField);
		if(tempDetailsField!=null)
		{
		System.out.println("Temp details are:"+tempDetailsField.getText());
		}
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
	}

	public void connectWeatherAPI() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//connect to EndPoint 
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae23";
		//create request object
		RequestSpecification request = RestAssured.given();
		//create response object;
		Response response = request.get();
		//check response status
		System.out.println(response.getStatusCode());	
		System.out.println(response.getBody().asString());
		
	}
}
