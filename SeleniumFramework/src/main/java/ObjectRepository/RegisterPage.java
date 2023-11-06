package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  @FindBy(linkText = "Register")
  private WebElement registerlink;
  @FindBy(id = "FirstName")
  private WebElement firstnameTF ;
  @FindBy(id = "LastName")
  private WebElement lastnameTF;
  @FindBy(id = "Email")
  private WebElement emailTF ;
  @FindBy(id = "Password")
  private WebElement  passwordTF;
  @FindBy(id = "ConfirmPassword")
  private WebElement confirmpwdTF ;
  @FindBy(id = "register-button")
  private WebElement registerbutton ;
  @FindBy(name = "Gender")
  private List<WebElement> selectgender;
public WebElement getRegisterlink() {
	return registerlink;
}
public WebElement getFirstnameTF() {
	return firstnameTF;
}
public WebElement getLastnameTF() {
	return lastnameTF;
}
public WebElement getEmailTF() {
	return emailTF;
}
public WebElement getPasswordTF() {
	return passwordTF;
}
public WebElement getConfirmpwdTF() {
	return confirmpwdTF;
}
public WebElement getRegisterbutton() {
	return registerbutton;
}
public List<WebElement> getSelectgender() {
	return selectgender;
}
}
