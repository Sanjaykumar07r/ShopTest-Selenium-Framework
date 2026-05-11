package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    public void login(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(
                        org.openqa.selenium.By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(
                        org.openqa.selenium.By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(
                        org.openqa.selenium.By.id("login-button"))
                .click();
    }


    // TESTCASE 1
    // Proceed checkout and verify summary page

    @Test
    public void verifyCheckoutSummaryPage(){

        login();

        ProductPage productPage = new ProductPage(driver, wait);

        productPage.addBackpackToCart();

        productPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");

        checkoutPage.clickContinue();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two"));
    }



    // TESTCASE 2
    // Verify product name and total price

    @Test
    public void verifyOrderSummary(){

        login();

        ProductPage productPage = new ProductPage(driver, wait);

        productPage.addBackpackToCart();

        productPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");

        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getSummaryProductName(),
                "Sauce Labs Backpack");

        Assert.assertTrue(
                checkoutPage.getTotalPrice().contains("Total"));
    }



    // TESTCASE 3
    // Complete order and verify confirmation message

    @Test
    public void verifyOrderCompletion(){

        login();

        ProductPage productPage = new ProductPage(driver, wait);

        productPage.addBackpackToCart();

        productPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");

        checkoutPage.clickContinue();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!");
    }
}