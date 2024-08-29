package mavenPentacleProjectDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@BeforeMethod
	public void clearTextBox()
	{
		System.out.println("BeforeMethod");

	}
	@Test (priority=1 ,enabled=false)
	public void doLoginWithInValidCredentials() throws InterruptedException
	{
		//find Email & enter email ("hr@weoto.in")
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");

		//find Password & enter password ("superAdmin@123")
		driver.findElement(By.name("password")).sendKeys("superAdmin@124");//Wrong Password

		//click on submit button
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();

		String message_expected = "Invalid Credentials";
		String message_actual = driver.findElement(By.xpath("/html/body/div/div[1]/div/span[2]")).getText();
		//Invalid email or password

		//Assert.assertEquals(message_expected, message_actual);
		Thread.sleep(1500);

	}

	@Test (priority = 2, enabled=false)
	public void logintestWithValidcredentials() throws InterruptedException {
		//find Email & enter email ("hr@weoto.in")
		//driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");

		//find Password & enter password ("superAdmin@123")
		driver.findElement(By.name("password")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.name("password")).sendKeys("superAdmin@123");

		//click on submit button
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();

		//verify if the login was successfully by checking the page title or a specific element 
		String pageTitle = driver.getTitle();

		Thread.sleep(1000);
		//logout();

		/*	if (pageTitle.equals("pentacle.audioshots.app")) {
			System.out.println("Login Successful!");
		}
		else {
			System.out.println("Login Failed!");
		}*/

		Assert.assertEquals("Pentacle ERP", pageTitle);

	}

	@Test (priority=3 , enabled=false)
	public void addEmployee() throws InterruptedException 

	{   //Click on HR
		WebElement firstButton = driver.findElement(By.xpath("/html/body/div/div/section/div[1]/div/div[1]"));
		firstButton.click();
		// Step 6: Click on HR
		WebElement hrButton = driver.findElement(By.xpath("/html/body/div/div/section/div[1]/div/div[2]/div[3]/ul/li/a/h2"));
		hrButton.click();
		// Step 7: Click on Employees
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[1]/div/div[2]/div[3]/ul/li/ul/li[1]/a/span")).click();
		//Step 8 :Click on Add Employee Button 
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/main/div/div[1]/div/div[2]/button[3]")).click(); 
	}

	@Test(priority = 4)
	public void EnterEmployeeName() {
		// Log in to the application
		logIn();

		WebElement firstButton = driver.findElement(By.xpath("/html/body/div/div/section/div[1]/div/div[1]"));
		firstButton.click();
		
		WebElement hrButton = driver.findElement(By.xpath("/html/body/div/div/section/div[1]/div/div[2]/div[3]/ul/li/a/h2"));
		hrButton.click();
		// Step 7: Click on Employees
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[1]/div/div[2]/div[3]/ul/li/ul/li[1]/a/span")).click();
		//Step 8 :Click on Add Employee Button 
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/main/div/div[1]/div/div[2]/button[3]")).click(); 

		// Click on the search button
		//driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/main/div/div[1]/div/div[2]/button[3]")).click();

		// Step 9: Add on Employee Details
		driver.findElement(By.name("firstName")).sendKeys("Manoj");
		driver.findElement(By.name("lastName")).sendKeys("Patil");

		// Assuming there is a button to initiate the search, click it
		//driver.findElement(By.id("searchButton")).click();

		// Validate that the employee "Manoj Patil" appears in the search results
		//WebElement searchResult = driver.findElement(By.xpath("//div[contains(text(), 'Manoj Patil')]"));
		//Assert.assertTrue(searchResult.isDisplayed(), "Employee 'Manoj Patil' not found in the search results.");
	}

	public void logIn() {
		// Add the logic to log in to the application
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/div[1]/div/div[1]/div/input")).sendKeys("hr@weoto.in");
		driver.findElement(By.name("password")).sendKeys("superAdmin@123");
		driver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/div/form/button")).click();
		
	}
	
	public void logout()
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/div/nav/header/ul[3]/li[1]/button/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/ul/li[3]/span")).click();
		//((WebElement) driver.findElements(By.xpath("/html/body/div[1]/div/section/div[2]/div/nav/header/ul[3]/li[1]/button/span"))).click();
		//((WebElement) driver.findElements(By.xpath("//*[@id=\"react-aria9218006054-:r76:\"]"))).click();
	}


	@AfterTest
	public void tearDown() throws InterruptedException {


		Thread.sleep(5000);//wait for 5 sec before quit

		//driver.close();
		driver.quit();
	}
}
