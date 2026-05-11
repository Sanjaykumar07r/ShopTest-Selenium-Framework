package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProblemUserTest extends BaseTest {

    public void loginProblemUser(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(
                        org.openqa.selenium.By.id("user-name"))
                .sendKeys("problem_user");

        driver.findElement(
                        org.openqa.selenium.By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(
                        org.openqa.selenium.By.id("login-button"))
                .click();
    }



    // TESTCASE 1
    // Verify broken behavior in product page

    @Test
    public void verifyProblemUserProductPage(){

        loginProblemUser();

        ProductPage productPage = new ProductPage(driver, wait);

        Assert.assertTrue(
                productPage.isProductDisplayed());
    }



    // TESTCASE 2
    // Add product and verify cart count

    @Test
    public void verifyProblemUserAddToCart(){

        loginProblemUser();

        ProductPage productPage = new ProductPage(driver, wait);

        productPage.addBackpackToCart();

        Assert.assertEquals(
                productPage.getCartBadgeCount(),
                "1");
    }



    // TESTCASE 3
    // Verify image issue exists

    @Test
    public void verifyBrokenImages(){

        loginProblemUser();

        String imageSource = driver.findElement(
                org.openqa.selenium.By.className("inventory_item_img")).findElement(org.openqa.selenium.By.tagName("img")).getAttribute("src");
        Assert.assertTrue(imageSource.contains("sl-404"));
    }
}