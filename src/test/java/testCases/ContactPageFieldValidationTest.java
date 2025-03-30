package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

/**
 * This Class consists the below test case steps
 * 1. From the home page go to contact page
 * 2. Click submit button
 * 3. Verify error messages
 * 4. Populate mandatory fields
 * 5. Validate errors are gone
 */
public class ContactPageFieldValidationTest extends BaseClass {

    //Implement data provider for contact form test with sample data
    @DataProvider(name = "contactFormData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Dasun", "dasun@example.com", "This is a test message."},
                {"Samitha", "samitha@example.com", "Test message 2."}
        };
    }

    @Test(dataProvider = "contactFormData")
    public void TC001(String forename, String email, String message) {
        //Add method to navigate from home page to contact page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        //Implement contact page validation and submit action
        ContactPage contactPage = new ContactPage(driver);
        //Validate user is on the contact page after navigation
        Assert.assertTrue(contactPage.isOnContactPage(), "User is NOT on the Contact page!");
        contactPage.clickSubmit();

        //Add validation to check for error messages on the contact page
        Assert.assertTrue(contactPage.areErrorsDisplayed(), "Error messages should be displayed!");

        //Fill mandatory fields on the contact page with test data
        contactPage.fillMandatoryFields(forename, email, message);
        //Validate disappearance of error messages after filling in mandatory fields
        Assert.assertTrue(contactPage.areErrorsGone(), "Error messages should disappear after filling in fields!");
    }

}
