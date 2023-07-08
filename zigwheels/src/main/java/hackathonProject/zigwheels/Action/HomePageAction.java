package hackathonProject.zigwheels.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import hackathonProject.zigwheels.Driver.DriverSetup;

public class HomePageAction {

	public static void mouseOver1()
	{
		WebElement bike_link = DriverSetup.driver.findElement(By.xpath("//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/a"));
		Actions act = new Actions(DriverSetup.driver);
		act.moveToElement(bike_link).build().perform();
	}
}
