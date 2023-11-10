package login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Login_01_Test extends BaseClass {
	@Test(groups = "FT")
	public void verify_user_is_able_to_login_with_valid_credentials() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(login.getLoginlink());
		logger.log(Status.INFO, "user clicked on login link");
		wdutil.enterDataUsingJS(login.getEmailTF(), putil.getDataFromPropertyfile("username"));
		Thread.sleep(2000);
		logger.log(Status.INFO, "user entered emailid");
		wdutil.enterDataUsingJS(login.getPasswordTF(),putil.getDataFromPropertyfile("password"));
		logger.log(Status.INFO, "user entered password");
		wdutil.clickOnElementUsingJS(login.getLoginbutton());
		logger.log(Status.INFO, "user clicked on loginbutton");
	}
}
