package com.framework.tests;


import org.testng.annotations.Test;

import com.framework.base.BaseTest;

public class E2EFlowTest extends BaseTest {

    LoginTest loginObj = new LoginTest();
    AddToCartTest cartObj = new AddToCartTest();
    CheckoutTest checkoutObj = new CheckoutTest();

    @Test
    public void e2eFlow() {

        System.out.println("E2E FLOW START");

		loginObj.driver = driver;
        loginObj.login();

        cartObj.driver = driver;
        cartObj.addToCart();

        checkoutObj.driver = driver;
        checkoutObj.checkout();

        System.out.println("E2E FLOW COMPLETE");
    }
}