package container;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.aventstack.extentreports.gherkin.model.Scenario;

public class browserIntialize {


	public static WebDriver driver;
	
	public WebDriver InitializeDriver(Scenario scenario) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream("src\\main\\resources\\base.properties");
		prop.load(input);
		String browser = prop.getProperty("browser");
		
		if (browser.equals("chrome")) {	
			System.setProperty("webdriver.chrome.driver", "browsers_List\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "browsers_List\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "browsers_List\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
