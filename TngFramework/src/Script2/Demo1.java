package Script2;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
@Test
public void test1()
{
	Reporter.log("Hi",true);
	Assert.fail();
}
@Test(dependsOnMethods = "test1")
public void test2()
{
	Reporter.log("Hello", true);
}
@Test
public void test3()
{
	Reporter.log("Bye", true);
}
}
