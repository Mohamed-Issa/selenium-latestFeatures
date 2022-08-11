package latestFeatures;

import java.util.Set;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");

	//	driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);


		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();

		String parentWindowID = iterator.next();

		String childWindowID = iterator.next();

		driver.switchTo().window(childWindowID);

		driver.get("https://rahulshettyacademy.com/");

		String firstNameCourse = driver
				.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();

		System.out.println(firstNameCourse);

		driver.switchTo().window(parentWindowID);

		driver.findElement(By.cssSelector("[name='name']")).sendKeys(firstNameCourse);
	}

}
