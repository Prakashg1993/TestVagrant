package container;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Extentreport.BaseUtil;

public class BrowserIntialize extends BaseUtil {

	private BaseUtil base;
	public static WebDriver driver;

	public BrowserIntialize(BaseUtil base) {
		this.base = base;
	}

	public BrowserIntialize() {

	}

	public WebDriver getdriver() throws IOException {
		if (driver == null)
			return driver = InitializeDriver(null);
		else
			return driver;
	}

	public WebDriver InitializeDriver(Scenario scenario) throws IOException {

//		scenarioDef = base.Method.createNode(Scenario.getGherkinName());
		
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\java\\Container\\Base.properties");

		prop.load(input);
		String browser = prop.getProperty("browser");
		

		if (browser.equals("chrome")) {
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ChromeOptions options = new ChromeOptions();
			if(prop.getProperty("HeadlessBrowser").equalsIgnoreCase("Yes")) {
	        options.addArguments("--headless");
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			}
			System.setProperty("webdriver.chrome.driver", "Browsers_List\\chromedriver.exe");
			driver = new ChromeDriver(dc);
			
		
		}
		if (browser.equals("firefox")) {
			FirefoxProfile profile=new FirefoxProfile();

			// This will set the true value
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
	
			System.setProperty("webdriver.gecko.driver", "Browsers_List\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "Browsers_List\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
