package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UserMenuPage;

public class LoginTest extends BaseTest
{
	@Test
	public void loginErrorMsg_TC01() {
		WebDriver driver=getDriver();
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.launchApp(driver), "should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername("abc.subha@do.com", driver), "User name should be entered");
		lp.clearPassword();
		Assert.assertTrue(lp.clickLogin(driver), "login button should be clicked");
		Assert.assertEquals(lp.loginErrorMsg.getText(),"Please enter your password.");
	}
	@Test
	public void loginToSF_TC02() {
		WebDriver driver=getDriver();
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.launchApp(driver), "should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername("abc.subha@do.com", driver), "User name should be entered");
		Assert.assertTrue(lp.enterPassword("Subha2022", driver), "password should be entered");
		Assert.assertTrue(lp.clickLogin(driver), "login button should be clicked");
		Assert.assertTrue(lp.isFreeTrailSeen(),"Free trial should be seen");
	}
	@Test
	public void rememberMe_TC03() throws InterruptedException, IOException {
		WebDriver driver=getDriver();
		LoginPage lp=new LoginPage(driver);
		UserMenuPage ump=new UserMenuPage(driver);
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Assert.assertTrue(lp.launchApp(driver), "should launch the sfdc app");
		Assert.assertTrue(lp.enterUsername("abc.subha@do.com", driver), "User name should be entered");
		Assert.assertTrue(lp.enterPassword("Subha2022", driver), "password should be entered");
		Assert.assertTrue(lp.selectRemeberMeCheckbox(), "should select remember me checkbox");
		Assert.assertTrue(lp.clickLogin(driver), "Login button should be clicked");
		Assert.assertTrue(ump.clickOnUserMenu(driver));
		Thread.sleep(2000);
		Assert.assertTrue(ump.selectOptionInUserMenuDropDown(driver, "Logout"),"Logout should be clicked");	
		Thread.sleep(2000);
		utilities.Utilities.waitForElement(driver, lp.savedUsername);
		Assert.assertEquals(lp.getSavedUsername(),"abc.subha@do.com");
	}
	

}
