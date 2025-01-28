package groups;

import org.testng.annotations.Test;
@Test(groups= {"adhoc"})
public class Group1 {
	@Test
	public void compose()
	{
	 System.out.println("message composed");
	 }
	@Test(dependsOnMethods = "compose")
	public void sentItems()
	{
	 System.out.println("message sent");
	}
	@Test(dependsOnMethods = "sentItems")
	public void trash()
	{
	  System.out.println("message deleted");
	}
	}

