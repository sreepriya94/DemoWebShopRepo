package compareProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)

public class DWS_CompareProduct_06_Test extends BaseClass{
	@Test(groups = "STM")
	public void verify_User_Is_Able_To_Remove_Products_From_Compare_Products()
	{

		wdutil.explicitWaitReference(10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Computers")));
		wdutil.clickOnElementUsingJS(cppage.getComputerlink());
		wdutil.clickOnElementUsingJS(cppage.getDesktopproductslink());
		wdutil.clickOnElementUsingJS(cppage.getCheapcomputerlink());
		wdutil.clickOnElementUsingJS(cppage.getComparelistlink());
		driver.navigate().back();
		driver.navigate().back();
		wdutil.clickOnElementUsingJS(cppage.getYourcomputerlink());
		wdutil.clickOnElementUsingJS(cppage.getComparelistlink());
		wdutil.clickOnElementUsingJS(cppage.getRemovebutton());
		wdutil.clickOnElementUsingJS(cppage.getRemovebutton());
		logger.log(Status.INFO, "succesfully removed 2 products from compareproduct");
	}
}
