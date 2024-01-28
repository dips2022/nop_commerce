package RegisterForm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DesktopEle1 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void configReport() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport1.html");// path of file

		test = report.startTest("https://demo.nopcommerce.com/");
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		System.setProperty("webdriver.chrome.chrome.driver",

				"C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		test.log(LogStatus.PASS, "Chrome diver is opened successfully");

		driver.get("https://demo.nopcommerce.com/");

		test.log(LogStatus.PASS, " Url is opend successfully");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
    // hard assert
	@Test(priority = 1)
	public void CheckAssert() {
		String actual = driver.getTitle();

		String expected = "nopCommerce demo store";

		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expected);

		test.log(LogStatus.PASS, "Title is matched");
	}

	@Test
	public void CheckDetails() throws InterruptedException, IOException {

		Actions act = new Actions(driver);

		WebElement computers = driver.findElement(By.linkText("Computers"));

		act.moveToElement(computers).build().perform();

		driver.findElement(By.linkText("Desktops")).click();

		driver.findElement(By.linkText("Build your own computer")).click();

		WebElement dropdown = driver.findElement(By.id("product_attribute_1"));

		Select sel = new Select(dropdown);

		sel.selectByIndex(2);

		WebElement dropdown2 = driver.findElement(By.id("product_attribute_2"));

		Select sel1 = new Select(dropdown2);

		sel1.selectByIndex(2);

		List<WebElement> radiobox = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement check : radiobox) {
			check.click();
		}

		driver.findElement(By.id("add-to-cart-button-1")).click();

		driver.findElement(By.className("cart-label")).click();


		TakesScreenshot ts = (TakesScreenshot) driver;

		File file1 = ts.getScreenshotAs(OutputType.FILE);

		File file2 = new File("C:\\Users\\asus\\Pictures\\TakeScreenshot\\image.png");

		FileUtils.copyFile(file1, file2);

	}
	

	@AfterMethod(alwaysRun = true)
	public void teardown() {

		if (driver != null) {
			driver.quit();
		}

	}

	@AfterClass
	public void last() {

		report.endTest(test);
		report.flush();
	}

}
