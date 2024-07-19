


package PlanetMFGProject.copy;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class pentacleLoginPage {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebElement Element;
	 
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    
	    driver.get("https://pentacle.audioshots.app/login");
	    //Thread.sleep(5000);
	    driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");
	    driver.findElement(By.name("password")).sendKeys("superAdmin@123");
	   driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();
	     
	   
	   
	   //Actions act = new Actions(driver);
       driver.findElement(By.xpath(" /html/body/div/div/section/div[1]/div/div[2]/div[3]/ul/li/a")).click();
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       WebElement employeeHeader = driver.findElement(By.cssSelector("h5.text-green.sub-menu-title.mb-2.rounded.p-2.text-green"));
       
       // Verify the text of the element
       String expectedText = "Employees";
       assertEquals(expectedText, employeeHeader.getText());

       
   }

 
}
