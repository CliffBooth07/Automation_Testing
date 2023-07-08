package hackathonProject.zigwheels.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import hackathonProject.zigwheels.Driver.DriverSetup;

public class ReturnedHomePageAct {
	
	public static void mouseOver2(){
		WebElement car_link = DriverSetup.driver.findElement(By.xpath("/html/body/header/div/div[5]/div/nav/div/ul/li[7]/a"));
		Actions act = new Actions(DriverSetup.driver);
		act.moveToElement(car_link).build().perform();
//		
		
	}

}
