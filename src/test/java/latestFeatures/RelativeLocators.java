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

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamlabel = driver.findElement(By.cssSelector("[for='exampleCheck1']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamlabel)).click();

		WebElement rdb = driver.findElement(By.id("inlineRadio1"));

		String labelName2 = driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText();
		System.out.println(labelName2);

	}

}
