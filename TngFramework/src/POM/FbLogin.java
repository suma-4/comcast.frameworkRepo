package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLogin {
@FindBy(id="email")
private WebElement Uname;
@FindBy(id="pass")
private WebElement PWD;
@FindBy (name="login")
private WebElement log;
public FbLogin(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void userName(String U)
{
	Uname.sendKeys(U);
}
public void password(String P)
{
	PWD.sendKeys(P);
}
public void login()
{
   log.click();	
}
}