package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowAssignement {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://dev101502.service-now.com/navpage.do");
		driver.switchTo().frame(0);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Admin1997*");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> newHandles = new ArrayList<String>(handles);
		driver.switchTo().window(newHandles.get(1));
		driver.findElement(By.xpath("//a[text()='Abel Tuter']")).click();
		driver.switchTo().window(newHandles.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation Testing");
		String text = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is" + text);
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text,Keys.ENTER);
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("screenshotAs.png");
		FileUtils.copyFile(src1, dst);
		

	}

}
