package com.web;
import java.io.File;
import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(plugin ={ "pretty",
	"json:target/json/chrome/cucumber.json",
	"html:target/html/chrome" },
		 features = "feature",glue = "com.web", tags = {
		"@TC_004"},
         monochrome = true
)

public class copyRunnerClass6  extends AbstractTestNGCucumberTests

//public class copyRunnerClass4 
{
 
}


