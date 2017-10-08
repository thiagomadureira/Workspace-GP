package pages;

import org.openqa.selenium.WebDriver;

public class BettingSitePage extends BasePage {
	
	public BettingSitePage(WebDriver driver) {
		super(driver);
	}

	
	public BettingSitePage openSite() {
		driver.navigate().to("http://sports.williamhill.com/betting/en-gb");
		return new BettingSitePage(driver);
	}
	
}
