package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.framework.utils.CSVReaderUtil;

import java.time.Duration;

public class LoginTest extends BaseTest {

    // ================= DATA PROVIDER =================
	@DataProvider(name = "loginData")
	public Object[][] getData() {

	    String path = System.getProperty("user.dir") + "/src/test/resources/loginData.csv";

	    System.out.println("CSV PATH: " + path); // 🔥 DEBUG

	    return CSVReaderUtil.getCSVData(path);
	}
    // ================= TEST METHOD (DATA DRIVEN) =================
    @Test(priority = 1, dataProvider = "loginData")
    public void loginTest(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("LOGIN TEST WITH: " + email);

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Log in")
        )).click();

        // Clear + enter email
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);

        // Clear + enter password
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);

        // Click login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        System.out.println("LOGIN ATTEMPT DONE");
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    // ================= REUSABLE METHOD FOR E2E =================
    public void login() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("LOGIN METHOD START (E2E)");

        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Log in")
        )).click();

        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.name("Email"))
              .sendKeys("testuser123@gmail.com");

        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password"))
              .sendKeys("Test@123");

        driver.findElement(By.xpath("//input[@value='Log in']"))
              .click();

        System.out.println("LOGIN METHOD DONE (E2E)");
    }
}