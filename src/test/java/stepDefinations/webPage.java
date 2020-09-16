package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import container.browserIntialize;
import container.extentReportUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.launchPage;
import pageObjects.weatherPage;

public class webPage extends browserIntialize {

	public ExtentTest Method;
	public ExtentTest logger;
	public ExtentReports extent;
	public launchPage launchClass;
	public weatherPage weatherClass;

	@Given("^Launch NDTV web Page$")
	public void launch_ndtv_web_page() throws Throwable {
		try {
			extentReportUtil.Method = extentReportUtil.extent.createTest(Scenario.class, "WebPage Automate Scenario");
			extentReportUtil.logger = extentReportUtil.Method.createNode("Launch NDTV Web Page");
			driver = InitializeDriver();

			driver.get(testURL);
			extentReportUtil.logger.log(Status.INFO, "Browser Launched With URL");

			extentReportUtil.logger.log(Status.INFO,
					"Title: " + driver.getTitle() + " Launched URL: " + driver.getCurrentUrl());

			extentReportUtil.logger.assignCategory("WebPage Automate Scenario");
			extentReportUtil.logger.log(Status.PASS,
					MarkupHelper.createLabel("Launch App login page method", ExtentColor.GREEN));

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("WebPage Automate Scenario");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper
					.createLabel("WebPage Automate Scenario method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}
	}

	@When("^Reach the weather section$")
	public void reach_the_weather_section() throws Throwable {
		try {
			extentReportUtil.logger = extentReportUtil.Method.createNode("Reach the weather section");
			launchClass = new launchPage(driver);

			launchClass.subMenu().click();
			extentReportUtil.logger.log(Status.INFO, "Clicked on sub menu");
			launchClass.weatherLink().click();
			extentReportUtil.logger.log(Status.INFO, "Clicked on wether link");

			extentReportUtil.logger.assignCategory("Reach the weather section");
			extentReportUtil.logger.log(Status.PASS,
					MarkupHelper.createLabel("Reach the weather section", ExtentColor.GREEN));

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("Reach the weather section");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper
					.createLabel("Reach the weather section method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}
	}

	@And("^Use the 'Pin your city' section, Select Bangalore city$")
	public void use_the_pin_your_city_section_select_bangalore_city() throws Throwable {
		try {
			extentReportUtil.logger = extentReportUtil.Method
					.createNode("Use the 'Pin your city' section, Select Bangalore city");

			weatherClass = new weatherPage(driver);
			weatherClass.searchBox().click();
			extentReportUtil.logger.log(Status.INFO, "Clicked on Search text field");

			weatherClass.searchBox().sendKeys(cityName);
			weatherClass.searchBox().sendKeys(Keys.ENTER);
			extentReportUtil.logger.log(Status.INFO, cityName + " city name entered");

			if (weatherClass.checkBox(cityName).isSelected() == false)
				weatherClass.checkBox(cityName).click();
			extentReportUtil.logger.log(Status.INFO, "Check box validated and its set to true");

			extentReportUtil.logger.assignCategory("Use the 'Pin your city' section, Select Bangalore city");
			extentReportUtil.logger.log(Status.PASS, MarkupHelper
					.createLabel("Use the 'Pin your city' section, Select Bangalore city", ExtentColor.GREEN));

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("Use the 'Pin your city' section, Select Bangalore city");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper.createLabel(
					"Use the 'Pin your city' section, Select Bangalore city method Failed becoz of below reason",
					ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}
	}

	@Then("^Store city with temperature information$")
	public void store_city_with_temperature_information() throws Throwable {
		try {
			extentReportUtil.logger = extentReportUtil.Method.createNode("Store city with temperature information");

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("Store city with temperature information");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper.createLabel(
					"Store city with temperature information method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}
	}

}
