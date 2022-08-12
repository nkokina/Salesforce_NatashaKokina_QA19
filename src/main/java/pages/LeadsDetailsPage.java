package pages;

import elements.LightningFormattedElement;
import enums.*;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

@Log4j2
public class LeadsDetailsPage extends BasePage {
    private final static By DETAILS_BUTTON =
            By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public LeadsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Lead getLeadInfo() {
        log.info("Retrieving existing values from a partition Details");
        String company = new LightningFormattedElement(driver, "Company").getText();
        String lastName = new LightningFormattedElement(driver, "Name").getText();
        String leadStatus = new LightningFormattedElement(driver, "Lead Status").getText();
        Lead.LeadBuilder leadBuilder = Lead.builder().company(company).lastName(lastName).leadStatus(LeadStatus.fromString(leadStatus));

        String salutation = new LightningFormattedElement(driver, "Name").getText();
        if (salutation != "") {
            leadBuilder.salutation(Salutation.fromString(salutation));
        }
        String middleName = new LightningFormattedElement(driver, "Name").getText();
        if (middleName != "") {
            leadBuilder.middleName(middleName);
        }
        String suffix = new LightningFormattedElement(driver, "Name").getText();
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
        String webSite = new LightningFormattedElement(driver, "Website").getText();
        if (webSite != "") {
            leadBuilder.webSite(webSite);
        }
        String phone = new LightningFormattedElement(driver, "Phone").getText();
        if (phone != "") {
            leadBuilder.phone(phone);
        }
        String mobilePhone = new LightningFormattedElement(driver, "Mobile").getText();
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
        String numberOfEmployees = new LightningFormattedElement(driver, "No. of Employees").getText();
        if (numberOfEmployees != "") {
            leadBuilder.numberOfEmployees(numberOfEmployees);
        }
        String leadSource = new LightningFormattedElement(driver, "Lead Source").getText();
        if (leadSource != "") {
            leadBuilder.leadSource(LeadSource.fromString(leadSource));
        }
        String address = new LightningFormattedElement(driver, "Address").getText();
        if (address != "") {
            leadBuilder.address(address);
        }
        String street = new LightningFormattedElement(driver, "Address").getText();
        if (street != "") {
            leadBuilder.street(street);
        }
        String province = new LightningFormattedElement(driver, "Address").getText();
        if (!Objects.equals(province, "")) {
            leadBuilder.province(province);
        }
        String postalCode = new LightningFormattedElement(driver, "Address").getText();
        if (postalCode != "") {
            leadBuilder.postalCode(postalCode);
        }

        return Lead.builder().build();
    }
}
