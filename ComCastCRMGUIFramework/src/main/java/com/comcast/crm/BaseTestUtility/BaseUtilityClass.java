 package com.comcast.crm.BaseTestUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.objectRepository.HomePage;
import com.comcast.objectRepository.LoginPage;

public class BaseUtilityClass {
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebdriverUtility wbU = new WebdriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() {

		System.out.println("get DB connection");
	}

	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void configBC() throws IOException {
		String Browser = fLib.getDataFromPropertiesFile("Browser");
		String url = fLib.getDataFromPropertiesFile("URL");
		if (Browser.equals("Firefox"))
			driver = new FirefoxDriver();

		else {
			driver = new ChromeDriver();
		}

		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		
		driver.get(url);
		wbU.maximizeWindow(driver);
		wbU.waitForPageToLoad(driver);

	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configBM() throws IOException {

		String UN = fLib.getDataFromPropertiesFile("Username");
		String pwd = fLib.getDataFromPropertiesFile("Password");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(UN, pwd);

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configAS() {
		System.out.println("close DB connection");
	}

}
