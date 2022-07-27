package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registrationpage {

	public WebDriver driver;
	public Registrationpage(WebDriver driver)

	{
		this.driver=driver;	
	}
	By userfirstname=By.id("first_name");;
	By lastname=By.id("last_name");

	By email=By.id("useremail");
	By phoneno=By.id("phone_number");
	By password=By.id("userpassword");

	By buisnessname=By.xpath("//input[@placeholder='Business Name']");
	//By register=By.xpath("//button[contains(text(),'Register')]");
	By register=By.xpath("//button[@type='submit']");

	

	public WebElement getuserfirstname()
	{
		return driver.findElement(userfirstname);
	}
	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	public WebElement getphoneno()
	{
		return driver.findElement(phoneno);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	public WebElement getbuisnessname()
	{
		return driver.findElement( buisnessname);
	}
	public WebElement getregister()
	{
		return driver.findElement(register);
	}
	
}




