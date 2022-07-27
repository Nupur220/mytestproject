package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {
	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public  WebDriver Initializedriver() throws IOException
	{


		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\my prg fold\\Myproject1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");

			 driver =new ChromeDriver();



		}
		/*if(browserName.equals("firefox"))

		{
			System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");

			WebDriver driver = new FirefoxDriver();

		}*/


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException

	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File (destinationFile));
		return destinationFile;
	}



}



