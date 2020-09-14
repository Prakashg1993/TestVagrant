package container;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.TestRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Container.BrowserIntialize;
import Container.ExcelUtils;
import PageObjects.SAMLAuthHome;

import gherkin.formatter.model.Result;


public class ExtentReportUtil extends BaseUtil {

public static String reportname;
//	String filename = "extentreport.html";
public ExtentReportUtil(String Data) {
	reportname=Data;
}
public ExtentReportUtil() {
	
}

	public void ExtentReport() {
		// create object reports

		extent = new ExtentReports();
		System.out.println("Report Name "+ reportname);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/"+reportname+".html");
//		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter();
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test Report for Appsian Application");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report");
		
		extent.attachReporter(htmlReporter);
	}
	public void ExtentReportconsole(String Version,String BuildNumber) throws IOException {
		Properties prop = new Properties();
		FileInputStream	input = new FileInputStream("src\\main\\java\\Container\\Base.properties");
		prop.load(input);
		String URL = prop.getProperty("AppURL");
		String AppName = null;
		if (URL.contains("c2t")) {
			AppName = "Campus Application";
		} else if (URL.contains("h2t")) {
			AppName = "HRMS Application";
			}
		if (URL.contains("f2t")) {
			AppName = "Finance Application";}
		
		extent.setSystemInfo("User Name", "Prakash.G");
		extent.setSystemInfo("OS", "windows server 2008 R2 enterprice");
		extent.setSystemInfo("Envirnoment", AppName);
		extent.setSystemInfo("Tool Version",Version);
		extent.setSystemInfo("Build Number", BuildNumber);
		extent.setSystemInfo("APP URL", URL);
	}

	public void ExtentReportScreenshot(Throwable throwable,ExtentTest Logger) throws IOException {
		BrowserIntialize intialize = new BrowserIntialize();
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		File src = ((TakesScreenshot) intialize.getdriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(reportLocation + timestamp + ".png"));
//		logger=this.logger;
		Logger.fail(throwable).addScreenCaptureFromPath(reportLocation + timestamp + ".png");
		
	}
	public void ExtentReportScreenshot(Throwable throwable) throws IOException {
		BrowserIntialize intialize = new BrowserIntialize();
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		File src = ((TakesScreenshot) intialize.getdriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(reportLocation + timestamp + ".png"));
//		logger=this.logger;
		logger.fail(throwable).addScreenCaptureFromPath(reportLocation + timestamp + ".png");
		
	}
	public void ExtentReportSkip(Throwable throwable) throws IOException{
		scenarioDef.skip(throwable);
	}

	public void FlushReport() {
		extent.flush();

	}
}
