package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import POs.LoginFormPO;
import POs.LoginSuccessPO;

// test Commit 2
public class BasicLoginTest extends DriverLifeCycleSetting{
	
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;
	
	
	@Test
	void testLoginOk() {
		login = new LoginFormPO(driver);
		loginSuccess = (LoginSuccessPO) login.with("user", "user");
		assertTrue(loginSuccess.SuccessBoxIsPresent());
	}
	
	
	@Test
	void testLoginNoOk() {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		assertTrue(login.InvalidBoxIsPresent());
	}
	
}
