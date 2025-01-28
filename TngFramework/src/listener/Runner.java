package listener;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class Runner {
@Test
public void compose()
{
 System.out.println("message composed");
 }
@Test(dependsOnMethods = "compose")
public void sentItems()
{
 System.out.println("message sent");
 fail();
}
@Test(dependsOnMethods = "sentItems")
public void trash()
{
  System.out.println("message deleted");
}
}
