package com.gp.test.gp_test;

import org.junit.runner.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = { "pretty",
		"html:target/cucumber-html-report", "json:target/cucumber-report.json" }, features = "src/test/java/resources/desktop/BettingSteps.feature")
public class Runner {

}
