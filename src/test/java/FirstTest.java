import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.facebook.com");
		
		WebElement textbox = driver.findElement(By.cssSelector("#email"));
		textbox.sendKeys("MY LOGIN NAME");
		
		WebElement forgotLink = driver.findElement(By.cssSelector("#login_form tr:nth-child(3)>td:nth-child(2)>a"));
		forgotLink.click();
		
		Thread.sleep(2000L);		
				
		driver.get("http://www.amazon.com");
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
				
		List<WebElement> navButtons = driver.findElements(By.cssSelector(".nav-button-title.nav-button-line2"));
		
		for(WebElement button : navButtons){
			System.out.println(button.getText());
		}
		
		WebElement accountDD = driver.findElement(
				By.cssSelector("#nav-your-account>.nav-button-mid.nav-sprite>.nav-button-inner.nav-sprite>.nav-button-title.nav-button-line2"));
		
		accountDD.click();
		
		driver.close();
	}
}
