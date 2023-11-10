package cart;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;
@Listeners(ITestListenerUtility.class)
public class DWS_AddToCart_04_Test extends BaseClass {
	@Test(groups = "IT")
	public void verify_user_is_able_to_add_the_product_computing_and_internet_from_book_module()
	{
		wdutil.clickOnElementUsingJS(login.getLoginlink());
		wdutil.enterDataUsingJS(login.getEmailTF(), putil.getDataFromPropertyfile("username"));
		wdutil.enterDataUsingJS(login.getPasswordTF(),putil.getDataFromPropertyfile("password"));
		wdutil.clickOnElementUsingJS(login.getLoginbutton());
		boolean  result=cart.getLogoutlink().isDisplayed();
		assertTrue(result,"user successfully logged in");
		logger.log(Status.INFO, "user successfully logged in"); 
		wdutil.clickOnElementUsingJS(cart.getBookslink());
		wdutil.clickOnElementUsingJS(cart.getBookname());
		wdutil.clickOnElementUsingJS(cart.getBookaddtocartbutton());
		driver.navigate().back();
		wdutil.clickOnElementUsingJS(cart.getSoppingcartlink());
		boolean status=cart.getBookname().isDisplayed();
		assertTrue(status, "item successfully added to cart");
		logger.log(Status.INFO, "user verifid that item is added to cart page"); 
	}
}
