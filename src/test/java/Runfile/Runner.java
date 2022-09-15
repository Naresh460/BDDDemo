package Runfile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "D:\\Projects\\BDDproject\\Features\\AddEmployee.feature",
	glue = {"com.stepdefination"}	,
	monochrome = true,
			plugin = {"html:target/HTML.html"} ,
	dryRun=false
	 
		
		)

public class Runner {

	
}
