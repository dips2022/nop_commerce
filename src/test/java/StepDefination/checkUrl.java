package StepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkUrl {
 WebDriver driver;	

@Given("open browser & enter url")
public void open_browser_enter_url() {
	System.setProperty("webdriver.chrome.chrome.driver", "C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");
    
	 driver = new ChromeDriver();
     
}

@Given("Check url is valid")
public void check_url_is_valid() {
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
     
}

@When("select checkboxes")
public void select_checkboxes() {
	List<WebElement> checkbox = driver.findElements(By.id("checkBoxOption1"));
	
	for(WebElement check : checkbox) {
    	check.click();
    }
	
    
}

@When("select an option from dropdown")
public void select_an_option_from_dropdown() {
  WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
  

  Select sel = new Select(dropdown);

  sel.selectByIndex(1);
     
}

@When("enter text in textbox")
public void enter_text_in_textbox() {
     driver.findElement(By.id("autocomplete")).sendKeys("hello Everyone!");
}

@When("select radio button")
public void select_radio_button() {
	 List<WebElement> radiobtn = driver.findElements(By.xpath("//input[@value = 'radio1']"));
	for(WebElement check : radiobtn) {
    	check.click();
    }
    
}

@Then("click on link")
public void click_on_link() {
  driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
    
}

@Then("new window open successfully")
public void new_window_open_successfully() {
	System.out.println("Link open successfully");
    
}



}
