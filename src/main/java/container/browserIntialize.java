package container;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import listeners.testListeners;

public class browserIntialize extends testListeners {


	public static WebDriver driver;
	public static String testURL;
	public static String cityName;
	public static Properties prop;
	
	public WebDriver InitializeDriver() throws IOException {
		  prop = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\base.praoperties");
		prop.load(input);
		String browser = prop.getProperty("browser");
		testURL= prop.getProperty("URL");
		cityName=prop.getProperty("city");
		
		if (browser.equals("chrome")) {	
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\browserList\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\browsers_List\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\browsers_List\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	
	public  void RequestBuilder() {
	
	}
}
