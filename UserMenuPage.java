package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuPage  {
	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(id = "userNav-menuItems/a[1]")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[5]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editprofilebutton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile; 
	
	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;
	
	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;
	
	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;
	
	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy (id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;
	
	@FindBy (css = "#displayBadge")
	public WebElement moderatorButton;
	
	
	public boolean selectOptionInUserMenuDropDown(WebDriver driver, String optionName) {
		boolean isOptionSelected = false;
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
		if (userMenuOption.isDisplayed()) {
			userMenuOption.click();
			isOptionSelected = true;
		} else {
			System.out.println("Option " + optionName + " not selected");
		}
		return isOptionSelected;
	}
	
	public boolean createAPost(WebDriver driver, String message) throws InterruptedException {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			postLink.click();
			System.out.println("Clicked on the text box");
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().parentFrame();
			System.out.println("Entered the text in text box");
		
			if (shareButton.isDisplayed()) {
				shareButton.click();
				Thread.sleep(3000);
				System.out.println("Clicked on the post button");
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}
	public boolean isUserMenuseen() {
		if(userMenu.isDisplayed()) {
			return true;
			
		}
		else {
			return false;
		}
	}
					
		public boolean openEditProfileModal(WebDriver driver)  {
			boolean isEditProfileWindowSeen = false;
			if (editprofilebutton.isDisplayed()) {
				editprofilebutton.click();
			if (EditProfilePopupwindow.isDisplayed()) {
				
				isEditProfileWindowSeen =true;
			}
			return isEditProfileWindowSeen;
		}
	
    return isEditProfileWindowSeen ;
}
		public boolean changeLastNameInAboutTab(WebDriver driver, String lastName)  {
			driver.switchTo().frame(iframeAboutTab);
			boolean isLastNameChanged = false;
			if (Abouttab.isDisplayed()) {
				Abouttab.click();
				if (Abouttablastname.isDisplayed()) {
					Abouttablastname.clear();
					Abouttablastname.sendKeys(lastName);
					saveAllButton.click();
					isLastNameChanged = true;
				} 	
				
			}driver.switchTo().defaultContent();
			return isLastNameChanged;
		}

		public boolean clickOnUserMenu(WebDriver driver) {
						if(userMenu.isDisplayed()) {
							userMenu.click();
							
						}
						return true;
		}

		
		
}
