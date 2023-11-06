package compareProduct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class DWS_CompareProduct_05_Test extends BaseClass {
	@Test(groups = "IT")
	public void verify_User_Is_Able_To_Add_2_Products_To_Compare_Products_Page_And_Validate_Them() throws InterruptedException
	{
		//wdutil.actionsReference().moveToElement(cppage.getComputerlink()).perform();
		wdutil.explicitWaitReference(10).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Computers")));
		//Thread.sleep(2000);
		wdutil.clickOnElementUsingJS(cppage.getComputerlink());
		wdutil.clickOnElementUsingJS(cppage.getDesktopproductslink());
		//wdutil.clickOnElementUsingJS(cppage.getDesktoplink());
		wdutil.clickOnElementUsingJS(cppage.getCheapcomputerlink());
		wdutil.clickOnElementUsingJS(cppage.getComparelistlink());
		driver.navigate().back();
		driver.navigate().back();
		wdutil.clickOnElementUsingJS(cppage.getYourcomputerlink());
		wdutil.clickOnElementUsingJS(cppage.getComparelistlink());
		List<WebElement> elements = driver.findElements(By.xpath("//input[@value='Remove']"));
		int count=0;
		for (WebElement buttoncount : elements) {
			count++;
		}
		if(count==2)
		{
			logger.log(Status.INFO, "2 products are added to comparelist");
		}
	}
}
