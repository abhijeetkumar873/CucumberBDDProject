package org.TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
		
		//for single feature file run
		//features = ".\\Features\\add_Cart.feature",
		
		//for all the feature file in Features folder
		//features = ".\\Features\\",
		
		//for multiple feature file in Features folder
		features = {".\\Features\\add_Cart.feature",".\\Features\\login.feature"},
		glue = {"stepDefination"},
		dryRun = false,
		monochrome = true,
		tags = "@Regression or @Sanity",
		//plugin = {"pretty","junit:target/cucumber-report/reports3.xml"}
		
		//plugin = {"pretty","json:target/cucumber-report/reports2.json"

		plugin = {"pretty","html:target/cucumber-report/reports1.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
public class Run extends AbstractTestNGCucumberTests
{

}
