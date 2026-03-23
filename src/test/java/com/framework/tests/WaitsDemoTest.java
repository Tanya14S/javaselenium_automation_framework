package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;

import java.time.Duration;
import java.util.NoSuchElementException;

// Selenium 4 Relative Locator import
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WaitsDemoTest extends BaseTest {

    @Test
    public void fluentWaitAndRelativeLocatorDemo() {

        System.out.println("WAIT + RELATIVE LOCATOR DEMO START");

        // Fluent Wait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for Login link (reference element)
        WebElement loginLink = wait.until(driver ->
                driver.findElement(By.linkText("Log in"))
        );

        System.out.println("Login link found using Fluent Wait");

        // 🔥 RELATIVE LOCATOR (Selenium 4 feature)
        // Find Register link ABOVE login link
        WebElement registerLink = driver.findElement(
                with(By.tagName("a")).above(loginLink)
        );

        System.out.println("Relative locator used (above)");

        // Click login normally (main flow)
        loginLink.click();

        System.out.println("Clicked on Login using Fluent Wait");

        // Just to show interaction
        wait.until(driver -> driver.findElement(By.id("Email")));

        System.out.println("WAIT + RELATIVE LOCATOR DEMO COMPLETE");
    }
}