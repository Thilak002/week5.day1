package week5.day1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseservice {
public ChromeDriver driver;
	
	@BeforeMethod
	public void login() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
		
		//Launch the Driver
		
		 driver=new ChromeDriver();
		
		//Load the URL
		
		driver.get("https://dev123839.service-now.com/navpage.do");
		
		//Maximise the Browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame("gsft_main");
		//Enter userName and password and click Login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("rAJ321#@!");
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();
		//Search “incident “ Filter Navigator
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
}}
