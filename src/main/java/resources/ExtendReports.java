package resources;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {


	public static ExtentReports extent;



	@BeforeTest

	public static ExtentReports config()

	{

		// ExtentReports , ExtentSparkReporter

		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "NupurRana");
		return extent;

	}
	@Test

	public void initialDemo()

	{



		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver =new ChromeDriver();

		driver.get("https://dev.worke.io/register");

		System.out.println(driver.getTitle());

		driver.close();

		



	}



}



