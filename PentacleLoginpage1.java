package mavenPentacleProjectDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class PentacleLoginpage1 {

	public String baseurl= "https://pentacle.audioshots.app/login";
	public WebDriver driver ;

	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test Executed");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Open URL
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test (priority = 1)
	public void doLoginWithInValidCredentials() throws InterruptedException
	{
		//find Email & enter email ("hr@weoto.in")
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");

		//find Password & enter password ("superAdmin@123")
		driver.findElement(By.name("password")).sendKeys("superAdmin@124");//Wrong Password

		//click on submit button
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();

		String message_expected = "Invalid Credentials";
		String message_actual = driver.findElement(By.xpath("/html/body/div/div[1]/div/span[2]")).getText();
		//Invalid email or password

		Assert.assertEquals(message_expected, message_actual);
		Thread.sleep(1500);

	}

	@Test (priority = 2)
	public void logintestWithValidcredentials() {
		//find Email & enter email ("hr@weoto.in")
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");

		//find Password & enter password ("superAdmin@123")
		driver.findElement(By.name("password")).sendKeys("superAdmin@123");

		//click on submit button
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();

		//verify if the login was successfully by checking the page title or a specific element 
		String pageTitle = driver.getTitle();

		/*	if (pageTitle.equals("pentacle.audioshots.app")) {
			System.out.println("Login Successful!");
		}
		else {
			System.out.println("Login Failed!");
		}*/

		Assert.assertEquals("Pentacle ERP", pageTitle);
	}

	@Test (priority=3)
	public void addEmployee() 

	{   //Click on HR
		driver.findElement(By.xpath("//h2[contains(text(),'HR')]")).click();

		// Step 7: Click on Employees
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[1]/div/div[2]/div[3]/ul/li/ul/li[1]/a/span")).click();
		//Step 8 :Click on Add Employee Button 
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/main/div/div[1]/div/div[2]/button[3]")).click(); 

		//Step 9: Add on Employees Details 
		driver.findElement(By.name("firstName")).sendKeys("Kalyani");
		driver.findElement(By.name("lastName")).sendKeys("Patil"); 
	}


	public void logout()
	{
		((WebElement) driver.findElements(By.xpath("/html/body/div[1]/div/section/div[2]/div/nav/header/ul[3]/li[1]/button/span"))).click();
		((WebElement) driver.findElements(By.xpath("//*[@id=\"react-aria1455909104-:r1q:\"]"))).click();
	}


	@AfterTest
	public void tearDown() throws InterruptedException {


		Thread.sleep(10000);//wait for 5 sec before quit

		driver.close();
		driver.quit();
	}
}
