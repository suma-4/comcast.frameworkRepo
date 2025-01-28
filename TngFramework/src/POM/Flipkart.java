package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart {
@FindBy(xpath="//span[text()='Mobiles']")
private WebElement mob;
@FindBy(xpath="//img[@alt='Motorola Edge 50 Neo (PANTONE Nautical Blue, 256 GB)']")
private WebElement phone;
@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2']")
private WebElement buy;
public Flipkart(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	}
public void search()
{
	mob.click();
}
public void pic()
{
	phone.click();
	}
public void buyNow()
{
 buy.click();	
}
}
