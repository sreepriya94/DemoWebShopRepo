package price;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_Price_07_Test  extends BaseClass{
	@Test(groups = "STM")
	public void verify_user_Is_Able_To_Filter_The_Product_By_Price_And_Validate_Them()
	{

		wdutil.clickOnElementUsingJS(jwel.getJwelrylink());
		String tempprice1=jwel.getMaxprice().getText();
		String maxtempprice = tempprice1.substring(0, tempprice1.length()-3);
		int maxprice = Integer.parseInt(maxtempprice);
		wdutil.clickOnElementUsingJS(jwel.getMaxprice());
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='price actual-price']"));
		int count=0;
		for (WebElement element : products) {
			String price = element.getText();
			String tempprice = price.substring(0, price.length()-3);
			int actualprice = Integer.parseInt(tempprice);
			if(actualprice<=maxprice&&actualprice>0)
			{
			 count++;
			}
		}
		if(count==products.size())
		{
			logger.log(Status.INFO, "all products are within the selected range");
					
		}
		else
		{
			logger.log(Status.INFO, "all products are not within the selected range");
		}
		


	}
}
