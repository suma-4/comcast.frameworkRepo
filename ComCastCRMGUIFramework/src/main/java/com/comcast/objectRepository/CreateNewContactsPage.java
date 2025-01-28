package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
@FindBy(name="lastname")
private WebElement LastNameEdit;

@FindBy(id="mobile")
private WebElement NumberEdit;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement LookUp;

@FindBy(name="support_start_date")
private WebElement startDate;

@FindBy(xpath="//input[@name='support_end_date']")
private WebElement endDate;

@FindBy(id="search_txt")
private WebElement search;

@FindBy(name="search")
private WebElement searchbtn;

@FindBy(xpath="(//input[@name='button'])[1]")
private WebElement save;
 
 public CreateNewContactsPage(WebDriver driver)
 {
		 PageFactory.initElements(driver, this);
 }

public WebElement getLastNameEdit() {
	return LastNameEdit;
}
public WebElement getStartDate() {
	return startDate;
}
public WebElement getEndDate() {
	return endDate;
}
public WebElement getNumberEdit() {
	return NumberEdit;
}

public WebElement getLookUp() {
	return LookUp;
}

public WebElement getSearch() {
	return search;
}

public WebElement getSearchbtn() {
	return searchbtn;
}

public WebElement getSave() {
	return save;
}
 
}
