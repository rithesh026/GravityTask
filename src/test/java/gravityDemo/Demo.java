package gravityDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Configure the Exe file
		WebDriverManager.chromedriver().setup();
		
		//Launch browser
		ChromeDriver driver = new ChromeDriver();
		
		// Maxixmize browser
		driver.manage().window().maximize();
		
		//Nav to application via url
		driver.get("https://www.amazon.in");
		
		
		try 
		{
			driver.findElement(By.className("a-button-text")).click();
		}
		catch (Exception e) {
			System.out.println("No popup appeared");
		}
    
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.findElement(By.id("ap_email_login")).sendKeys("8522982294");
		
		driver.findElement(By.className("a-button-input")).click();
	
		driver.findElement(By.id("ap_password")).sendKeys("Rithesh@123");
		
		driver.findElement(By.className("a-button-input")).click();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile phones");
	
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.xpath("(//*[@class=\"a-size-medium a-spacing-none a-color-base a-text-normal\"])[1]")).click();
		
		//driver.findElement(By.id("submit.add-to-cart-announce")).click();
		
		driver.close();
		
		
		
		

	}

}
