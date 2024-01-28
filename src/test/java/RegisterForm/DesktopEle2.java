
package RegisterForm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DesktopEle2 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.chrome.driver",

				"C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

//		test.log(LogStatus.PASS, "Chrome diver is opened successfully");

//		test.log(LogStatus.PASS, " Url is opend successfully");

		driver.manage().window().maximize();

//		driver.get("https://demo.nopcommerce.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	private void AddToWishList() throws IOException {

		driver.findElement(By.linkText("Desktops")).click();

		driver.findElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,505)", "");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-wishlist-button-2")));

		driver.findElement(By.id("add-to-wishlist-button-2")).click();

		driver.findElement(By.className("wishlist-label")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file1 = ts.getScreenshotAs(OutputType.FILE);

		File file2 = new File("C:\\Users\\asus\\Pictures\\TakeScreenshot\\image2.png");

		FileUtils.copyFile(file1, file2);

	}

	@Test(priority = 1)
	public void CheckTitle() {
		driver.get("https://demo.nopcommerce.com/");
		String expectedTitle = "nopCommerce demo store";

		String originalTitle = driver.getTitle();

		Assert.assertEquals(originalTitle, expectedTitle);

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(originalTitle, expectedTitle);

		sa.assertAll();

	}

	@Test(priority = 2)
	public void Checkdetails() throws IOException, InterruptedException {
		driver.get("https://demo.nopcommerce.com/");
//		waitForPageLoad();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Computers")));

		Actions act = new Actions(driver);

		WebElement computers = driver.findElement(By.linkText("Computers"));

		act.moveToElement(computers).build().perform();

		AddToWishList();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void teardown() {

		if (driver != null) {
			driver.quit();
		}

	}

}
