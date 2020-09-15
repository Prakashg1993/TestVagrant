package container;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportUtil {

public WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest Method;
	public ExtentTest logger;
	public static String reportLocation = "Screenshots//";
	public ExtentColor color;
	
	public void ExtentReport() {
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\TestReport.html");

		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test Report for Appsian Application");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User Name", "Prakash.G");
		extent.setSystemInfo("OS", "windows server 2008 R2 enterprice");
	}

	public void ExtentReportScreenshot(Throwable throwable, ExtentTest Logger, WebDriver driver) throws IOException {
		this.driver=driver;
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(reportLocation + timestamp + ".png"));
		Logger.fail(throwable).addScreenCaptureFromPath(reportLocation + timestamp + ".png");

	}

	public void FlushReport() {
		extent.flush();

	}
}
