package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends EntityBasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='inlineTitle slds-p-top--large slds-p-horizontal--medium slds-p-bottom--medium slds-text-heading--medium' and text()='New Account']");
    private final static By ACCOUNT_NEW = By.xpath("//*[@class='slds-truncate' and text()='Accounts']");

    private final static By SAVA_BUTTON = By.xpath("//*[@class='button-container-inner slds-float_right']/button[@title='Save']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_NEW));
    }

    public boolean isLeadsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }

    public void clickSave() {
        driver.findElement(SAVA_BUTTON).click();
    }
}
