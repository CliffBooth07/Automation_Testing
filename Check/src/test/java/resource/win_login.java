package resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import provider.proppro;
import provider.rest;
import provider.screenShot;

public class win_login {
	static WebDriver driver;
	
	@Given("^The webpage is Sign in to your account$")
	public static void win1() {
		browser.Initilize();
		driver = browser.driver;
		String s1 = "Sign in to your account";
		String s2 = driver.getTitle();
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("Page is correct");
		}
	}
//		Assert.assertEquals(s1, s2);
	@When("^User enters the valid username$")
	public static void enteruser() {	
		boolean exception = true;
		while (exception) {
			try {
				WebElement user = driver.findElement(By.xpath("//input[@type='email']"));
				String username = proppro.prop.getProperty("userName");
				user.sendKeys(username);
				screenShot.screenshot();
				exception = false;
			} catch (Exception e) {
				System.out.println("loading.....");
			}
		}

		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		rest.pause(3000);
	}
		// input[@class='form-control ltr_override input ext-input text-box
		// ext-text-box']
	@And("^User enter the password$")
	public static void enterpass() {
		rest.pause(2000);
		WebElement a = driver.findElement(By.xpath("//input[@id='i0118']"));
		String pass = proppro.prop.getProperty("password");
		a.sendKeys(pass);
		//a.sendKeys("Durdon@9412129890");
		rest.pause(3000);
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).submit();
		rest.pause(3000);
		

	}
	@Then("^User click on submit button$")
	public static void login() {
		driver.findElement(By.xpath(
				"/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/div[2]"))
				.click();
		rest.pause(60000);
	}
	
}


