package wishList;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners(ITestListenerUtility.class)
public class DWS_WishList_10_Test extends BaseClass {
	@Test(groups = "STM")
	public void verify_User_Is_Able_To_Remov_A_Product_From_Wishlist() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(jwel.getJwelrylink());	
		wdutil.clickOnElementUsingJS(jwel.getBlackandwhitejwel());
		wdutil.clickOnElementUsingJS(wishpage.getWishlistbutton());
		driver.navigate().back();
		wdutil.clickOnElementUsingJS(jwel.getYourjwel());
		wdutil.enterDataUsingJS(wishpage.getLengthTF(), "10");
		wdutil.clickOnElementUsingJS(wishpage.getWishlistbutton());
		Thread.sleep(2000);
		wdutil.clickOnElementUsingJS(wishpage.getWishlistlink());	
		wdutil.clickOnElementUsingJS(wishpage.getRemovecheckbokofyourjwel());
		wdutil.clickOnElementUsingJS(wishpage.getRemovecheckboxofblackandwhitejwel());
		wdutil.clickOnElementUsingJS(wishpage.getUpdatebutton());
		Thread.sleep(2000);
		boolean balckandwhite = jwel.getBlackandwhitejwel().isDisplayed();
		boolean yourjwel = jwel.getYourjwel().isDisplayed();
		assertEquals(balckandwhite, yourjwel);
		logger.log(Status.INFO, "both the items are removed from the wishlist and validated");
	}

}
