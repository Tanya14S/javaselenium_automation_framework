package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

 
    @Test
    public void cartCheckoutFlow() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("FLOW START");

        // STEP 1 - Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Books")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@value='Add to cart'])[1]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Shopping cart")
        )).click();

        System.out.println("Cart ready");

        // STEP 2 - Checkout
        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("termsofservice")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("checkout")
        )).click();

        System.out.println("Checkout done");
    }
    
    public void checkout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("termsofservice")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.id("checkout")
        )).click();

        System.out.println("Checkout done");
    }
}