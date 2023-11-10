package signUp;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class DWS_Register_02_Test extends BaseClass {
	@Test(groups = "FT")
	public void verify_user_is_able_to_register_with_valid_details() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(regpage.getRegisterlink());
		logger.log(Status.INFO, "user clicked on register link");
		wdutil.enterDataUsingJS(regpage.getFirstnameTF(), putil.getDataFromPropertyfile("firstname"));
		logger.log(Status.INFO, "user entered firstname");
		wdutil.enterDataUsingJS(regpage.getLastnameTF(), putil.getDataFromPropertyfile("lastname"));
		logger.log(Status.INFO, "user entered lastname");
		wdutil.enterDataUsingJS(regpage.getEmailTF(), putil.getDataFromPropertyfile("username"));
		logger.log(Status.INFO, "user entered emailid");
		wdutil.enterDataUsingJS(regpage.getPasswordTF(), putil.getDataFromPropertyfile("password"));
		logger.log(Status.INFO, "user entered password");
		wdutil.enterDataUsingJS(regpage.getConfirmpwdTF(), putil.getDataFromPropertyfile("pasword"));
		logger.log(Status.INFO, "user confirmed password");
		Thread.sleep(2000);
		for (WebElement element : regpage.getSelectgender()) {
			if(element.getAttribute("value").contains("F"))
			{
				wdutil.clickOnElementUsingJS(element);
			}
		}
		logger.log(Status.INFO, "user selected the gender");
		wdutil.clickOnElementUsingJS(regpage.getRegisterbutton());
		logger.log(Status.INFO, "user clicked on register button");
	}

}
