package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PlaceBetPageMobile extends BasePage {

	public PlaceBetPageMobile(WebDriver driver) {
		super(driver);
	}

	public PlaceBetPageMobile placeBetMobile(String homeTeam, String awayTeam, String betValue) throws Exception {

		Thread.sleep(5000);

		// Finding the Search Button to Search which game will receive the bet
		WebElement btnSearchMobile = driver.findElement(By.xpath("//*[@id=\"header\"]/section/a[9]/i"));

		btnSearchMobile.click();

		// Search for the football game
		WebElement searchFieldMobile = driver.findElement(By.xpath("//*[@id=\"search-input\"]"));

		searchFieldMobile.sendKeys(homeTeam + " vs " + awayTeam);

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

			// Toggle Bet Slip

			WebElement btnToggleBetSlip = driver.findElement(By.xpath("//*[@id=\"betslip-btn-toolbar\"]/a"));

			btnToggleBetSlip.click();

			// Find the Bet Slip to Place Bet
			WebElement singleBetSlip = driver.findElement(By.xpath("//*[@id=\"bets-container-singles\"]"));

			WebElement betSlipValueField = singleBetSlip.findElement(By.tagName("span"));

			WebElement placeBetValue = betSlipValueField
					.findElement(By.xpath("//input[contains(@class,'stake-input')]"));

			placeBetValue.click();

			WebElement btn0 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[4]/button[2]"));
			WebElement btn1 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[1]/button[1]"));
			WebElement btn2 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[1]/button[2]"));
			WebElement btn3 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[1]/button[3]"));
			WebElement btn4 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[2]/button[1]"));
			WebElement btn5 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[2]/button[2]"));
			WebElement btn6 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[2]/button[3]"));
			WebElement btn7 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[3]/button[1]"));
			WebElement btn8 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[3]/button[2]"));
			WebElement btn9 = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[3]/button[3]"));
			WebElement btnDot = driver.findElement(By.xpath("//*[@id=\"numberpad\"]/div[4]/button[1]"));

			String str = betValue;
			for (int i = 0, n = str.length(); i < n; i++) {
				char c = str.charAt(i);

				String stringValueOf = String.valueOf(c);

				if (stringValueOf.equals("0")) {
					btn0.click();
				} else if (stringValueOf.equals("1")) {
					btn1.click();
				} else if (stringValueOf.equals("2")) {
					btn2.click();
				} else if (stringValueOf.equals("3")) {
					btn3.click();
				} else if (stringValueOf.equals("4")) {
					btn4.click();
				} else if (stringValueOf.equals("5")) {
					btn5.click();
				} else if (stringValueOf.equals("6")) {
					btn6.click();
				} else if (stringValueOf.equals("7")) {
					btn7.click();
				} else if (stringValueOf.equals("8")) {
					btn8.click();
				} else if (stringValueOf.equals("9")) {
					btn9.click();
				} else if (stringValueOf.equals(".")) {
					btnDot.click();
				}

			}


		} catch (NoSuchElementException e) {
			Assert.fail("There are no results for the game " + homeTeam + " vs " + awayTeam);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro = " + e.getMessage());
		} catch (InterruptedException e) {
			Assert.fail("Error Message - " + e.getMessage());
		}

		return new PlaceBetPageMobile(driver);

	}

}
