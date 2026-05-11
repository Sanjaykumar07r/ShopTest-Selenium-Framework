package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin(){
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.enterUsername("standard_user");
        cartPage.enterPassword("secret_sauce");
        cartPage.clickLogin();
    }

    @Test
    public void verifyLockedOutUser(){
        CartPage loginPage = new CartPage(driver, wait);
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("locked out"));
    }
    @Test
    public void verifyEmptyCredentials(){

        CartPage loginPage = new CartPage(driver, wait);
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username is required"));
    }
    @Test
    public void verifyLogout(){

        CartPage loginPage = new CartPage(driver, wait);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickMenu(); // logging in
        loginPage.clickLogout(); //checkin out
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo"));
    }
}
