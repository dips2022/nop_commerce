package RegisterForm;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataProviderTest {

	WebDriver driver;
	DataExtractfile get;

	@DataProvider(name = "getdata")
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		DataExtractfile get = new DataExtractfile();
		Object[][] data = get.getdatafromexcel();

		return data;
	}
	 
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void configReport() {
		
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReport1.html");// path of file

		test = report.startTest("https://demo.nopcommerce.com/register?returnUrl=%2Fcomputers");
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.setProperty("webdriver.chrome.chrome.driver",
				"C:\\Users\\asus\\Desktop\\pof\\chromedriver120\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test.log(LogStatus.PASS, "Chrome diver is opened successfully");
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcomputers");
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, " Url is opend successfully");
		// explicit
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/register?returnUrl=%2Fcomputers"));

		// Implicit wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 

	}

	@Test(dataProvider = "getdata")
	public void logintest(String Fname, String Lname, String Email, String Cname, String Password, String Cpassword)
			throws InterruptedException {
//		WebElement Gender = driver.findElement(By.id("gender")).click();
		WebElement Firstname = driver.findElement(By.id("FirstName"));
		test.log(LogStatus.PASS, " user name entered successfully");
		WebElement Lastname = driver.findElement(By.id("LastName"));
		test.log(LogStatus.PASS, "last name entered successfully");
		WebElement email = driver.findElement(By.id("Email"));
		test.log(LogStatus.PASS, "email entered successfully");
		WebElement Company = driver.findElement(By.id("Company"));
		test.log(LogStatus.PASS, " company name entered successfully");
		WebElement password = driver.findElement(By.id("Password"));
		test.log(LogStatus.PASS, " Password entered successfully");
		WebElement confirmpass = driver.findElement(By.id("ConfirmPassword"));
		test.log(LogStatus.PASS, " confirm password entered successfully");

//		Gender.sendKeys(gender);

		Firstname.sendKeys(Fname);
		Lastname.sendKeys(Lname);
		email.sendKeys(Email);
		Company.sendKeys(Cname);
		password.sendKeys(Password);
		confirmpass.sendKeys(Cpassword);

		driver.findElement(By.id("register-button")).click();
		test.log(LogStatus.PASS, " registered successfully");

	}
	@Test
	public void Takescreenshot() throws IOException, InterruptedException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file1 = ts.getScreenshotAs(OutputType.FILE);

		File file2 = new File("C:\\Users\\asus\\Pictures\\TakeScreenshot\\image.png");

		FileUtils.copyFile(file1, file2);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		 

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.close();
	}
	@AfterClass
	public void last() {

		report.endTest(test);
		report.flush();
	}

}
