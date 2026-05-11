package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    // Locators

    By firstProduct = By.className("inventory_item_name");
    By sortDropdown = By.className("product_sort_container");
    By firstProductPrice = By.className("inventory_item_price");

    // Methods


    public boolean isProductDisplayed(){
        return driver.findElement(firstProduct).isDisplayed();
    } // Check product displayed


    public void sortNameAToZ(){
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("az"); //call by value az
    }// Sort A to Z


    public void sortPriceLowToHigh(){
        Select select = new Select(driver.findElement(sortDropdown));// Sort Price Low to High
        select.selectByValue("lohi");
    }

    public String getFirstProductName(){
        return driver.findElement(firstProduct).getText();
    }
    public String getFirstProductPrice(){
        return driver.findElement(firstProductPrice).getText();
    }
    public void openFirstProduct(){
        driver.findElement(firstProduct).click();
    }
    public void addBackpackToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    public void addBikeLightToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }
    public String getCartBadgeCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }


}