package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement OrgLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement ProductsLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement ContactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	public HomePage(WebDriver driver)
	{
				PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrgLink() {
		return OrgLink;
	}


	public void signOut(WebDriver driver)
	{
		moveToElement(admin, driver);
		signOut.click();
		
	}


	public WebElement getContactLink() {
		return ContactLink;
	}
	
}
