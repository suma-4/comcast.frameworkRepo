package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class runner extends Generic{

	@Test
	public void run()
	{
		driver.findElement(By.id("email")).sendKeys("sinchan.suma");
		driver.findElement(By.id("pass")).sendKeys("suma@123");
		driver.findElement(By.name("login")).click();
		
	}
}
