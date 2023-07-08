package hackathonProject.zigwheels.Action;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import hackathonProject.zigwheels.Driver.DriverSetup;
import hackathonProject.zigwheels.elements.HomePageElements;
import hackathonProject.zigwheels.util.pause;

public class loginGuest {
	
	public static void Signup() throws IOException{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"\\data.properties");
		Properties props=new Properties();
        props.load(reader);
		HomePageElements.loginbtn.click();
		pause.hold(1);
		// click on google
		HomePageElements.googlebtn.click();
		pause.hold(3);
		Iterator<String> windowIterator = DriverSetup.driver.getWindowHandles().iterator();
		windowIterator.next();
		String child = windowIterator.next();
		// System.out.println(child);
		DriverSetup.driver.switchTo().window(child);
		DriverSetup.driver.manage().window().maximize();
		pause.hold(1);
		
		
//		WebElement email = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
//		email.sendKeys("qwerty123@gmail.com");
//		new HomePageElements(driver);
		HomePageElements.email.sendKeys(props.getProperty("email"));
		
		HomePageElements.next.click();
		
	} 

}
