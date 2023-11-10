package genericUtilities;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ITestListenerUtility extends BaseClass  implements ITestListener{
  
	
	public static ExtentReports report;
	ExtentSparkReporter reporter;
	
	public void onTestStart(ITestResult result) {
		logger=report.createTest(result.getName()); 
	}

	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "The test "+result.getName()+" is passed");
	}


	public void onTestFailure(ITestResult result) {
		
		logger.addScreenCaptureFromPath(tsutil.capturingScreenshot(result.getName()));
	}

	public void onStart(ITestContext context) {
		
		reporter = new ExtentSparkReporter("./reports/DWS"+LocalDateTime.now().toString().replace(':', '-')+".html");
		report=new ExtentReports();
		reporter.config().setDocumentTitle("this is title");
		reporter.config().setReportName("sample");
		report.attachReporter(reporter);
	}

	public void onFinish(ITestContext context) {
		report.flush();

	}
}