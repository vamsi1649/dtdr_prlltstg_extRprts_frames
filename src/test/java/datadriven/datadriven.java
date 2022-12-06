package datadriven;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {
	WebDriver driver;
	public String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@Test
	public void tc1() throws IOException {
		
		
				File excel = new File("C:/Users/LENOVO/Desktop/datadriven/datadriven.xlsx");
				FileInputStream fis = new FileInputStream(excel);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheet("Sheet1");
				int rowcount=sh.getLastRowNum();
				for (int i=0;i<=rowcount;i++) {
				String user = sh.getRow(i).getCell(0).getStringCellValue();
				System.out.println(user);	
				String pass = sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(pass);
				
				WebDriverManager.edgedriver().setup();
				    driver = new EdgeDriver();
				    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.get(url);
					driver.manage().window().maximize();
					driver.findElement(By.name("username")).sendKeys(user);
					driver.findElement(By.name("password")).sendKeys(pass);
					driver.findElement(By.xpath("//*[@type='submit']")).click();
					String str=driver.getCurrentUrl();
					if (str.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")){
						driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).click();
						driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
						driver.close();		
						}
						else {
							    driver.close();
								
							}
						}
	        	}	
	    }
	

