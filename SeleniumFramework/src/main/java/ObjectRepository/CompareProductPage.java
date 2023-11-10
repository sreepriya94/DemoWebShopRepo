package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class CompareProductPage extends BaseClass {
public CompareProductPage(WebDriver driver) 
{
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Computers")
private WebElement  computerlink;

@FindBy(linkText = "Desktops")
private WebElement  desktoplink;

@FindBy(xpath = "//a[@title='Show products in category Desktops']")
private WebElement desktopproductslink ;

@FindBy(linkText = "Build your own cheap computer")
private WebElement cheapcomputerlink ;

@FindBy(linkText = "Build your own computer")
private WebElement yourcomputerlink ;

@FindBy(xpath = "//input[@value='Add to compare list']")
private WebElement comparelistlink ;

@FindBy(xpath = "//input[@value='Remove']")
private WebElement  removebutton;

public WebElement getComputerlink() {
	return computerlink;
}

public WebElement getDesktoplink() {
	return desktoplink;
}

public WebElement getDesktopproductslink() {
	return desktopproductslink;
}

public WebElement getCheapcomputerlink() {
	return cheapcomputerlink;
}

public WebElement getYourcomputerlink() {
	return yourcomputerlink;
}

public WebElement getComparelistlink() {
	return comparelistlink;
}

public WebElement getRemovebutton() {
	return removebutton;
}

}
