package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static String URL = "https://login.salesforce.com/?locale=ru";
    private final static By userNameInput = By.cssSelector("input#username");
    private final static By passwordInput = By.cssSelector("input#password");
    private final static By loginButton = By.cssSelector("input#Login");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(userNameInput);
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void open() {
        driver.get(URL);
    }
}
