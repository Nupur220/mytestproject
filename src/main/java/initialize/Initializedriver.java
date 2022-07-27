package initialize;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Initializedriver {
	
	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\my prg fold\\Myproject1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName=="chrome")
		{
			System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver =new ChromeDriver();
		
		}
		if(browserName=="firefox")
		{
			System.setProperty("webdriver.gecko.driver","D:\\firefoxdriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");

			WebDriver driver = new FirefoxDriver();
		}
		
		
	}
	



}


