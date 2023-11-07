package cart;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class Trying_TC_02 extends BaseClass {
	@Test
	public void creating()
	{
		System.out.println("changed something");
	}

}
