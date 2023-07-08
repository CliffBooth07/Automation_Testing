package util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import provider.endit;
import provider.rest;
import resource.browser;
import resource.compareit;
import resource.homepage;
import resource.nextpage;
import resource.statusverify;
import resource.win_login;

public class setupBrowser {
	static WebDriver driver=browser.driver;
	
	@BeforeSuite
	public void getInvokeBrowser() {
		browser.Initilize();
	}
	
	@Test(priority=1)
	public void loginfr() throws InterruptedException {
		
		driver=browser.driver;
		win_login.win1();
		win_login.enteruser();
		win_login.enterpass();
		win_login.login();
		rest.pause(5000);

	}
	@Test(priority=2)
	public void console(){
		homepage.title1();
		
		homepage.dashboard();
		homepage.searchthat();
	}
	@Test(priority=3)
	public void searched() {
		nextpage.linkofthat();
		nextpage.icon();

	}
	@Test(priority=4)
	public void compareit() {
		compareit.title2();
		compareit.dateverify();
		compareit.current();
		// -------------****----------------
		driver.navigate().refresh();
		rest.pause(2000);
		
		
	}
	@Test(priority=5)
	public void approved() {
		statusverify.approve();
		statusverify.approvecont();
		driver.navigate().refresh();
		rest.pause(2000);
		// --------------------------------------------------
		
	}
	@Test(priority=6)
	public void due() {
		statusverify.overdue();
		statusverify.overduecont();
		// ----------------------------------------------------------

		driver.navigate().refresh();
		rest.pause(2000);
		// --------------------------------------------------
		
	}
	@Test(priority=7)
	public void partdue() {
		statusverify.partially_overdue();
		statusverify.partially_overdueCont();
		driver.navigate().refresh();
		rest.pause(2000);
		// -----------------------------------------------------------
		
	}
	@Test(priority=8)
	public void pendings() {
		statusverify.pending();
		statusverify.pendingcont();
		
		// -------------------------------------------------------------------------------
		
	}
	@Test(priority=9)
	public void save() {
		driver.navigate().refresh();
		rest.pause(2000);
		statusverify.saved();
		statusverify.savedcont();
		// ---------------------------------------------------------------------------
		

	}
	@Test(priority=10)
	public void sendback() {
		driver.navigate().refresh();
		rest.pause(2000);
		statusverify.sendbackfr();
		statusverify.sendbackcont();
		// ==========================================================================
		
	}
	@Test(priority=11)
	public void submitback() {
		driver.navigate().refresh();
		rest.pause(2000);
		statusverify.submitbackfa();
		statusverify.submitbackcont();
	}
	@AfterSuite
	public void end() {
		endit.closeit();
	}

}
