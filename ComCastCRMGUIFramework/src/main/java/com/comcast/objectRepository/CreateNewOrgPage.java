package com.comcast.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;

public class CreateNewOrgPage extends WebdriverUtility {

	WebDriver driver;
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement Industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement Type;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement save;
		
	public CreateNewOrgPage(WebDriver driver)
	{
				PageFactory.initElements(driver, this);
	}

		public WebElement getOrgName() {
		return OrgName;
	}
		
			public WebElement getIndustry() {
			return Industry;
		}

			public WebElement getType() {
			return Type;
		}

	public void createOrgInd(String OrgName, String Industry, String Type)
	{
	
	}

	public WebElement getSave() {
		return save;
	}
}
