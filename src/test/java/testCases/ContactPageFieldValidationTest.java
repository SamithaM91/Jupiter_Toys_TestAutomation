package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactPageFieldValidationTest extends BaseClass {

    @DataProvider(name = "contactFormData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Dasun", "dasun@example.com", "This is a test message."},
                {"Samitha", "samitha@example.com", "Test message 2."}
        };
    }

    @Test(dataProvider = "contactFormData")
    public void TC001(String forename, String email, String message) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        ContactPage contactPage = new ContactPage(driver);
        Assert.assertTrue(contactPage.isOnContactPage(), "User is NOT on the Contact page!");
        contactPage.clickSubmit();
        Assert.assertTrue(contactPage.areErrorsDisplayed(), "Error messages should be displayed!");

        contactPage.fillMandatoryFields(forename, email, message);

        Assert.assertTrue(contactPage.areErrorsGone(), "Error messages should disappear after filling in fields!");
    }

}
