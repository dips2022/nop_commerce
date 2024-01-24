package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
	
	WebDriver driver;
 
	@Given("open the browser enter the url")
	public void open_the_browser_enter_the_url() {
		
		 System.setProperty("webdriver.chrome.chrome.driver", "C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");
         
		 driver = new ChromeDriver();
		
   	}

	@Given("make sure the url is validated")
	public void make_sure_the_url_is_validated() {
	    // Write code here that turns the phrase above into concrete actions
		
	    driver.get("https://the-internet.herokuapp.com/login");

 	}

	@When("user enters username")
	public void user_enters_username() {
	    // Write code here that turns the phrase above into concrete actions
 	   driver.findElement(By.id("username")).sendKeys("deepali");
	}

	@When("user enters password")
	public void user_enters_password() {
	    // Write code here that turns the phrase above into concrete actions
	 	   driver.findElement(By.id("password")).sendKeys("deepali1234");

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
 	   driver.findElement(By.xpath("//button[@class='radius']")).click();
	}

	@Then("login should happen succssfully")
	public void login_should_happen_succssfully() {
	    // Write code here that turns the phrase above into concrete actions
 	   System.out.println("User successfully lognedin");
	}

	@Then("home page should be displayed")
	public void home_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
 	System.out.println("Home page open successfully");
	}


}
