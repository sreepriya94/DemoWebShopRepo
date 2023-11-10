package genericUtilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import ObjectRepository.AddToCartPage;
import ObjectRepository.CompareProductPage;
import ObjectRepository.EmailPage;
import ObjectRepository.JwelryPage;
import ObjectRepository.LoginPage;
import ObjectRepository.RegisterPage;
import ObjectRepository.WishListPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements IAutoConstantsUtility {
	public static WebDriver driver;
	public static TakesScreenshotUtility tsutil;
	public static PropertyUtility putil;
	public static DataBaseUtility dbutil;
	public static WebDriverUtility wdutil;
	public static JavaUtility jutil;
	public static ITestListenerUtility itutil;
	public static ExtentTest logger;
	public static LoginPage login;
	public static RegisterPage regpage;
	public static AddToCartPage cart;
	public static CompareProductPage cppage;
	public static JwelryPage jwel;
	public static EmailPage emailpage;
	public static WishListPage wishpage;
    
	@BeforeClass(alwaysRun = true)
	public void lauchingTheBrowserAndnavigatingToApplication()
	{
		putil=new PropertyUtility();
	    dbutil=new DataBaseUtility();
	    jutil=new JavaUtility();
	    itutil=new ITestListenerUtility();
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
	    }
	    else
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();	
	    }
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(putil.getDataFromPropertyfile("url"));
		
	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication()
	{
		tsutil=new TakesScreenshotUtility(driver);
		wdutil=new WebDriverUtility(driver);
		login=new LoginPage(driver);
		regpage=new RegisterPage(driver);
		cart=new AddToCartPage(driver);
		cppage=new CompareProductPage(driver);
		jwel=new JwelryPage(driver);
		emailpage=new EmailPage(driver);
		wishpage=new WishListPage(driver);
				
		System.out.println("logged in to the apllication");
	}
	@AfterMethod(alwaysRun = true)
	public void logoutFromAppliaction()
	{
		System.out.println("logged out from the application");
	}
	@AfterClass(alwaysRun = true) 
	public void tearDownTheBrowser()
	{
		driver.quit();	
	}

}
