package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import genericUtilities.BaseClass;

public class WishListPage extends BaseClass{
	public WishListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@value='Add to wishlist']")
	private WebElement wishlistbutton;
	
	@FindBy(xpath = "//input[@class='textbox']")
	private WebElement lengthTF ;

	@FindBy(xpath = "//a[text()='Black & White Diamond Heart']//preceding::input[@name='removefromcart'][1]")
	private WebElement removecheckboxofblackandwhitejwel ;

	public WebElement getWishlistbutton() {
		return wishlistbutton;
	}

	public WebElement getLengthTF() {
		return lengthTF;
	}

	public WebElement getRemovecheckboxofblackandwhitejwel() {
		return removecheckboxofblackandwhitejwel;
	}

	public WebElement getUpdatebutton() {
		return updatebutton;
	}

	public WebElement getWishlistlink() {
		return wishlistlink;
	}

	public WebElement getRemovecheckbokofyourjwel() {
		return removecheckbokofyourjwel;
	}
	@FindBy(name = "updatecart")
	private WebElement updatebutton ;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishlistlink ;
	
	@FindBy(xpath = "//a[text()='Create Your Own Jewelry']//preceding::input[@name='removefromcart']")
	private WebElement removecheckbokofyourjwel ;

}
