package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='slds-var-p-right_x-small' and text()='Contacts']");
    private final static By CONTACTS_NEW_ACCOUNT = By.xpath(
            "//*[@class='title slds-text-heading--medium slds-hyphenate' and text()='New Account']");
    private final static By CONTACTS_NEW = By.xpath(
            "//*[@class='slds-modal__title slds-hyphenate slds-text-heading--medium' and text()='New Contact']");
    private final static By ACCOUNT_NAME = By.xpath("//*[@class='slds-combobox__input slds-input' and @placeholder='Search Accounts...']");
    private final static By ACCOUNT_NAME_OPTION = By.xpath("//*[@class='slds-truncate' and @title='New Account']");
    private final static By NEW_ACCOUNT = By.xpath("//*[@class='slds-form form-horizontal slds-is-editing']/div/div[1]/div/div/div[1]/div/div/div/div[1]/input");
    private final static By SAVE_BUTTON = By.xpath("//*[@title='Save'  and @class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']");
    private final static By SAVE_LOCATOR_ACCOUNT = By.xpath("//*[@class='slds-card__header-title slds-truncate' and text()='We found no potential duplicates of this Contact.']");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTS_NEW));
    }

    public void waitForPageLoadedNewAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTACTS_NEW_ACCOUNT));
    }

    public void waitForPageLoadedSaveAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_LOCATOR_ACCOUNT));
    }

    public boolean isContactsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }

    public boolean isNewContactsIconDisplayed() {
        return driver.findElement(CONTACTS_NEW).isDisplayed();
    }

    public boolean isSaveNewContactsIconDisplayed() {
        return driver.findElement(SAVE_LOCATOR_ACCOUNT).isDisplayed();
    }

    public void clickAccountName(String accountName) {
        driver.findElement(ACCOUNT_NAME).sendKeys(accountName);
        driver.findElement(ACCOUNT_NAME_OPTION).click();
    }

    public void setAccountName(String accountName) {
        driver.findElement(NEW_ACCOUNT).sendKeys(accountName);
    }

    public void clickSaveAccountButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

}
