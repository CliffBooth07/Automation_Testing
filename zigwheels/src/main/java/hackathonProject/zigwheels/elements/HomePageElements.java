package hackathonProject.zigwheels.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {
	
	
//	@FindBy(xpath="//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/a")
//	public static WebElement bikeMenu;
	
	@FindBy(xpath="/html/body/header/div/div[5]/div/nav/div/ul/li[3]/ul/li[5]/span")
	public static WebElement menuItem1;
	
//	@FindBy(xpath="/html/body/header/div/div[5]/div/nav/div/ul/li[7]/ul/li/div[2]/ul/li[5]/span")
//	public static WebElement menuItem;
	
	@FindBy(xpath="/html/body/header/div/div[5]/div/nav/div/ul/li[7]/ul/li/div[2]/ul/li[5]/span")
	public static WebElement menuItem2;
	
//	@FindBy(xpath="/html/body/header/div/div[5]/div/nav/div/ul/li[7]/a")
//	public static WebElement carMenu;
	
	@FindBy(xpath="/html/body/header/div/div[5]/div/nav/div/ul/li[7]/ul/li/div[2]/ul/li[5]/span")
	public static WebElement menuItem;
	
//	@FindBy(xpath="//a[@data-track-label='Car-name']")
//	public static List<WebElement> carCont;
	
	@FindBy(xpath="//div[@id='forum_login_wrap_lg']")
	public static WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	public static WebElement googlebtn;

	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	public static WebElement email;
//	public HomePageElements(WebDriver driver) {
//		email = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
//	}
	@FindBy(xpath ="//*[@id=\"identifierNext\"]/div/button/span")
	public static WebElement next;
	
	@FindBy(xpath= "//div[@class='o6cuMc Jj6Lae']")
	public static WebElement errormsg;
}
