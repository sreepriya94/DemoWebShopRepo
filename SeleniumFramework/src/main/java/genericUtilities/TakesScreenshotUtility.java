 package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakesScreenshotUtility {
	WebDriver driver;
	TakesScreenshot ts;
	public TakesScreenshotUtility(WebDriver driver)
	{
		this.driver=driver;
		ts=(TakesScreenshot)driver;
	}
	public String capturingScreenshot(String screenshotname)
	{
		File photo=ts.getScreenshotAs(OutputType.FILE);
		String time = LocalDateTime.now().toString().replace(':', '-');
		String directory = System.getProperty("user.dir");
		// if we want this photo in our extent report directly we can't copy from errorshot and paste in report.
		//for that we need to go to the root of error shots folder.to get the root path of our selenium workspace
		//we are using system.getproperty and that pathalong with errorshot path we will return for generating report
		String path = ""+directory+"./target/snapshot/"+screenshotname+"  "+time+".png";
		
		File destination=new File(path);
		try {
			FileUtils.copyFile(photo, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
		
	}
}
