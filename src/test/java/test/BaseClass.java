package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	String fName,lName,email,phone;
	@Test(priority = 1)
	public void setValue() throws Exception {
		SampleTest s = new SampleTest();
		fName=s.getCellData(0, 0);
		lName=s.getCellData(0,1);
		email=s.getCellData(0, 2);
		
		phone=s.getCellData(0, 3);
		

	}
    
	
	@Test(priority = 0)
	public void browserOpen() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		
		
	}
	
	@Test(priority = 2)
	public void findElement() {
		
		
		
		WebElement firstName =driver.findElement(By.id("firstName"));
		firstName.sendKeys(fName);
		
		
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys(lName);
		
		WebElement emailId = driver.findElement(By.id("userEmail"));
		emailId.sendKeys(email);
		
		
		
		WebElement radio1 = driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]"));
		radio1.click();
		
		WebElement PhoneNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
		PhoneNumber.sendKeys(phone);

	}
	@Test(priority = 3)
	public void calender() {
		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement cal = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"));
		String text = cal.getText();
		String[] b = text.split(" ");
		
		while(!((b[0].equals("March")) && (b[1].equals("2016")))) {
			driver.findElement(By.xpath("//button[text()='Previous Month']")).click();
			cal = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"));
			text=cal.getText();
			b = text.split(" ");
		}
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--024']")).click();
		
		
	}
	
	


}
