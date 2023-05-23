package test;
//superclass for BasicLoginTest class

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverLifeCycleSetting {
	
	protected WebDriver driver;  // accessible to subclasses
	
	@BeforeAll
	public static void beforeAll() { 
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void beforeEach() { 
		// disable browser popup
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterEach
	void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
