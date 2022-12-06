package datadriven;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nestedFrames_printStream {
		public String url="https://the-internet.herokuapp.com/nested_frames";
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
		public void tc1() throws FileNotFoundException {
			
			driver.findElements(By.tagName("frameset")).size();
			System.out.println(driver.findElements(By.tagName("frameset")).size());
			driver.switchTo().frame(driver.findElement(By.name("frame-top")));
			System.out.println(driver.findElements(By.tagName("frame")).size());
			driver.switchTo().frame(1);
			driver.findElement(By.xpath("//*[@id=\"content\"]")).getText();
			PrintStream ps = new PrintStream(new File("C:\\Users\\LENOVO\\Desktop\\scrshot\\console.txt"));
			System.setOut(ps);
			ps.print(driver.findElement(By.xpath("//*[@id=\"content\"]")).getText());
			driver.close();
		}

}
