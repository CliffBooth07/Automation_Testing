package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import provider.proppro;
import provider.rest;

public class browser {
	public static WebDriver driver;
	

	public static void Initilize() {
		//System.out.println(System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\2273366\\eclipse-workspace\\Check\\Driver\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.out.println("--------Browser Opening--------");
		proppro.cont();
        String browser = proppro.prop.getProperty("browserName");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pawan\\eclipse-workspace\\INTQEA23QE005_8_Timesheet\\Check\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else  {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		//proppro.cont();
		String url = proppro.prop.getProperty("url");
		System.out.println(url);
		driver.get(url);
		rest.pause(8000);
	}
//	public static void main(String[] args) {
//		Initilize();
//	}

}
