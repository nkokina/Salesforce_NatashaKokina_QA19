package tests;

import enums.Salutation;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactPage;
import pages.modals.NewContactModal;

public class ContactTests extends BaseTest {

    private ContactPage contactPage;
    private NewContactModal newContactModal;
    private ContactDetailsPage contactDetailsPage;

    @BeforeClass
    public void initialise() {
        contactPage = new ContactPage(driver);
        newContactModal = new NewContactModal(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
    }


    @Test(dataProvider = "createContactTestData")
    public void createContactTest(String lastName, String firstName, Salutation salutation, String middleName, String suffix,
                                  String title, String email, String phone, String mobile, String repostTo, String department,
                                  String fax, String mailingAddress, String street, String province, String postalCode) {
        loginPage.login(USERNAME, PASSWORD);
        homePage.waitForUserIconDisplayed();
        homePage.openContactsTab();
        contactPage.waitForPageLoaded();
        contactPage.openNewButton();
        contactPage.waitForPageLoadedNew();
        Assert.assertTrue(contactPage.isContactsIconDisplayed(), "Contacts page transition failed");

        Contact testContact = new Contact.ContactBuilder(lastName, firstName)
                .salutation(salutation)
                .middleName(middleName)
                .suffix(suffix)
                .title(title)
                .email(email)
                .phone(phone)
                .mobilePhone(mobile)
                .reportsTo(repostTo)
                .department(department)
                .fax(fax)
                .mailingAddress(mailingAddress)
                .street(street)
                .province(province)
                .postalCode(postalCode)
                .build();

        newContactModal.fillFord(testContact);
        newContactModal.clickSaveButton();
        Assert.assertTrue(contactPage.isConfimationPopupPresent());
        Assert.assertEquals(contactDetailsPage.getContactInfo(), testContact);

    }

    @DataProvider
    public Object[][] createContactTestData() {
        return new Object[][]{
                {faker.name().lastName(), faker.name().firstName(), Salutation.MS, faker.name().username(),
                        faker.name().suffix(), faker.name().title(), faker.internet().emailAddress(),
                        faker.phoneNumber().phoneNumber(), faker.phoneNumber().phoneNumber(), faker.name().fullName(),
                        faker.company().name(), faker.phoneNumber().phoneNumber(), faker.address().cityName(),
                        faker.address().streetName(), faker.address().state(), faker.address().zipCode()},
                {faker.name().lastName(), faker.name().firstName()},
                {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "15.99"},
        };
    }
}
