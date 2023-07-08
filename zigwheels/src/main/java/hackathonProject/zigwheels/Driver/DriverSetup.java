package hackathonProject.zigwheels.Driver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import hackathonProject.zigwheels.elements.HomePageElements;

public class DriverSetup {
	public static WebDriver driver;

	public static void getInvokeBrowser() throws IOException {
//		String browser = "chrome";
		FileReader reader=new FileReader(System.getProperty("user.dir")+"\\data.properties");
        Properties props=new Properties();
        props.load(reader);
		String browser = props.getProperty("browserName");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else  {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
	
		HomePageElements hpe = new HomePageElements();

	        //PageFactory is used to find elements with @FindBy specified
	        PageFactory.initElements(driver, hpe);
	        
	        driver.get(props.getProperty("websiteURL"));
	}

}
