package resource;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import provider.CheckA;
import provider.rest;

public class compareit {
	static WebDriver driver;
	
	@Given("^The webpage is Timesheet Landing Component$")
	public static void title2() {
		driver=browser.driver;
		String s1="Timesheet Landing Component";
		String s2=driver.getTitle();
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println("Correct page loaded");
		}
	}
	
	@When("^User validate 3 week data$")
	public static void dateverify() {
		
		
		String exdate = driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText();
		String reqDate= CheckA.getDateString(0);
		rest.pause(3000);
		if(exdate.equalsIgnoreCase(reqDate)) {
			System.out.println("Week current verify");
			System.out.println("Actual: "+reqDate);
			System.out.println("Expected: "+exdate);
			rest.pause(2000);
		}
		String exdate1 = driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$1']")).getText();
		String reqDate1= CheckA.getDateString(1);
		rest.pause(3000);
		if(exdate1.equalsIgnoreCase(reqDate1)) {
			System.out.println("Week current verify");
			System.out.println("Actual: "+reqDate);
			System.out.println("Expected: "+exdate);
			rest.pause(2000);
		}
		String exdate2 = driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$2']")).getText();
		String reqDate2= CheckA.getDateString(2);
		rest.pause(3000);
		if(exdate2.equalsIgnoreCase(reqDate2)) {
			System.out.println("Week current verify");
			System.out.println("Actual: "+reqDate);
			System.out.println("Expected: "+exdate);
			rest.pause(2000);
		}
	}
	
	@And("^User enter Date and search$")
	public static void current() {
		
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_SEARCH']")).click();
		driver.findElement(By.xpath("//option[@value='1']")).click();
		rest.pause(3000);

		WebElement date = driver.findElement(By.xpath("//input[@id='CTS_TS_LAND_WRK_DATE']"));
		date.click();
		LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		date.sendKeys(formattedDate);

		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
	}
}
