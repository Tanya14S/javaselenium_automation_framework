package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    public void registerTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("STEP 1 - Starting Registration");

        // Click Register
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Register")
        )).click();

        // Select Gender
        driver.findElement(By.id("gender-female")).click();

        // Enter details
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");

        // Dynamic email (VERY IMPORTANT)
        String email = "randomtestuser123@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("Password")).sendKeys("Test@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test@123");

        // Click Register
        driver.findElement(By.id("register-button")).click();

        System.out.println("STEP 2 - Registration submitted");

        // Verify success
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(),'Your registration completed')]")
        ));

        System.out.println("STEP 3 - Registration successful");
    }
}