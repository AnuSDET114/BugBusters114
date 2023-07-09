package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "TestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine","testpc1");
		reports.setSystemInfo("OS","windows");
		reports.setSystemInfo("browser",readConfig.getBrowser());
		reports.setSystemInfo("user name:","Anu");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("DSAlgo Test Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	//OnStart method is called when any test starts
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start method invoked....");
	}
	
	//OnFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finish method invoked....");
		reports.flush();
	}
	
	//When Test case get failed, this method is called
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName() );
		test = reports.createTest(Result.getName() );
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(),ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir")+ "\\ScreenShots\\" + Result.getName() + ".png";
		
		File screenShotFile = new File(screenShotPath);
		
		if(screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
		
		//test.addScreenCaptureFromPath(null)
	}
	
	//When test case get Skipped,this method is called
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName() );
		test = reports.createTest(Result.getName() );
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(),ExtentColor.YELLOW));
	}
	
	//When test case get Started
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" + Result.getName() );
		
	}
	
	//When test case get passed
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method successfully executed:" + Result.getName() );
		test = reports.createTest(Result.getName() );
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}
	
}
	
		
	
		
		
	
	
	


