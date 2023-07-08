package provider;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import resource.browser;

public class screenShot {
	
	
	public static void screenshot() {

		//driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
		LocalTime ts = LocalTime.now(ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh/mm/ss");
		String fts = ts.format(formatter);
		
		TakesScreenshot screen = (TakesScreenshot) browser.driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		// Save the screenshot to the specified path
		try {
			FileUtils.copyFile(source, new File("./screenshot" + fts + "_screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------ScreenShot Captured-------------");
		
	}


}
