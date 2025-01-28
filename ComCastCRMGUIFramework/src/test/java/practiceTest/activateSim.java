package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTestUtility.BaseUtilityClass;

public class activateSim extends BaseUtilityClass{

	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImpClass.class)
	public void activeSim()
	{
		System.out.println("execute activeSim Test");
			String actTitle=driver.getTitle();
			Assert.assertEquals(actTitle, "Login");
			System.out.println("step=1");
			System.out.println("step=2");
			System.out.println("step=3");
			System.out.println("step=4");
		}
}
	
