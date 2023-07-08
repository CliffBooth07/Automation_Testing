package hackathonProject.zigwheels.Action;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hackathonProject.zigwheels.Driver.DriverSetup;
import hackathonProject.zigwheels.util.ExcelSheet;
import hackathonProject.zigwheels.util.pause;

public class StoreElementBike {
	
	public static void bikeContent() {
		
		DriverSetup.driver.findElement(By.xpath("/html/body/header/div/div[5]/div/nav/div/ul/li[3]/ul/li[5]/span")).click();
		pause.hold(1);
		List<WebElement> upcbike = DriverSetup.driver.findElements(By.xpath("//strong[@class='lnk-hvr block of-hid h-height']"));
		List<WebElement> ratebike = DriverSetup.driver.findElements(By.xpath("//div[@class='b fnt-15']"));
		List<WebElement> datebike = DriverSetup.driver.findElements(By.xpath("//div[@class='clr-try fnt-14']"));
		System.out
				.println("******************************Program Start from Here*************************************");

		int listSize = upcbike.size();

		for (int i = 0; i < listSize; i++) {
			WebElement relbike = upcbike.get(i);
			WebElement ambike = ratebike.get(i);
			WebElement dtbike = datebike.get(i);

			String name = relbike.getText();
			String rate = ambike.getText();
			String date = dtbike.getText();
			
			ExcelSheet.addData(Arrays.asList(name, rate, date), i);
			
			if (name != "") {
				System.out.println("Upcoming Bike is as : " + name);
				System.out.println("Upcoming Bike rate is as : " + rate);
				System.out.println("Upcoming Bike date is as : " + date);
			}
		}
		System.out
				.println("------------------------------------------------------------------------------------------");
	} 

}
