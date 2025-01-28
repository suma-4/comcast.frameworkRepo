package com.comcast.crm.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTestUtility.BaseUtilityClass;
import com.comcast.crm.generic.webdriverUtility.UtilityClassObject;
/**
 * Author: Suma
 * contains Listner configurations
 * */
public class ListenerImpClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	public WebDriver driver;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==== ===>" + result.getMethod().getMethodName() + "====Start==");
		/*insert testcase inside report*/
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED <====" );
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		/*spark report config*/
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvReports/report_"+time+".html");
		spark.config().setDocumentTitle("OnePoint Reports");
		spark.config().setReportName("OnePoint");
		spark.config().setTheme(Theme.STANDARD);

		/* add environment information and create test */
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("Browser", "Chrome-131");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backUp");

		report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==== ===>" + result.getMethod().getMethodName() + "====ENd==");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED <====" );

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getMethod().getMethodName()+"==> SKIPPED <====" );
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseUtilityClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED <====" );
	}

}
