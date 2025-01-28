package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class runner1 extends Generic{

	@Test
	public void run1()
	
	{
		driver.findElement(By.xpath("//a[.='Forgotten password?']")).click();
		driver.findElement(By.id("facebook")).sendKeys("sinchan.suma@gmail.com");
		driver.findElement(By.id("did_submit")).click();
	}
}
