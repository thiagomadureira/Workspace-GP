package com.gp.test.gp_test;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BettingSitePage;
import pages.BettingSitePageMobile;
import pages.PlaceBetPage;
import pages.PlaceBetPageMobile;
import pages.VerifyOddsPage;
import pages.VerifyOddsPageMobile;

public class BettingStepsMobile {

	WebDriver driver = Functions.createChromeDriverMobile();
	BettingSitePage openSite;
	PlaceBetPage placeBet;
	VerifyOddsPage returnValue;
	private static String homeTeam;
	private static String awayTeam;
	private static String betValue;

	BettingSitePageMobile openSiteMobile;
	PlaceBetPageMobile placeBetMobile;
	VerifyOddsPageMobile returnValueMobile;

	@Given("^Open ChromeMobile and go to URL$")
	public void Open_Chrome_and_go_to_URL() throws Throwable {

		openSiteMobile = new BettingSitePageMobile(driver);
		openSiteMobile.openSiteMobile();

	}

	@When("^Choose Home Team \"([^\"]*)\" and Away Team \"([^\"]*)\" on Mobile Device$")
	public void choose_Home_Team_and_Away_Team_on_Mobile_Device(String arg1, String arg2) throws Throwable {

		homeTeam = arg1;
		awayTeam = arg2;

	}

	@When("^Choose Football Event and Place a Bet \"([^\"]*)\" on Mobile Device$")
	public void choose_Football_Event_and_Place_a_Bet_on_Mobile_Device(String arg1) throws Throwable {

		betValue = arg1;
		placeBetMobile = new PlaceBetPageMobile(driver);
		placeBetMobile.placeBetMobile(homeTeam, awayTeam, betValue);

	}
	
	 @Then("^Verify Stakes on Mobile Device$")
	 public void Verify_Stakes_on_Mobile_Device() throws Throwable {
	
	 returnValueMobile = new VerifyOddsPageMobile(driver);
	 returnValueMobile.assertReturnValueMobile(betValue);
	
	 }

}
