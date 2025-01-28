package extentReports;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report1 {
	ExtentReports reports;	
@Test
public void test1()
{
ExtentReports rep=new ExtentReports("./reports/r1.html", false);
ExtentTest test=rep.startTest("testcase1");
test.log(Status.PASS,"test case passed");
test.log(Status.FAIL, "test case failed");
test.log(Status.SKIP, "test case skipped");
rep.endTest(test);
rep.flush();
}
}
