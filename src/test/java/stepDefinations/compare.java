package stepDefinations;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import container.extentReportUtil;
import cucumber.api.java.en.Given;
import pageObjects.weatherPage;
import pojo.weather;
import pojo.weatherReport;

public class compare {

	public static double APItemp;
	public static double webTemp;
	public static double variance;

	@Given("^Copmare Web object temp and Api object temp$")
	public void copmare_web_object_temp_and_api_object_temp() throws Throwable {
		extentReportUtil.method = extentReportUtil.extent.createTest(Scenario.class, "Compare two object value");
		extentReportUtil.logger = extentReportUtil.method.createNode("Copmare Web object temp and Api object temp");

		apiCall apiweather = new apiCall();
		webPage webweather = new webPage();

		APItemp = Double.parseDouble(apiweather.Resp.getMain().getTemp());
		webTemp = Double.parseDouble(webweather.weatherValues.get("Temp in Degrees"));
		APItemp = tempConv(APItemp);
		if (variance <= 2) {
			extentReportUtil.logger.log(Status.INFO,"With some variance temp is same from API and Web");
			extentReportUtil.logger.log(Status.PASS,
					MarkupHelper.createLabel("Copmare Web object temp and Api object temp method", ExtentColor.GREEN));

		} else {
			extentReportUtil.logger.log(Status.INFO,"Temp value is not matching");
			extentReportUtil.logger.log(Status.ERROR,
					MarkupHelper.createLabel(
							"Copmare Web object temp and Api object temp method Failed becoz of below reason",
							ExtentColor.RED));
		}
		extentReportUtil.logger.assignCategory("Copmare Web object temp and Api object temp");
	}

	public static double tempConv(double aPItemp2) {

		APItemp = aPItemp2 - 273.15;
		if (webTemp > APItemp)
			variance = webTemp - APItemp;
		if (webTemp < APItemp)
			variance = APItemp - webTemp;
		return APItemp;

	}

}
