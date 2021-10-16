package stepdefinations;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registation {
	
	WebDriver driver = null;
	
	@BeforeTest 
	@Given("user is on registration page")
	public void user_is_on_registration_page() throws InterruptedException {
	//String projectPath = System.getProperty("user.dir");
		
	System.out.println("");	
	System.setProperty("webdriver.chrome.driver","C:/Users/HP/eclipse-workspace/mystore/src/test/resources/drivers/chromedriver.exe");
	
	driver = new ChromeDriver();
			
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	Thread.sleep(2000);
	
	driver.navigate().to("http://automationpractice.com/index.php");
	Thread.sleep(2000);
	}

	@When("enter details")
	public void enter_details() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("kapilkatta0075@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='SubmitCreate']")).click();
		Thread.sleep(5000);
		
		int p1 = driver.findElements(By.xpath("//h3[contains(text(),'Already registered?')]")).size();		
		System.out.println(p1);		
		if(driver.findElements(By.xpath("//h3[contains(text(),'Already registered?')]")).size() != 0){			
			Thread.sleep(5000);
			//String  info = driver.findElement(By.xpath("//h1[contains(text(),'Create')]")).getText();
			//System.out.println(info);	
			System.out.println("Element is Present");	
			System.out.println("Already registered?");
			driver.findElement(By.xpath("//*[@id='email']")).sendKeys("kapilkatta123@gmail.com");
			driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("kapil@123");			
			driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
			}
		else{				
			Thread.sleep(5000);
			System.out.println("Element is Absent");
			driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
					
			driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("kapil");
			driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys("katta");
			driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("kapil@123");
			
			Select sobj = new Select(driver.findElement(By.id("days")));
			
			sobj.selectByValue("15");
			
			Select sobj1 = new Select(driver.findElement(By.id("months")));
			sobj1.selectByIndex(10);
			
		
		

			Select sobj2 = new Select(driver.findElement(By.id("years")));
			sobj2.selectByValue("1995");
			
			driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("ADP private limited");
			driver.findElement(By.xpath("//*[@id='city']")).sendKeys("hyderabad");
			
			Select sobj3 = new Select(driver.findElement(By.id("id_state")));
			sobj3.selectByValue("15");

			driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("00000");
			
			//Select sobj4 = new Select(driver.findElement(By.id("id_country")));
			//sobj4.selectByValue("United States");

			driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("5648785247");
			
			driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("kapil@gmail.com");
			
			}
		
		
		
	

		
	}

	@When("click register")
	public void click_register() {
		
		driver.findElement(By.xpath("//*[@id='submitAccount']")).click();
	   
	}

	@Then("user is navigated to  home page")
	public void user_is_navigated_to_home_page() {
			String str1 =	driver.findElement(By.xpath("//*[@title='View my customer account']")).getText();
			assertEquals(str1,"kapil katta"); 
			System.out.println("login successfull");
	}
	
	@Given("select item")
	public void select_item() {
	   
		driver.findElement(By.xpath("//*[@id='T-shirts']")).click();
		driver.findElement(By.xpath("//*[@title='Add to cart']")).click();
	}

	@When("add to cart")
	public void add_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='Proceed to checkout']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='Proceed to checkout']")).click();
	   
	}

	@When("procced further")
	public void procced_further() {
		driver.findElement(By.xpath("//*[@id='processAddress']")).click();
		driver.findElement(By.xpath("//*[@id='cgv']")).click();
		driver.findElement(By.xpath("//*[@id='processCarrier']")).click();
		driver.findElement(By.xpath("//*[@id='Log me out']")).click();
	}

	@Then("shipping and confirmation page")
	public void shipping_and_confirmation_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}


//Proceed to checkout
//Proceed to checkout
//processAddress
//processCarrier
//
//cgv
//
//Log me out
