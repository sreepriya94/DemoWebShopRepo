package wishList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtilities.BaseClass;
import genericUtilities.ITestListenerUtility;

@Listeners
(ITestListenerUtility.class)
public class DWS_WishList_09_Test extends BaseClass{
	@Test(groups = "IT")
	public void verify_User_Is_Able_To_add_A_Product_To_Wishlist_And_Validatde_It() throws InterruptedException
	{
		wdutil.clickOnElementUsingJS(jwel.getJwelrylink());	
		wdutil.clickOnElementUsingJS(jwel.getBlackandwhitejwel());
		wdutil.clickOnElementUsingJS(wishpage.getWishlistbutton());
		Thread.sleep(3000);
		boolean item1 = driver.findElement(By.xpath("//div[@id='bar-notification']//child::p")).isDisplayed();
		assertTrue(item1);
		System.out.println("item1added");
		driver.navigate().back();
		wdutil.clickOnElementUsingJS(jwel.getYourjwel());
		wdutil.enterDataUsingJS(wishpage.getLengthTF(), "10");
		wdutil.clickOnElementUsingJS(wishpage.getWishlistbutton());
		Thread.sleep(2000);
		boolean item2 = driver.findElement(By.xpath("//div[@id='bar-notification']//child::p")).isDisplayed();
		assertTrue(item2);
		System.out.println("item2 added");
		wdutil.clickOnElementUsingJS(wishpage.getWishlistlink());
		boolean balckandwhite = jwel.getBlackandwhitejwel().isDisplayed();
		boolean yourjwel = jwel.getYourjwel().isDisplayed();
		assertEquals(yourjwel, balckandwhite, "both items are added to wishlist");
		logger.log(Status.INFO, "both items are added to wishlist and validated");

	}
}
