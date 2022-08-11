package latestFeatures;

import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");

		// driver.switchTo().newWindow(WindowType.TAB);
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

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));

		name.sendKeys(firstNameCourse);
		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screen.png"));

		int height = name.getRect().getDimension().getHeight();
		System.out.println(height);

		int width = name.getRect().getDimension().getWidth();
		System.out.println(width);
	}

}
