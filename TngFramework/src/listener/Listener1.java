package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1 implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("testcase execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("testcase success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("testcase failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("testcase skipped");
	}


}
