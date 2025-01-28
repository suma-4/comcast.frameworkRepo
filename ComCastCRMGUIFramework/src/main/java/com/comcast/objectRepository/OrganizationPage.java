package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {

	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement icon;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchBy;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchbtn;
	
	public OrganizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchText() {
		return searchText;
	}

		public WebElement getSearchbtn() {
		return searchbtn;
	}

		public WebElement getIcon() {
		return icon;
	}

				public WebElement getSearchBy() {
			return searchBy;
		}
		

	
}
