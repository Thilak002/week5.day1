package week5.day1;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends Baseservice {
	@Test
	public void deleteIncident() throws InterruptedException {
		
		//Search for the existing incident and navigate into the incident
		Thread.sleep(5000);
		//driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		//driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//table[@id='incident_table']//tr[2])[2]/td[3]/a")).click();
		driver.switchTo().defaultContent();
		
		
				
		//Delete the incident
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("(//div[@id='delete_confirm_form']//div)[4]/div")).getText();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		driver.switchTo().defaultContent();
		
		
		//Verify the deleted incident
		if(text.contains("Delete"))
			System.out.println("Incident is deleted");
		else
			System.out.println("Incident is not deleted");
		
	}
}
