package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> webHandle = new ArrayList<String>(handles);
		driver.switchTo().window(webHandle.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='10691']")).click();
		driver.switchTo().window(webHandle.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		int size = handles.size();
		System.out.println(size);
		Set<String> handle1 = driver.getWindowHandles();
		List<String> webHandle1 = new ArrayList<String>(handle1);

		driver.switchTo().window(webHandle1.get(1));
		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='10687']")).click();
		driver.switchTo().window(webHandle.get(0));
		driver.findElement(By.className("buttonDangerous")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		if (title.contains("View Contact ")) {
			System.out.println("Title verified");
		}
	}

}
