package resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import provider.rest;

public class nextpage {
	static WebDriver driver;
	@Then("^User click on link$")
	public static void linkofthat() {
		driver=browser.driver;
		boolean exception = true;
		while (exception) {
			try {
				driver.findElement(By.xpath(
						"//h2[@class='ms-search-bookmarkTitle title-303 title-344 ms-search-text-h1 text-358']")).click();
				exception = false;
			} catch (Exception e) {
				rest.pause(3000);
				System.out.println("link is loading.....");
			}
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// input[@id='idSIButton9']
		// click on google
		rest.pause(5000);
		String all = driver.getWindowHandle();
		System.out.println(all);
		int lastHandleIndex = driver.getWindowHandles().size() - 1;
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(handles.get(lastHandleIndex));
		driver.switchTo().window(handles.get(lastHandleIndex));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
		@And("^User click on Timesheet icon$")
		public static void icon () {
		Boolean exception = true;
		while (exception) {
			try {
				driver.findElement(By.xpath(
						"/html/body/form/div[3]/div[4]/div[2]/div/div/div/div[2]/div[3]/section/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div/div[2]"))
						.click();
				exception = false;
			} catch (Exception e) {
				System.out.println("page is loading");
			}
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		rest.pause(8000);
	}

}
