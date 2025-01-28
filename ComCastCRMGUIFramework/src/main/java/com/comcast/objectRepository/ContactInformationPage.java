package com.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
WebDriver driver;
@FindBy(id="mouseArea_Last Name")
WebElement headerText;

@FindBy(id="mouseArea_Organization Name")
WebElement  LastName;

@FindBy(id="mouseArea_Mobile")
WebElement Mobile;

public ContactInformationPage(WebDriver driver)
{
  this.driver=driver;
  PageFactory.initElements(driver, this);
}

public WebElement getHeaderText() {
	return headerText;
}

public WebElement getHeaderText1() {
	return LastName;
}

public WebElement getMobile() {
	return Mobile;
}

}
