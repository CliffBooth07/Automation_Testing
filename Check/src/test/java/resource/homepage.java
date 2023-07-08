package resource;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import provider.rest;
import provider.screenShot;
import provider.sheet;

public class homepage {
	static WebDriver driver;
	@Given("^The webpage is Home$")
	public static void title1() {
		driver = browser.driver;
		String s1="Home";
		String s2=driver.getTitle();
		if(s1.equalsIgnoreCase(s2)) {
			System.out.println("Page is correct");
		}
	}
	@When("^User click on profile icon$")
	public static void dashboard() {
		
		sheet.initializeSheet();
		boolean exception = true;
		while (exception) {
			try {
				WebElement info = driver.findElement(By.xpath("//div[@class='nvEhuDKzSmREBsqaIaOhu']"));
				info.click();
				screenShot.screenshot();
				exception = false;
			} catch (Exception e) {
				System.out.println("loading account information");

			}
		}
		rest.pause(5000);
		WebElement name = driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_primary']"));
		//String Name=name.getText();
		System.out.println(name.getText());
		
		WebElement iduser = driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_secondary']"));
		//String id=iduser.getText();
		System.out.println(iduser.getText());
		
		List<String> ls = new ArrayList<String>();
		//ls.add(Name);
		ls.add(iduser.getText());
		ls.add(name.getText());
	}
	@And("^User search Timesheet on placeholder$")
	public static void searchthat() {
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search in SharePoint']"));
		search.click();
		search.sendKeys("ESA Timesheet");
		search.sendKeys(Keys.ENTER);
	}
//if(equals)
//{}
//else
//{
//	fail("mess")}
//	}
	}

