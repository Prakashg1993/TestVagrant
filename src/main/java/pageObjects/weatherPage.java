package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class weatherPage {

	public WebDriver driver;
	public WebDriverWait EXPwait;

	public weatherPage(WebDriver driver) {
		this.driver = driver;
		EXPwait = new WebDriverWait(driver, 10);
	}

	By searchBox = By.xpath("//input[@id='searchBox']");
	By weatherdetails = By.xpath("//div[@class='leaflet-popup-content']//following-sibling::span");

	public WebElement searchBox() {
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		return driver.findElement(searchBox);
	}

	public WebElement checkBox(String Value) {
		By checkBox = By.xpath("//input[@id='" + Value + "'][@type='checkbox']");
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		return driver.findElement(checkBox);
	}

	public WebElement weatherStatus(String Value) {
		By weatherStatus = By.xpath("//div[contains(text(),'" + Value + "')]");
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(weatherStatus));
		return driver.findElement(weatherStatus);
	}

	public List<WebElement> weatherdetails() {
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(weatherdetails));
		return driver.findElements(weatherdetails);
	}
}
