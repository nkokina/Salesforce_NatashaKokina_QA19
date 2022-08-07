package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadsPage extends EntityBasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='slds-var-p-right_x-small' and text()='Leads']");
    private final static By LEADS_NEW = By.xpath(
            "//*[@class='slds-modal__title slds-hyphenate slds-text-heading--medium' and text()='New Lead']");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LEADS_NEW));
    }

    public boolean isLeadsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }
}

