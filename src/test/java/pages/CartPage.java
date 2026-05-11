package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private static WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver,WebDriverWait wait){
        CartPage.driver = driver;
        this.wait = wait;
    }

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);

    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public void clickMenu(){
        driver.findElement(menuButton).click();
    }
    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void removeBackpack() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }
    public boolean isBackpackDisplayed() {
        return driver.getPageSource().contains("Sauce Labs Backpack");
    }
    public void continueShopping() {
        driver.findElement(By.id("continue-shopping")).click();
    }


}
