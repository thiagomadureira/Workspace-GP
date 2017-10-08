package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PlaceBetPage extends BasePage {

	public PlaceBetPage(WebDriver driver) {
		super(driver);
	}

	public PlaceBetPage placeBet(String homeTeam, String awayTeam, String betValue) throws Exception {

		Thread.sleep(5000);

		// Finding the Search Button to Search which game will receive the bet
		WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"nav-Search\"]/a"));

		btnSearch.click();

		// Search for the football game
		WebElement searchField = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));

		searchField.sendKeys(homeTeam + " vs " + awayTeam);

		try {

			// Get Event that returned from the search query
			WebElement event = driver.findElement(By.xpath("//*[@id=\"search-overlay\"]/div/div[2]/div[2]"));

			Thread.sleep(5000);

			WebElement BetOptions = event.findElement(By.className("btmarket__selection"));

			// Place bet on the Home Team
			WebElement placeBetHomeWins = BetOptions.findElement(By.xpath("//*[@data-name=\'" + homeTeam + "']"));
			placeBetHomeWins.click();

			// Close the Search Screen
			WebElement btnSearchClose = driver.findElement(By.xpath("//*[@id=\"search-close\"]"));

			btnSearchClose.click();

			Thread.sleep(5000);

			// Find the Bet Slip to Place Bet
			WebElement singleBetSlip = driver.findElement(By.xpath("//*[@id=\"bets-container-singles\"]"));

			WebElement betSlipValueField = singleBetSlip.findElement(By.tagName("span"));

			WebElement placeBetValue = betSlipValueField
					.findElement(By.xpath("//input[contains(@class,'stake-input')]"));

			placeBetValue.click();
			placeBetValue.sendKeys(betValue);

		} catch (NoSuchElementException e) {
			Assert.fail("There are no results for the game " + homeTeam + " vs " + awayTeam);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro = " + e.getMessage());
		} catch (InterruptedException e) {
			Assert.fail("Error Message - " + e.getMessage());
		}

		return new PlaceBetPage(driver);

	}

}
