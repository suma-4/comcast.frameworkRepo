package com.comcast.crm.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
//implicit
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//explicit 2
	public void waitForElementPresent(WebDriver driver, WebElement element, List<WebElement> elements)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	//3
	public void waitForElementIsClickable(WebDriver driver, WebElement element)
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//4
	public void waitForElementIsSelected(WebDriver driver, WebElement element)
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		
		}
	//6
	public void waitForElementIsInvisible(WebDriver driver, WebElement element, List<WebElement> elements)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	//7
	public void waitForPopUpIsPresent(WebDriver driver, Alert popup)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	//8
	public void waitForWindowsToBepresent(WebDriver driver, int count)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfWindowsToBe(count));
	}
	//maximize
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//minimize
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	//Dropdown
	public void handleDropdownByIndex(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(0);
	}
	//2
	public void handleDropdownByVisibleText(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	//3
	public void handleDropdownToDeselect(WebElement element, String text)
	{
		Select s=new Select(element);	
		s.deselectByVisibleText(text);
	}
	//Actions
	public void clickOnElement(WebElement element, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.click().perform();
	}
	//rightClick
	public void rightClick(WebElement element, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	//sendkeys
	public void sEndKeys(WebElement element, WebDriver driver, String text)
	{
		Actions act=new Actions(driver);
		act.sendKeys(element, text).perform();
	}
	//doubleClick
	public void doubleClick(WebElement element, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	//scrolldown
	public void scrollDown(WebDriver driver, int x, int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x,y).perform();
	}
	//scrollByelement
	public void scrollByElement(WebElement element, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	//moveto element
	public void moveToElement(WebElement element, WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	//JSE
	public void scrollDownByJSE(WebElement element, WebDriver driver, int x, int y)
	{
	JavascriptExecutor Jse=(JavascriptExecutor)driver;
		Jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	//parent to child
		public void swithToChildFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
		//child to parent
	public void swithToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame(); 
	}
	//Mainframe
	public void swithToMainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	//switch to browser
	public void swithToBrowser(WebDriver driver, String partialURL)
	{
		Set<String> pop = driver.getWindowHandles();
		Iterator<String> it = pop.iterator();
		while(it.hasNext())
		{
			String window1 = it.next();
			driver.switchTo().window(window1);
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains(partialURL))
			break;
	}}
	//alert1
		public void alertPopUp(WebDriver driver, Alert al)
		{
			al=driver.switchTo().alert();
			
		}
		//2
		public void switchToAlertAndCancel (WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		//3
		public void switchToAlertAndGetText (WebDriver driver) {
			driver.switchTo().alert().getText();
		}
		public void switchToAlertAndSendKeys (WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);;
		}
		public void switchToAlertAndAccept (WebDriver driver) {
			driver.switchTo().alert().accept();}
		//TakeScreenshot
		public void takeScreenshot(WebDriver driver, String testName) throws IOException {
		String photo="./screenshot/"+testName+"";
		Date d=new Date();
		String d1=d.toString();
		String d2=d1.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(photo+d2+".jpeg");
		FileHandler.copy(src, dst);
		}
}

