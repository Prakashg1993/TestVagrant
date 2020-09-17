package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class launchPage {
	public WebDriver driver;
	public  WebDriverWait EXPwait;
	
	public launchPage(WebDriver driver) {
		this.driver=driver;
		EXPwait = new WebDriverWait(driver, 10);
	}
	
	By subMenu=By.xpath("//a[@id='h_sub_menu']");
	By weatherLink=By.xpath("//a[contains(text(),'WEATHER')]");
	
	
	public WebElement subMenu()
	{
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(subMenu));
		return driver.findElement(subMenu);
	}
	public WebElement weatherLink()
	{
		EXPwait.until(ExpectedConditions.visibilityOfElementLocated(weatherLink));
		return driver.findElement(weatherLink);
	}
}
