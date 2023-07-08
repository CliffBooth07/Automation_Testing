package resource;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import provider.rest;
import provider.screenShot;

public class statusverify {
	static WebDriver driver;
	
	@When("^User select approve$")
	public static void approve() {
		
		driver=browser.driver;
		boolean exception = true;
		while (exception) {
			try {
				driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_SEARCH']")).click();
				rest.pause(1000);
				exception = false;
			} catch (Exception e) {
			}
		}
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();
		driver.findElement(By.xpath("//option[@value='APR']")).click();

		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		screenShot.screenshot();

		rest.pause(5000);
		
		}
	
	@Then("^Data got visible$")
	public static void approvecont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		List<WebElement> app = driver.findElements(By.xpath("//div[@class='ps_box-link timesheet_period']/span/a"));
		for (WebElement appo : app) {
			System.out.println("Approved :");
			System.out.println(appo.getText());
			ls.add(appo.getText());
			rest.pause(1000);
	}	
	}
	
	@When("^User select overdue$")
	public static void overdue() {
		
		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();

		driver.findElement(By.xpath("//option[@value='OVR']")).click();
		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		screenShot.screenshot();
		rest.pause(2000);
		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();

		
	}
	
	@Then("^click ok$")
	public static void overduecont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		System.out.println("Overdue: " + driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		ls.add(driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		rest.pause(1000);
	}
	
	@When("^User select partially approved$")
	public static void partially_overdue() {
		
		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();
		driver.findElement(By.xpath("//option[@value='PAR']")).click();
		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		rest.pause(2000);
		screenShot.screenshot();
		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();
		
	}
	
	@Then("^Data not visible$")
	public static void partially_overdueCont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		System.out.println("Partially Approved: "+ driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		rest.pause(1000);
		ls.add(driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
	}
	
	@When("^User select pending$")
	public static void pending() {

		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();

		driver.findElement(By.xpath("//option[@value='PND']")).click();
		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		rest.pause(2000);
		screenShot.screenshot();
		
	}
	
	@Then("^Data got show$")
	public static void pendingcont() {
		
		rest.pause(2000);
		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();
		List<String> ls = new ArrayList<String>();
		List<WebElement> pen = driver.findElements(By.xpath("//div[@class='ps_box-link timesheet_period']/span/a"));
		for (WebElement pend : pen) {

			System.out.println("Pending: ");
			System.out.println(pend.getText());
			ls.add(pend.getText());
			rest.pause(1000);
		}

	}
	
	@When("^User select saved$")
	public static void saved() {
		
		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();

		driver.findElement(By.xpath("//option[@value='SAV']")).click();
		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		rest.pause(2000);
		screenShot.screenshot();
		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();
		

	}
	
	@Then("^Data shown$")
	public static void savedcont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		System.out.println("Saved: " + driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		ls.add(driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		rest.pause(1000);
	}
	
	@When("^User select send back for Revision$")
	public static void sendbackfr() {
		
		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();
		driver.findElement(By.xpath("//option[@value='SBR']")).click();
		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		rest.pause(2000);
		screenShot.screenshot();
		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();
		

	}
	
	@Then("^No data found$")
	public static void sendbackcont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		System.out.println("Send Back for Revision: "+ driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		ls.add(driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		rest.pause(1000);
		
	}
	
	@When("^User select submitted for approval$")
	public static void submitbackfa() {
		driver.findElement(By.xpath("//select[@class='ps-dropdown']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		driver.findElement(By.xpath("//select[@id='CTS_TS_LAND_WRK_CTS_TS_LAND_STATUS']")).click();

		driver.findElement(By.xpath("//option[@value='SUB']")).click();

		rest.pause(3000);
		driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_WRK_SEARCH']")).click();
		rest.pause(2000);
		screenShot.screenshot();

		driver.findElement(By.xpath("//a[@id='#ICOK']")).click();

	}
	
	@Then("^Content not shown$")
	public static void submitbackcont() {
		
		rest.pause(2000);
		List<String> ls = new ArrayList<String>();
		System.out.println("Submitted for Approval: "+ driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
		ls.add(driver.findElement(By.xpath("//a[@id='CTS_TS_LAND_PER_DESCR30$0']")).getText());
	}

}
