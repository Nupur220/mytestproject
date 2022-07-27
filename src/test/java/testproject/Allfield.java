package testproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobject.Registrationpage;
import resources.Base1;

public class Allfield extends Base1 {

	public static Logger log=LogManager.getLogger(Base1.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver=Initializedriver();
		log.info("driver is initialized");
	}

	@Test(dataProvider="getData")
	public void pagenavigation(String userfirstname,String lastname,String email,String phoneno,String password,String buisnessname) throws IOException, InterruptedException
	{
		

		driver.get(prop.getProperty("url"));
		log.info("we are in the home page");
		Registrationpage rp=new Registrationpage(driver);
		rp.getuserfirstname().sendKeys(userfirstname);;
		rp.getlastname().sendKeys(lastname);
		rp.getemail().sendKeys(email);
		rp.getphoneno().sendKeys(phoneno);
		rp.getpassword().sendKeys(password);
		rp.getbuisnessname().sendKeys(buisnessname);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		rp.getregister().click();
		String exp="All Fields Manadatory";
		Thread.sleep(2000);

		WebElement m = driver.findElement(By.id("toast-container"));
		String act = m.getText();
		System.out.println("Error message is: "+ act);
		
		
		Assert.assertEquals(exp, act);
		driver.quit();

	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][]=new Object[1][6];
		data[0][0] ="hari" ;
		data[0][1] ="krishna";
		data[0][2] ="harikrishna1@gmail.com";
		data[0][3] ="454545454453";
		data[0][4] ="harikrishna24";
		data[0][5] ="";



		return data;     



	}@AfterTest
	public void closedriver()
	{
		driver.close();
		log.info("the browser is closed");
	}

}






