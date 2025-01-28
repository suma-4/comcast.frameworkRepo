package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInformationPage {


	WebDriver driver;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement headerName;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement IndName;
	
	@FindBy(id="mouseArea_Type")
	private WebElement type;
	
	
	public WebElement getType() {
		return type;
	}

	public OrgInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndName() {
		return IndName;
	}

	/**
	 * @param indName the indName to set
	 */
	public void setIndName(WebElement indName) {
		IndName = indName;
	}

		public WebElement getHeaderName() {
		return headerName;
	}

		
	}


