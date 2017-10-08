package pages;

import org.openqa.selenium.WebDriver;

public class BettingSitePageMobile extends BasePage {
	
	public BettingSitePageMobile(WebDriver driver) {
		super(driver);
	}

	
	public BettingSitePageMobile openSiteMobile() {
		driver.navigate().to("http://sports.williamhill.com/betting/en-gb");
		return new BettingSitePageMobile(driver);
	}
	
}
