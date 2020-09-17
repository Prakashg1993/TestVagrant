package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.parsing.Parser;
import io.restassured.specification.ResponseSpecification;
import pojo.weatherReport;

import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import container.extentReportUtil;

public class apiCall extends apiInitialze {
	public ResponseSpecification requestvalue;
	public static weatherReport Resp;

	@Given("^set api call for weather$")
	public void set_api_call_for_weather() throws Throwable {
		try {
			extentReportUtil.method = extentReportUtil.extent.createTest(Scenario.class,
					"Get weather details for City-API ");
			extentReportUtil.logger = extentReportUtil.method.createNode("set api call for weather");

			requestvalue = given().log().all().spec(requestinitializer()).expect().defaultParser(Parser.JSON);

			extentReportUtil.logger.assignCategory("set api call for weather");
			extentReportUtil.logger.log(Status.PASS,
					MarkupHelper.createLabel("set api call for weather method", ExtentColor.GREEN));

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("set api call for weather");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper
					.createLabel("Launch NDTV web Page method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}

	}

	@When("^hit the api call$")
	public void hit_the_api_call() throws Throwable {
		try {
			extentReportUtil.logger = extentReportUtil.method.createNode("hit the api call");

			Resp = requestvalue.when().get("/data/2.5/weather").as(weatherReport.class);

			extentReportUtil.logger.assignCategory("hit the api call");
			extentReportUtil.logger.log(Status.PASS,
					MarkupHelper.createLabel("hit the api call method", ExtentColor.GREEN));

		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("hit the api call");
			extentReportUtil.logger.log(Status.ERROR,
					MarkupHelper.createLabel("hit the api call method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}

	}

	@Then("^get the responce into object class$")
	public void get_the_responce_into_object_class() throws Throwable {

		try {
			extentReportUtil.logger = extentReportUtil.method.createNode("get the responce into object class");

			extentReportUtil.logger.log(Status.INFO, "Temerature in Kelvin: " + Resp.getMain().getTemp());
			for (int i = 0; i < Resp.getWeather().size(); i++) {
				extentReportUtil.logger.log(Status.INFO,
						"Temerature in Descr: " + Resp.getWeather().get(i).getDescription());
				extentReportUtil.logger.log(Status.INFO, "Temerature in Icon: " + Resp.getWeather().get(i).getIcon());
				extentReportUtil.logger.log(Status.INFO, "Temerature in ID: " + Resp.getWeather().get(i).getId());
				extentReportUtil.logger.log(Status.INFO, "Temerature in Main: " + Resp.getWeather().get(i).getMain());
			}
			extentReportUtil.logger.assignCategory("get the responce into object class");
		} catch (Exception e) {
			extentReportUtil.logger.assignCategory("get the responce into object class");
			extentReportUtil.logger.log(Status.ERROR, MarkupHelper.createLabel(
					"get the responce into object class method Failed becoz of below reason", ExtentColor.RED));
			extentReportUtil.ExtentReportScreenshot(e, extentReportUtil.logger, driver);
		}
	}
}
