package hackathonProject.zigwheels.Action;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hackathonProject.zigwheels.Driver.DriverSetup;
import hackathonProject.zigwheels.elements.HomePageElements;
import hackathonProject.zigwheels.util.ExcelSheetCar;
import hackathonProject.zigwheels.util.pause;

public class StoreElementCar {
	
	public static void carContent() {
		HomePageElements.menuItem2.click();
		pause.hold(3);
		List<WebElement> carNames = DriverSetup.driver.findElements(By.xpath("//a[@data-track-label='Car-name']"));
		System.out.println("Used Cars are:");
		int i=0;
		for (WebElement carName : carNames) {
			String a=carName.getText();
			System.out.println(carName.getText());
			ExcelSheetCar.addData(Arrays.asList(a),i++);
		}
		
		System.out.println("------------------------------------------------------------------------------------------");
//		pause.hold(1);
//		DriverSetup.driver.navigate().back();
//		System.out.println("------------------------------------------------------------------------------------------");
	}

}
