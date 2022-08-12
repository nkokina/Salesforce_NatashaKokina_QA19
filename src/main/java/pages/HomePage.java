package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    private final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    private final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    private final static By CONTACTS_TAB_LOCATOR = By.xpath("//*[@title='Contacts']");
    private final static By ACCOUNT_TAB_LOCATOR = By.xpath("//*[@title='Accounts']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public void waitForUserIconDisplayed() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public boolean isUserIconDisplayed() {
        return driver.findElement(USER_ICON_LOCATOR).isDisplayed();
    }

    public void openLeadsTab() {
        log.info("Pressing to enter the section Leads");
        jsClick(driver.findElement(LEADS_TAB_LOCATOR));
    }

    public void openContactsTab() {
        log.info("Pressing to enter the section Contacts");
        jsClick(driver.findElement(CONTACTS_TAB_LOCATOR));
    }

    public void openAccountsTab() {
        log.info("Pressing to enter the section Accounts");
        jsClick(driver.findElement(ACCOUNT_TAB_LOCATOR));
    }

}