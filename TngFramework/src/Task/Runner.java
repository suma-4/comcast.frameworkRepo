package Task;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Runner extends Generic {
@Test
public void follow() 
{
	 driver.findElement(By.xpath("//span[text()='What's on your mind, Sinchan?']")).sendKeys("Sharukh Khan");
	 
}}

