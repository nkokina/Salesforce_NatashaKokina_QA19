package tests;

import enums.*;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LeadsDetailsPage;
import pages.LeadsPage;
import pages.modals.NewLeadModal;

public class LeadsTests extends BaseTest {

    private LeadsPage leadsPage;
    private LeadsDetailsPage leadsDetailsPage;
    private NewLeadModal newLeadModal;

    @BeforeClass
    public void initialise() {
        leadsPage = new LeadsPage(driver);
        leadsDetailsPage = new LeadsDetailsPage(driver);
        newLeadModal = new NewLeadModal(driver);
    }

    @Test(dataProvider = "createLeadTestData")
    public void createLeadTest(String company, LeadStatus leadStatus, String lastName, String firstName, Salutation salutation,
                               String suffix, String middleName, String title, String email, String webSite, String phone,
                               String mobile, Rating rating, Industry industry, String numberOfEmployees, LeadSource leadSource,
                               String address, String street, String province, String postalCode) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.openNewButton();
        leadsPage.waitForPageLoadedNew();
        Assert.assertTrue(leadsPage.isLeadsIconDisplayed(), "Leads page transition failed");

        Lead testLead = new Lead.LeadBuilder(company, leadStatus)
                .lastName(lastName)
                .firstName(firstName)
                .salutation(salutation)
                .suffix(suffix)
                .middleName(middleName)
                .title(title)
                .email(email)
                .webSite(webSite)
                .phone(phone)
                .mobilePhone(mobile)
                .rating(rating)
                .industry(industry)
                .numberOfEmployees(numberOfEmployees)
                .leadSource(leadSource)
                .address(address)
                .street(street)
                .province(province)
                .postalCode(postalCode)
                .build();

        newLeadModal.fillFord(testLead);
        newLeadModal.clickSaveButton();
        Assert.assertTrue(leadsPage.isConfimationPopupPresent());
        Assert.assertEquals(leadsDetailsPage.getLeadInfo(), testLead);
    }

    @DataProvider
    public Object[][] createContactTestData() {
        return new Object[][]{
                {faker.company().name(), LeadStatus.WORKING, faker.name().lastName(), faker.name().firstName(), Salutation.MS,
                        faker.name().suffix(), faker.name().username(), faker.name().title(), faker.internet().emailAddress(),
                        faker.internet().url(), faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(),
                        Rating.HOT, Industry.BIOTECHNOLOGY, faker.number().digit(), LeadSource.EMPLOYEE,
                        faker.address().cityName(), faker.address().streetName(), faker.address().state(), faker.address().zipCode()},
                {faker.company().name(), LeadStatus.WORKING},
                {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "15.99"},
        };
    }
}