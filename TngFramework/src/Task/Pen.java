package Task;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Pen extends Generic {

	@Test
	public void hard()
	{
		String title=driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(title, "Facebook – log in or sign up");
		System.out.println("India");
		sa.assertAll();
		
	}
}
