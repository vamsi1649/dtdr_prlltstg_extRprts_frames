package datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames_drag_drop {		
public String url="https://jqueryui.com/droppable/";
WebDriver driver;

@BeforeTest
public void beforetest() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().window().maximize();

}

@Test
public void tc1() throws InterruptedException {
	
	driver.findElements(By.tagName("iframe")).size();
	System.out.print(driver.findElements(By.tagName("iframe")).size());
	
	driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
	
	WebElement ele1=driver.findElement(By.xpath("//*[@id='draggable']"));
	WebElement ele2=driver.findElement(By.xpath("//*[@id='droppable']"));
	Actions ac=new Actions(driver);
	ac.dragAndDrop(ele1,ele2).build().perform();
	
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Accept")).click();
	driver.close();
}
}