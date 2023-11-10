package email;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Email_08_Test extends BaseClass {
	@Test(groups = "FT")
	public void verify_User_Is_Able_To_Send_Mail_And_Validate_The_Error_Message() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(jwel.getJwelrylink());
		wdutil.clickOnElementUsingJS(emailpage.getJwelname());
		wdutil.clickOnElementUsingJS(emailpage.getEmailbutton());
		wdutil.enterDataUsingJS(emailpage.getToemailTF(), putil.getDataFromPropertyfile("username"));
		wdutil.enterDataUsingJS(emailpage.getFromemailTF(), putil.getDataFromPropertyfile("username"));
		wdutil.clickOnElementUsingJS(emailpage.getSendmailbutton());
		Thread.sleep(5000);
		String expectedresult = "Only registered customers can use email a friend feature";
		String actualresult = driver.findElement(By.xpath("//div[@class='message-error']//child::li")).getText();
		assertEquals(actualresult, expectedresult, actualresult);
		logger.log(Status.INFO, "The error message has been validated");

	}
}
