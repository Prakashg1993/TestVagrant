package container;

import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseUtil {

	
	public WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest scenarioDef;
	public static ExtentTest Method;
	public ExtentTest logger;
	public static String reportLocation = "Screenshots//";
	public ExtentColor color;
	
	
}
