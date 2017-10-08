package com.gp.test.gp_test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = { "pretty",
		"html:target/mobile/cucumber-html-report","json:target/mobile/cucumber-report.json" }, features = "src/test/java/resources/mobile/BettingStepsMobile.feature")
public class RunnerMobile {

}
