package test;
//superclass for BasicLoginTest class

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLifeCycleSetting {
	
	protected WebDriver driver;  // accessible to subclasses
	
	@BeforeAll
	public static void beforeAll() { 
		WebDriverManager.chromedriver().setup(); 
	}
	
	@BeforeEach
	void beforeEach() { 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterEach
	void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
}
