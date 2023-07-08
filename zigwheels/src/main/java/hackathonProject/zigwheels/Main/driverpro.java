package hackathonProject.zigwheels.Main;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hackathonProject.zigwheels.Action.HomePageAction;
import hackathonProject.zigwheels.Action.ReturnedHomePageAct;
import hackathonProject.zigwheels.Action.StoreElementBike;
import hackathonProject.zigwheels.Action.StoreElementCar;
import hackathonProject.zigwheels.Action.loginErr;
import hackathonProject.zigwheels.Action.loginGuest;
import hackathonProject.zigwheels.Driver.DriverSetup;
import hackathonProject.zigwheels.util.ExcelSheet;
import hackathonProject.zigwheels.util.ExcelSheetCar;
import hackathonProject.zigwheels.util.end;
import hackathonProject.zigwheels.util.pause;
import hackathonProject.zigwheels.util.screenShot;
public class driverpro {
//	public WebDriver driver;

	@BeforeClass
	public static void beginSetup()
	{
		try {
			DriverSetup.getInvokeBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExcelSheet.intializeSheet();
	}
	
	@AfterClass
	public static void closeBrowser() {
		pause.hold(10);
		end.closeit();
	}
	
	
	@Test(priority = 0)
	public static void menuDisplayTest1()
	{
		HomePageAction.mouseOver1();
	}
	
	@Test(priority=1)
	public void getBikeContent()
	{
		pause.hold(1);
		StoreElementBike.bikeContent();
	}
	
	@Test(priority=2)
	public void navigateFromBikeToHome() {
		DriverSetup.driver.navigate().back();
		
		pause.hold(1);
	}
	
	@Test(priority=3)
	public static void menuDisplayTest2()
	{
		//Used to create excel sheet 
		ExcelSheetCar.intializeSheet();
		ReturnedHomePageAct.mouseOver2();
	}
	
	@Test(priority=4)
	public void getCarContent() {
		pause.hold(1);
		StoreElementCar.carContent();
	}
	@Test(priority=4)
	public void usdCar() throws InterruptedException {
		pause.hold(1);
		DriverSetup.driver.navigate().back();
		
	}

	@Test(priority=5)
	public void googleLogin() throws InterruptedException, IOException {

		// click on Login/signup
		pause.hold(3);
		loginGuest.Signup();
		pause.hold(3);

	}
	
	@Test(priority=6)
	public void errMsg() {
		screenShot.screenshot();
		loginErr.userNF();
	}

}
