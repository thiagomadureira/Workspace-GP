package com.gp.test.gp_test;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BettingSitePage;
import pages.PlaceBetPage;
import pages.VerifyOddsPage;

public class BettingSteps {

	WebDriver driver = Functions.createChromeDriver();
	BettingSitePage openSite;
	PlaceBetPage placeBet;
	VerifyOddsPage returnValue;
	private static String homeTeam;
	private static String awayTeam;
	private static String betValue;

	@Given("^Open Chrome and go to URL$")
	public void Open_Chrome_and_go_to_URL() throws Throwable {

		openSite = new BettingSitePage(driver);
		openSite.openSite();

	}

	@When("^Choose Home Team \"([^\"]*)\" and Away Team \"([^\"]*)\"$")
	public static void choose_Home_Team_and_Away_Team(String arg1, String arg2) throws Throwable {

		homeTeam = arg1;
		awayTeam = arg2;

	}

	@When("^Choose Football Event and Place a Bet \"([^\"]*)\"$")
	public void choose_Football_Event_and_Place_a_Bet(String arg1) throws Throwable {

		betValue = arg1;
		placeBet = new PlaceBetPage(driver);
		placeBet.placeBet(homeTeam, awayTeam, betValue);

	}

	@Then("^Verify Stakes$")
	public void Verify_Stakes() throws Throwable {

		returnValue = new VerifyOddsPage(driver);
		returnValue.assertReturnValue(betValue);

	}

}
