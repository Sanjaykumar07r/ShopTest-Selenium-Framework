package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators

    By checkoutButton = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By completeMessage = By.className("complete-header");
    By summaryProduct = By.className("inventory_item_name");
    By totalPrice = By.className("summary_total_label");

    public void clickCheckout(){
        driver.findElement(checkoutButton).click();
    }
    public void enterFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }
    public void enterLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void enterPostalCode(String code){
        driver.findElement(postalCode).sendKeys(code);
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public String getSummaryProductName(){
        return driver.findElement(summaryProduct).getText();
    }
    public String getTotalPrice(){
        return driver.findElement(totalPrice).getText();
    }
    public void clickFinish(){
        driver.findElement(finishButton).click();
    }
    public String getConfirmationMessage(){
        return driver.findElement(completeMessage).getText();
    }
}