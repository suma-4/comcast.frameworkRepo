package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;

public class LoginPage extends WebdriverUtility {

	//Rule1 create a separate java class
	//Rule-2 Object creation
	WebDriver driver=null;
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	  
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement Loginbtn;

	//Rule-3 Object initialization
	//Rule-4 Object encapsulation
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

// provide actions(Business utility)

public void loginToApp( String username, String password)
{
	//driver.get(URL);
	usernameEdit.sendKeys(username);
	passwordEdit.sendKeys(password);
	Loginbtn.click();
}}


