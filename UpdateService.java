package week5.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateService extends Baseservice{
	@Test
	public void updateService() {
		
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		// Search for the existing incident and click on the incident
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]/a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.id("incident.number")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		
		// Update the incidents with Urgency as High and State as In Progress
		driver.switchTo().frame("gsft_main");
		WebElement dd = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select dropDown=new Select(dd);
		String urgency = dd.getText();
		dropDown.selectByValue("1");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("gsft_main");
		WebElement dd1 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select dropDown1=new Select(dd1);
		dropDown1.selectByValue("2");
		String state = dd1.getText();
		System.out.println(state);
		driver.switchTo().defaultContent();
		
		// Verify the priority and state 
		if(urgency.contains("High") && state.contains("In Progress"))
			System.out.println("Verified the priority and state");
		
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		driver.switchTo().defaultContent();
		
		
		
	}		
}
