package datadriven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extent_reports {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest 
	public void beforetest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		 htmlReporter = new ExtentHtmlReporter("extent.html");
		 extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	}
		
		@Test(enabled=true,priority = 0)
		public void testcase1() throws InterruptedException
		{
		SoftAssert vamsi = new SoftAssert();
		test = extent.createTest("first test");
		driver.findElement(By.name("username")).sendKeys("Admin");
		test.pass("username is entered");
		driver.findElement(By.name("password")).sendKeys("admin123");
		test.pass("password is entered");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		test.info("user successfully got logged in");
		String k = driver.getTitle();
		vamsi.assertEquals(k, "OrangeHRM");
		Thread.sleep(5000);
		vamsi.assertAll();
		}
		
		@Test(enabled=true,priority = 1,invocationCount = 2,invocationTimeOut = 8000)
		public void testcase2() throws InterruptedException
		{	
          List <WebElement> li = driver.findElements(By.tagName("a"));
          System.out.println("total links "+ li.size());
           for (int i=0; i<li.size(); i++)
          {
			System.out.println(li.get(i).getText());
	        System.out.println(li.get(i).getAttribute("href"));
          }
		}
		@AfterTest(enabled=true)
	    public void aftertest() {
    	driver.close();
    	extent.flush();
		}
	}


