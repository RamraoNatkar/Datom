package seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DatomLogin_Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\drivers\\chromedriver91.0.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://accounts.datoms.io/login");
		//step:1 to check the Login heading is displayed or not
		boolean loginHeading=driver.findElement(By.xpath("//div[contains(text(),'Login')]")).isDisplayed();
		System.out.println(loginHeading);
		//Step:2 to check username text box is functionin i.e taking inputs
		//and checking the negative flow with invalid username
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("user123");
		//Step3:to check the functioning of the password textbox
		//with invalid password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("user@123");
		
		//to check the login button is availage or not
		WebElement loginBtn=driver.findElement(By.xpath("//input[@id='form_submit_btn']"));
		System.out.println(loginBtn.isEnabled());
		loginBtn.click();
		String Expectedmessage="Please enter a valid email!";
		String message=driver.findElement(By.xpath("//div[@id='show_message']")).getText();
		Assert.assertEquals(message, Expectedmessage);
		//to check the forgot password is working or not
		String titlebefore=driver.getTitle();
		driver.findElement(By.xpath("//a[text()='Forgot Password ?']")).click();
		String titleafter=driver.getTitle();
		Assert.assertNotEquals("titlebefore", "titleafter");
		driver.close();
		//I have worker in hybrid frameword using TestNG and POM with page factory and 
		//I also have the basic knowledge about the Cucumber.
		
	}

}
