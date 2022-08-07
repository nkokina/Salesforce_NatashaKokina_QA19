package pages;

import elements.LightningFormattedElement;
import enums.*;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


public class LeadsDetailsPage extends BasePage {
    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public LeadsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Lead getLeadInfo() {
        String leadStatus = new LightningFormattedElement(driver, "LeadStatus").getText();
        String company = new LightningFormattedElement(driver, "Company").getText();
        Lead.LeadBuilder leadBuilder = new Lead.LeadBuilder(company, LeadStatus.fromString(leadStatus));
        String fullName = new LightningFormattedElement(driver, "Name").getText();
        String salutation = new LightningFormattedElement(driver, "Salutation").getText();
        if (salutation != "") {
            leadBuilder.salutation(Salutation.fromString(salutation));
        }
        String middleName = new LightningFormattedElement(driver, "Middle Name").getText();
        if (middleName != "") {
            leadBuilder.middleName(middleName);
        }
        String suffix = new LightningFormattedElement(driver, "Suffix").getText();
        if (suffix != "") {
            leadBuilder.suffix(suffix);
        }
        String title = new LightningFormattedElement(driver, "Title").getText();
        if (title != "") {
            leadBuilder.phone(title);
        }
        String email = new LightningFormattedElement(driver, "Email").getText();
        if (email != "") {
            leadBuilder.email(email);
        }
        String webSite = new LightningFormattedElement(driver, "WebSite").getText();
        if (webSite != "") {
            leadBuilder.webSite(webSite);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            leadBuilder.phone(phone);
        }
        String mobilePhone = new LightningFormattedElement(driver, "MobilePhone").getText();
        if (mobilePhone != "") {
            leadBuilder.mobilePhone(mobilePhone);
        }
        String rating = new LightningFormattedElement(driver, "Rating").getText();
        if (rating != "") {
            leadBuilder.rating(Rating.fromString(rating));
        }
        String industry = new LightningFormattedElement(driver, "Industry").getText();
        if (industry != "") {
            leadBuilder.industry(Industry.fromString(industry));
        }
        String numberOfEmployees = new LightningFormattedElement(driver, "Number Of Employees").getText();
        if (numberOfEmployees != "") {
            leadBuilder.numberOfEmployees(numberOfEmployees);
        }
        String leadSource = new LightningFormattedElement(driver, "LeadSource").getText();
        if (leadSource != "") {
            leadBuilder.leadSource(LeadSource.fromString(leadSource));
        }
        String address = new LightningFormattedElement(driver, "Address").getText();
        if (address != "") {
            leadBuilder.address(address);
        }
        String street = new LightningFormattedElement(driver, "Street").getText();
        if (street != "") {
            leadBuilder.street(street);
        }
        String province = new LightningFormattedElement(driver, "Province").getText();
        if (!Objects.equals(province, "")) {
            leadBuilder.province(province);
        }
        String postalCode = new LightningFormattedElement(driver, "Postal Code").getText();
        if (postalCode != "") {
            leadBuilder.postalCode(postalCode);
        }

        return new Lead.LeadBuilder(
                company,
                LeadStatus.fromString(leadStatus))
                .fullName(fullName)
                .salutation(Salutation.fromString(salutation))
                .suffix(suffix)
                .middleName(middleName)
                .title(title)
                .email(email)
                .webSite(webSite)
                .phone(phone)
                .mobilePhone(mobilePhone)
                .rating(Rating.fromString(rating))
                .industry(Industry.fromString(industry))
                .numberOfEmployees(numberOfEmployees)
                .leadSource(LeadSource.fromString(leadSource))
                .address(address)
                .street(street)
                .province(province)
                .postalCode(postalCode).build();
    }
}
