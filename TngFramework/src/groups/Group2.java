package groups;

import org.testng.annotations.Test;
@Test(groups= {"unit"})
public class Group2 {
	@Test
	public void test1()
	{
	 System.out.println("this is testcase1");	
	}
	@Test
	public void test2()
	{
	 System.out.println("this is testcase2");
	}
	@Test
	public void test3()
	{
		System.out.println("this is testcase3");
	}
	}

