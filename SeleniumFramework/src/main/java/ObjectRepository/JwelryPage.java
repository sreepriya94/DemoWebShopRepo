package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class JwelryPage extends BaseClass{
	
	public JwelryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='PriceRange'])[2]")
	private WebElement maxprice ;
	
	@FindBy(linkText = "Jewelry")
	private WebElement  jwelrylink;
	
	@FindBy(linkText = "Create Your Own Jewelry")
	private WebElement yourjwel ;
	
	@FindBy(linkText = "Black & White Diamond Heart")
	private WebElement blackandwhitejwel;
	

	public WebElement getYourjwel() {
		return yourjwel;
	}

	public WebElement getBlackandwhitejwel() {
		return blackandwhitejwel;
	}

	public WebElement getMaxprice() {
		return maxprice;
	}
	
	public WebElement getJwelrylink() {
		return jwelrylink;
	}

	
	
}
