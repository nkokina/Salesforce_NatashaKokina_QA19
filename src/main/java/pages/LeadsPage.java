package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeadsPage extends BasePage {

    private final static By ICON_LOCATOR = By.xpath("//*[@class='slds-var-p-right_x-small' and text()='Leads']");
    private final static By LEADS_NEW = By.xpath(
            "//*[@class='slds-modal__title slds-hyphenate slds-text-heading--medium' and text()='New Lead']");
    private final static By LEADS_STATUS = By.xpath(
            "//*[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and contains(@aria-label,'Lead Status')]");
    private final static By COMPANY = By.xpath("//*[@class='slds-input' and @name='Company']");
    private final static By SAVE_LOCATOR = By.xpath("//*[@class='uiOutputText' and text()='Mark Status as Complete']");
    private final static By INDUSTRY = By.xpath(
            "//*[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and contains(@aria-label,'Industry')]");
    private final static By LEAD_SOURCE = By.xpath(
            "//*[@class='slds-combobox__input slds-input_faux slds-combobox__input-value' and contains(@aria-label,'Lead Source')]");
    private final static By NUMBER_OF_Employees = By.xpath("//*[@class='slds-input' and @name='NumberOfEmployees']");
    private final static By ADDRESS = By.xpath("//*[@class='slds-combobox__input slds-input' and @placeholder='Search Address']");
    private final static By STREET = By.xpath("//*[@class='slds-textarea' and @name='street']");
    private final static By STATE = By.xpath("//*[@class='slds-input' and @name='province']");
    private final static By POSTAL_CODE = By.xpath("//*[@class='slds-input' and @name='postalCode']");
    private final String LEADS_STATUS_OPTION =
            "//*[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain' and @data-value='%s']";
    private final String INDUSTRY_OPTION = "//*[@class='slds-truncate' and text()='%s']";
    private final String LEAD_SOURCE_OPTION = "//*[@class='slds-truncate' and text()='%s']";
    private final String ADDRESS_OPTION = "//*[@class='slds-truncate' and @title='%s']";

    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public void waitForPageLoadedNew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LEADS_NEW));
    }

    public void waitForPageLoadedSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_LOCATOR));
    }

    public void getLeadsStatus(String leadsStatus) {
        driver.findElement(LEADS_STATUS).click();
        driver.findElement(By.xpath(String.format(LEADS_STATUS_OPTION, leadsStatus))).click();
    }

    public void getLeadsIndustry(String industry) {
        driver.findElement(INDUSTRY).click();
        driver.findElement(By.xpath(String.format(INDUSTRY_OPTION, industry))).click();
    }

    public void getLeadSource(String leadSource) {
        driver.findElement(LEAD_SOURCE).click();
        driver.findElement(By.xpath(String.format(LEAD_SOURCE_OPTION, leadSource))).click();
    }

    public void getLeadAddress(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
        driver.findElement(By.xpath(String.format(ADDRESS_OPTION, address))).click();
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        driver.findElement(NUMBER_OF_Employees).sendKeys(numberOfEmployees);
    }

    public void setCompany(String company) {
        driver.findElement(COMPANY).sendKeys(company);
    }

    public void setStreet(String street) {
        driver.findElement(STREET).sendKeys(street);
    }

    public void setState(String state) {
        driver.findElement(STATE).sendKeys(state);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    public boolean isLeadsIconDisplayed() {
        return driver.findElement(ICON_LOCATOR).isDisplayed();
    }

    public boolean isNewLeadsIconDisplayed() {
        return driver.findElement(LEADS_NEW).isDisplayed();
    }

    public boolean isSaveLeadsIconDisplayed() {
        return driver.findElement(SAVE_LOCATOR).isDisplayed();
    }
}