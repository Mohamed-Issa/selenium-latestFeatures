package latestFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		String labelName = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

		System.out.println(labelName);

	}

}
