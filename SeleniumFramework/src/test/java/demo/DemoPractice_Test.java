package demo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DemoPractice_Test extends BaseClass{
	@Test
	public void demoMethod()
	{
		System.out.println("done");
		System.out.println("done2");
	}

}
