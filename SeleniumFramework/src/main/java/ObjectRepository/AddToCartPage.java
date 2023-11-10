package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
public AddToCartPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "$25 Virtual Gift Card")
private WebElement itemname ;
@FindBy(id = "giftcard_2_RecipientName")
private WebElement receipentname ;
@FindBy(id = "giftcard_2_RecipientEmail")
private WebElement receipentemail ;
@FindBy(id = "add-to-cart-button-2")
private WebElement addtocartbutton ;
@FindBy(xpath = "//span[text()='Shopping cart']")
private WebElement soppingcartlink;
@FindBy(linkText = "Log out")
private WebElement logoutlink;
@FindBy(linkText = "Books")
private WebElement bookslink;
@FindBy(linkText = "Computing and Internet")
private WebElement bookname ;
@FindBy(id = "add-to-cart-button-13")
private WebElement bookaddtocartbutton;
public WebElement getBookslink() {
	return bookslink;
}
public WebElement getBookname() {
	return bookname;
}
public WebElement getBookaddtocartbutton() {
	return bookaddtocartbutton;
}
public WebElement getItemname() {
	return itemname;
}
public WebElement getReceipentname() {
	return receipentname;
}
public WebElement getReceipentemail() {
	return receipentemail;
}
public WebElement getAddtocartbutton() {
	return addtocartbutton;
}
public WebElement getSoppingcartlink() {
	return soppingcartlink;
}
public WebElement getLogoutlink() {
	return logoutlink;
}

}

