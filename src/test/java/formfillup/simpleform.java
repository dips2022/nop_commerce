package formfillup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class simpleform {
	WebDriver driver;

@Given("open browser & enter the url")
public void open_browser_enter_the_url() {
	System.setProperty("webdriver.chrome.chrome.driver", "C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");
    
	 driver = new ChromeDriver();
}

@Given("check url is validated")
public void check_url_is_validated() {
	 driver.get("https://v1.training-support.net/selenium/simple-form");
}

@When("users enter username")
public void users_enter_username() {
	driver.findElement(By.id("firstName")).sendKeys("dipali");

}

@When("users enter lastname")
public void users_enter_lastname() {
	driver.findElement(By.id("lastName")).sendKeys("Sonawane");

}

@When("users enter email")
public void users_enter_email() {
	driver.findElement(By.id("email")).sendKeys("dipalisonawane1999@gmail.com");

}

@When("users enter contact")
public void users_enter_contact() {
    driver.findElement(By.id("number")).sendKeys("9325123453");

}

@When("users enter message")
public void users_enter_message() {
	driver.findElement(By.xpath(" //textarea[@ rows='2']")).sendKeys("hello everyone!");    

}

@Then("user clicks on submit button")
public void user_clicks_on_submit_button() {
	driver.findElement(By.xpath("//input[@class = 'ui green button']")).click();    

}

@Then("pop-up show thank you for reaching out to us")
public void pop_up_show_thank_you_for_reaching_out_to_us() throws InterruptedException {
	driver.findElement(By.xpath("//input[@class = 'ui green button']")).click();
	Thread.sleep(5000);

}



}
