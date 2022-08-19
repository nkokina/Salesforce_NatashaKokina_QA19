package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends EntityBasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='slds-var-p-right_x-small' and text()='Contacts']");
    private final static By CONTACTS_NEW = By.xpath(
            "//*[@class='slds-modal__title slds-hyphenate slds-text-heading--medium' and text()='New Contact']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTS_NEW));
    }

    public boolean isContactsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }

}
