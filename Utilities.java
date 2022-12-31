package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static boolean waitForElement(WebDriver driver,WebElement element) {
		 Boolean isElementClickable=false;
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable=true;
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isElementClickable;
		
		
	}
	
}
