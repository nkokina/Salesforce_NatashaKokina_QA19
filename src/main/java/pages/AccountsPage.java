package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends EntityBasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='slds-var-p-right_x-small' and text()='Accounts']");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ICON_LOCATOR));
    }

    public boolean isLeadsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }
}
