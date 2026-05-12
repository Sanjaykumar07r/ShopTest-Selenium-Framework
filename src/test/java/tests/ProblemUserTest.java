package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProblemUserTest extends BaseTest {

    public void loginProblemUser(){
        driver.get(config.getBaseUrl());
        driver.findElement(org.openqa.selenium.By.id("user-name")).sendKeys("problem_user"); // here config will not work as another username used
        driver.findElement(org.openqa.selenium.By.id("password")).sendKeys(config.getPassword());
        driver.findElement(org.openqa.selenium.By.id("login-button")).click();
    }

    @Test
    public void verifyProblemUserProductPage(){
        loginProblemUser();
        ProductPage productPage = new ProductPage(driver, wait);
        Assert.assertTrue(productPage.isProductDisplayed());
    }

    @Test
    public void verifyProblemUserAddToCart(){
        loginProblemUser();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartBadgeCount(), "1");
    }

    @Test
    public void verifyBrokenImages(){
        loginProblemUser();
        String imageSource = driver.findElement(
                org.openqa.selenium.By.className("inventory_item_img")).findElement(org.openqa.selenium.By.tagName("img")).getAttribute("src");
        Assert.assertTrue(imageSource.contains("sl-404"));
    }
}