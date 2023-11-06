package genericUtilities;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author sreepriya
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	JavascriptExecutor js;
	public WebDriverUtility(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	/**
	 * This method is developed to click on any element by passing the element as parameter
	 * @param element
	 */
	public void clickOnElementUsingJS(WebElement element)
	{
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * this method is developed to enter data into the text field by accepting element as a parameter
	 * @param element
	 * @param data
	 */
	public void enterDataUsingJS(WebElement element,String data)
	{
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
	/**
	 * This method is developed to get the reference variable for WebDriver wait
	 * @param time
	 * @return WebDriver wait reference variable
	 */
	public WebDriverWait explicitWaitReference(int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
	}
	/**
	 * This method is developed to get the reference for action class
	 * @return Actions class reference variable
	 */
	public Actions actionsReference()
	{
		Actions action=new Actions(driver);
		return action;
	}
	/**
	 * This method is developed to select a drop down from single select drop down element which are developed using select tag
	 * @param dropdown 
	 * @param option
	 */
	public void handleDropdowns(WebElement dropdown,String option)
	{
		Select s = new Select(dropdown);
		try {
			s.selectByVisibleText(option);
		} catch (Exception e) {

			try {
				s.selectByValue(option);

			} catch (Exception e1) {
				s.selectByIndex(Integer.parseInt(option));
			}
		}
	}
	/**
	 * This method is developed to  scroll the webpage to the given cordinates only once.
	 * @param x cordinate
	 * @param y cordinate
	 */
	public void scrollByWebPage(int x,int y)
	{
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * This method is developed to scroll the webpage to the given cordinates repeatedly.
	 * @param x cordinate
	 * @param y cordinate
	 */
	public void scrollToWebpage(int x, int y)
	{
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	/**
	 * This method is developed to scroll the webpage utill an element is visible
	 * @param element
	 * @param status
	 */
	public void scrollIntoView(WebElement element, boolean status)
	{
		js.executeScript("arguments[0].scrollIntoView("+status+")", element);
	}
	/**
	 * This method is developed to switch to iframe using name of the i frame
	 * @param name of the iframe
	 */
	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method is developed to switch to iframe using element in the frame
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is developed to switch to ifarme using index number of iframe
	 * @param index of iframe
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is developed to switch back to the parent window from iframe
	 */
	public void switchToParentFrame() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is developed to switch to alert
	 * @return the alert reference
	 */
	public Alert switchToAlert()
	{
		return driver.switchTo().alert();
	}
	/**
	 * This method is developed to switch to  any child window from main window
	 * @param allid of all windows opened through selenium
	 * @param expectedtitle is the title of the page which i want to work with
	 */
	public void switchToWindow( Set<String> allid,String expectedtitle)
	{
		
		for (String id : allid) {

			driver.switchTo().window(id);
			if(driver.getTitle().contentEquals(expectedtitle))
			{
				driver.manage().window().maximize();
				break;
			}
		}
	}
	/**
	 * This method is developed to switch back to parent window if the windows opened through selenium are not closed
	 * @param parentid is the id of the parent window
	 */
	public void switchBackToParentWindow(String parentid)
	{
		driver.switchTo().window(parentid);
	}

}


