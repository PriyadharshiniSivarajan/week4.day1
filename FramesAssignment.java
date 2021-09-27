package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Learn Frames");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select drop =new Select(dropDown);
		drop.selectByValue("avatar");
		
	}

}
