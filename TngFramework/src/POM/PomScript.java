package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomScript {

	@FindBy(id="email")
	private WebElement uName;
	

	@FindBy(id="pass")
	private WebElement pwd;
	
	public PomScript(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
}
	public void passData()
	{
		uName.sendKeys("admin");
	}
	
	
}

