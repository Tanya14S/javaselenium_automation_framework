package com.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("STEP 1 - Add to Cart Start");

        // Click on Books category
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Books")
        )).click();

        System.out.println("STEP 2 - Books page opened");

        // Click Add to cart (first product)
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@value='Add to cart'])[1]")
        )).click();

        System.out.println("STEP 3 - Product added");

        // Click Shopping Cart
        wait.until(ExpectedConditions.elementToBeClickable(
            By.linkText("Shopping cart")
        )).click();

        System.out.println("STEP 4 - Cart opened");
    }
    
    public void addToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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
    }
}