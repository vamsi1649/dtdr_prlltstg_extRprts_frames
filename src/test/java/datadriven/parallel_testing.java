package datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class parallel_testing {

	WebDriver driver;
	public String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@Parameters("myBrowser")
	
	@BeforeTest
	public void tc1(String myBrowser) {
		if (myBrowser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
		}
			else if (myBrowser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
			}   
		}
		@Test
		public void tc2() {
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get(url);
				driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	
	}
	
	

