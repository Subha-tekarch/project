package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author byoma
 *
 */
/**
 * @author byoma
 *
 */
/**
 * @author byoma
 *
 */
public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(name = "pw")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(css = "#error")
	public WebElement loginErrorMsg;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(partialLinkText = "Forgot Your")
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "forgotPassForm")
	public WebElement passwordResetScreen;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

    /**
     * @param userName
     * @param driver
     * @return
     */
    public Boolean enterUsername(String userName,WebDriver driver) {
    	if(username.isDisplayed()) {
    		username.sendKeys(userName);
    		return true;
    		
    	}else
    	{
    		return false;
    	}
    }
    public Boolean enterPassword(String pass,WebDriver driver) {
    	if(password.isDisplayed()) {
    		password.sendKeys(pass);
    		return true;
    		
    	}else
    	{
    		return false;
    	}
    }
    	 public Boolean clickLogin(WebDriver driver) {
    	    	if(loginButton.isDisplayed()) {
    	    	loginButton.click();;
    	    		return true;
    	    		
    	    	}else
    	    	{
    	    		return false;
    	    	}
    }
    	 public void clearPassword() {
    			password.clear();
    		}
    	 public boolean isErrorMessageSeen() {
    			if (loginErrorMsg.isDisplayed()) {
    			
    				return true;
    			} else {
    			
    				return false;
    			}
    		}
    	 public boolean isFreeTrailSeen(){
    			return true;
    		}
    	 public boolean isSavedUsernameSeen() {
    			if (savedUsername.isDisplayed()) {
    				
    				return true;
    			} else {
    				return false;
    			}
    		}
    	 public String getSavedUsername() {
    			return savedUsername.getText();
    		}
    	 public boolean selectRemeberMeCheckbox() {
    			boolean checkboxStatus = false;
    			if (rememberMe.isSelected()) {
    				checkboxStatus = true;
    				    			} else {
    				rememberMe.click();
    				checkboxStatus = true;
    			}
    			return checkboxStatus;
    		}
    	 public Boolean launchApp(WebDriver driver) {
    		 driver.get("https://login.salesforce.com/");
    		 return true;
    	 }






}
