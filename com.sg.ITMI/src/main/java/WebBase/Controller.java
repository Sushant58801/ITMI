package WebBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Controller {
	public static WebDriver driver = null;

	public static WebDriver InvokeWebDriver() {
		if (driver != null) {
			return driver;
		}

		System.setProperty("webdriver.chrome.driver",
				"Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver Created");

		driver.get("http://inventaireinfo.mutlp.test.pointp.saint-gobain.net");

		System.out.println("Website Open");

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	

}
