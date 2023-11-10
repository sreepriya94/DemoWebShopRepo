package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.BaseClass;

public class EmailPage extends BaseClass{
	public WebElement getEmailbutton() {
		return emailbutton;
	}

	public WebElement getToemailTF() {
		return toemailTF;
	}

	public WebElement getFromemailTF() {
		return fromemailTF;
	}

	public WebElement getMessageTF() {
		return messageTF;
	}

	public WebElement getSendmailbutton() {
		return sendmailbutton;
	}

	public WebElement getJwelname() {
		return jwelname;
	}

	public EmailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@value='Email a friend']")
	private WebElement emailbutton;

	@FindBy(id = "FriendEmail")
	private WebElement toemailTF ;

	@FindBy(id = "YourEmailAddress")
	private WebElement fromemailTF ;

	@FindBy(id = "PersonalMessage")
	private WebElement messageTF ;

	@FindBy(name = "send-email")
	private WebElement sendmailbutton;

	@FindBy(linkText = "Create Your Own Jewelry")
	private WebElement jwelname;
}
