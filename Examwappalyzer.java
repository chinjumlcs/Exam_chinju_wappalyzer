package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Examwappalyzer 
{
	WebDriver driver;
	@BeforeTest
	public void browserSetup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void UrlLoading()
	{
		driver.get("https://www.wappalyzer.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/header/div/div/div/div[2]/button[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"list-item-50\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[1]/div[2]/div[3]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[2]/form/div[1]/div[1]/div[1]/div/div[1]/button")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement wb=driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div[2]/form/div[1]/div[1]/div[1]/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/input"));
		//wb.sendKeys("Java");
		Actions act=new Actions(driver);
		act.moveToElement(wb);
                act.click();
		act.sendKeys(wb,"Java").build().perform();
		
	}
	@AfterTest
	public void browserClose()
	{
		driver.close();
	}
}
