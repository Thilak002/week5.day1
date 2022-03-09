package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class AssignIncident extends Baseservice {
	@Test
	public void assignIncident() throws InterruptedException {
		
		// click on open and Search for the existing incident and click on  the incident
		Thread.sleep(5000);
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		//driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//table[@id='incident_table']//tr[2])[2]/td[3]/a")).click();
		driver.switchTo().defaultContent();
		
		// Assign the incident to  Software group
		driver.switchTo().frame("gsft_main");
		WebElement assign = driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']"));
		assign.click();
		driver.switchTo().defaultContent();
		Set<String> w = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(w);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Software",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(list.get(0));
		
		
		
		
		// Update the incident with Work Notes
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("The incident is assigned to software group");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getAttribute("value");
		System.out.println(text);
		driver.switchTo().defaultContent();
		// Verify the Assignment group and Assigned for the incident
		if(text.contains("Software"))
			System.out.println("Verified thta Assignment group is Software");
		else
			System.out.println("You have assigned wrong group");
		
		
	}
}
