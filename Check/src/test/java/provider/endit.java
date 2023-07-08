package provider;

import org.openqa.selenium.WebDriver;

import resource.browser;

public class endit {
	static WebDriver driver=browser.driver;
	public static void closeit() {
		driver.quit();
	}

}
