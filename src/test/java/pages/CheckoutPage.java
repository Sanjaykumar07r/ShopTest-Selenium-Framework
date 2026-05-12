package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));
    }

    // LOCATORS for CheckoutPage

    By checkoutButton = By.id("checkout");

    By firstName = By.id("first-name");

    By lastName = By.id("last-name");

    By postalCode = By.id("postal-code");

    By continueButton = By.id("continue");

    By summaryProductName =
            By.className("inventory_item_name");

    By totalPrice =
            By.className("summary_total_label");

    By finishButton = By.id("finish");

    By confirmationMessage =
            By.className("complete-header");


    // METHODS

    public void clickCheckout(){

        wait.until(ExpectedConditions
                .elementToBeClickable(checkoutButton));

        driver.findElement(checkoutButton).click();
    }

    public void enterFirstName(String fname){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(lastName));

        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterPostalCode(String code){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(postalCode));

        driver.findElement(postalCode).sendKeys(code);
    }

    public void clickContinue(){

        wait.until(ExpectedConditions
                .elementToBeClickable(continueButton));

        driver.findElement(continueButton).click();
    }

    public String getSummaryProductName(){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(summaryProductName));

        return driver.findElement(summaryProductName).getText();
    }

    public String getTotalPrice(){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(totalPrice));

        return driver.findElement(totalPrice).getText();
    }

    public void clickFinish(){

        wait.until(ExpectedConditions
                .elementToBeClickable(finishButton));

        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage(){

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(confirmationMessage));

        return driver.findElement(confirmationMessage).getText();
    }
}