package extentReports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report1 {
@Test
public void test1()
{
ExtentReports rep=new ExtentReports("./reports/r1.html", false);
ExtentTest test=rep.startTest("testcase1");
test.log(LogStatus.PASS,"test case passed");
test.log(LogStatus.FAIL, "test case failed");
test.log(LogStatus.SKIP, "test case skipped");
rep.endTest(test);
rep.flush();
}
}
