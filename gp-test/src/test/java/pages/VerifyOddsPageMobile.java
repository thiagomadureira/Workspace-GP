package pages;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class VerifyOddsPageMobile extends BasePage {

	public VerifyOddsPageMobile(WebDriver driver) {
		super(driver);
	}

	public VerifyOddsPageMobile verifyOdds() throws Exception {

		return new VerifyOddsPageMobile(driver);
	}

	public void assertReturnValueMobile(String betValue) throws Exception {

		String estimatedReturn = null;
		String odds = null;
		String estimatedReturnCalc = null;

		// Find the Odds value and assert that the return value is correct
		WebElement singleBetSlip = driver.findElement(By.xpath("//*[@id=\"bets-container-singles\"]"));

		WebElement betSlipValueField = singleBetSlip.findElement(By.tagName("span"));

		WebElement oddsValue = betSlipValueField.findElement(By.xpath("//span[starts-with(@id,'bet-price')]"));

		WebElement estimatedReturnValue = betSlipValueField
				.findElement(By.xpath("//span[starts-with(@id,'estimated-returns_')]"));

		odds = oddsValue.getAttribute("innerText");

		estimatedReturn = estimatedReturnValue.getAttribute("innerText");

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		estimatedReturnCalc = "(" + odds + "*" + betValue + ")" + "+" + betValue;

		engine.eval(estimatedReturnCalc).toString();


		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		String result = df.format(engine.eval(estimatedReturnCalc));
		
		Assert.assertEquals(estimatedReturn, result);

	}
}
