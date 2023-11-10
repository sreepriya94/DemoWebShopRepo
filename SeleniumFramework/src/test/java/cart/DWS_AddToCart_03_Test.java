package cart;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class DWS_AddToCart_03_Test extends BaseClass {
	@Test(groups = "IT")
	public void verify_user_is_able_to_add_product_virtual_gift_to_cart_and_valiadte() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(login.getLoginlink());
		wdutil.enterDataUsingJS(login.getEmailTF(), putil.getDataFromPropertyfile("username"));
		wdutil.enterDataUsingJS(login.getPasswordTF(),putil.getDataFromPropertyfile("password"));
		wdutil.clickOnElementUsingJS(login.getLoginbutton());
		boolean  result=cart.getLogoutlink().isDisplayed();
		assertTrue(result,"user successfully logged in");
		logger.log(Status.INFO, "user successfully logged in"); 
		wdutil.clickOnElementUsingJS(cart.getItemname());
		wdutil.enterDataUsingJS(cart.getReceipentemail(), putil.getDataFromPropertyfile("username"));
		wdutil.enterDataUsingJS(cart.getReceipentname(),putil.getDataFromPropertyfile("firstname"));
		wdutil.clickOnElementUsingJS(cart.getAddtocartbutton());
		logger.log(Status.INFO, "user clicked on addtocart button"); 
		driver.navigate().back();
		Thread.sleep(2000);
		wdutil.clickOnElementUsingJS(cart.getSoppingcartlink());
		boolean status=cart.getItemname().isDisplayed();
		assertTrue(status, "item successfully added to cart");
		logger.log(Status.INFO, "user verifid that item is added to cart page"); 
	}
}
