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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DesktopEle3 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void configReport() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport1.html");// path of file

		test = report.startTest("nopCommerce"); // test report
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {

		System.setProperty("webdriver.chrome.chrome.driver",

				"C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		test.log(LogStatus.PASS, "Chrome diver is opened successfully");

		driver.manage().window().maximize();

//		driver.get("https://demo.nopcommerce.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	private void AddToWishList() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops"))).click();
		test.log(LogStatus.PASS, "  Element clicked successfully");

//		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Lenovo IdeaCentre 600 All-in-One PC"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		//element 2
		
		driver.findElement(By.linkText("Digital Storm VANQUISH 3 Custom Performance PC")).click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,505)", "");
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-wishlist-button-2")));

		driver.findElement(By.id("add-to-wishlist-button-2")).click();

		driver.findElement(By.className("wishlist-label")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file1 = ts.getScreenshotAs(OutputType.FILE);

		File file2 = new File("C:\\Users\\asus\\Pictures\\TakeScreenshot\\image2.png");

		FileUtils.copyFile(file1, file2);
		

	}

		 

	@Test(groups = { "smoke" })
	public void CheckTitle() {
		driver.get("https://demo.nopcommerce.com/");
		test.log(LogStatus.PASS, " Url is opend successfully");

		String expectedTitle = "nopCommerce demo store";

		String originalTitle = driver.getTitle();

		Assert.assertEquals(originalTitle, expectedTitle);
		test.log(LogStatus.PASS, " Title matched successfully");

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(originalTitle, expectedTitle);
		test.log(LogStatus.PASS, " Title matched successfully");

		sa.assertAll();

	}

	@Test(groups = { "sanity" })
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

	@Test(groups = { "Regression" })
	public void Email() throws InterruptedException, IOException {
		driver.get("https://demo.nopcommerce.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Computers")));

		Actions act = new Actions(driver);

		WebElement computers = driver.findElement(By.linkText("Computers"));

		act.moveToElement(computers).build().perform();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops"))).click();
		test.log(LogStatus.PASS, "  Element clicked successfully");

		driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC")).click();

		driver.findElement(By.xpath(" //button[@class ='button-2 email-a-friend-button']")).click();

		driver.findElement(By.id("FriendEmail")).sendKeys("soumyanil22@gmail.com");
		driver.findElement(By.id("YourEmailAddress")).sendKeys("dipalinsonawane1999@gmail.com");
		driver.findElement(By.id("PersonalMessage")).sendKeys("How are you? Dost.");
		driver.findElement(By.xpath(" //button[@class='button-1 send-email-a-friend-button']")).click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file1 = ts.getScreenshotAs(OutputType.FILE);
		File file2 = new File("C:\\Users\\asus\\Pictures\\TakeScreenshot\\image3.png");
		FileUtils.copyFile(file1, file2);
		Thread.sleep(3000);
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
