package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFB {
@FindBy(id="email")
private WebElement email;
@FindBy(id="pass")
private WebElement password;
@FindBy (name="login")
private WebElement button;
public LoginFB(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void userName(String U)
{
    email.sendKeys(U);
}
public void password(String P)
{
	password.sendKeys(P);
}
public void button()
{
   button.click();
}
}


