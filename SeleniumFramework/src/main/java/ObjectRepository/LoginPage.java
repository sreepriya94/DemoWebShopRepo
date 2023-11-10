package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Log in")
	private WebElement loginlink;
	@FindBy(id = "Email")
	private WebElement emailTF;
	@FindBy(id = "Password")
	private WebElement passwordTF;
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginbutton;
	public WebElement getLoginlink() {
		return loginlink;
	}
	public WebElement getEmailTF() {
		return emailTF;
	}
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}


}

