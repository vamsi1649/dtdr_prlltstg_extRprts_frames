package datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hrmjs {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	 
	WebDriver driver;
	
	@Test
	public void tc() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		
		Thread.sleep(3000);
		JavascriptExecutor js= ((JavascriptExecutor)driver);
	    js.executeScript("document.getElementsByName('username')[0].value='Admin'");
		Thread.sleep(3000);
		js.executeScript("document.getElementsByName('password')[0].value='admin123'");
		Thread.sleep(3000);
		js.executeScript("document.getElementsByClassName('oxd-button oxd-button--medium oxd-button--main orangehrm-login-button')[0].click()");
}
}