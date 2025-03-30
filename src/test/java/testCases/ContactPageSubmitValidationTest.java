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
 * 2. Populate mandatory fields
 * 3. Click submit button
 * 4. Validate successful submission message
 * Run this test 5 times to ensure 100% pass rate
 */
public class ContactPageSubmitValidationTest extends BaseClass {

    //Create data provider for valid contact form submissions with sample data
    @DataProvider(name = "validFormData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Samitha", "samitha@example.com", "Hello Samitha!"},
                {"Anupama", "anupama@example.com", "Hello Anupama!"},
                {"Yashoda", "yashoda@example.com", "Hello Yashoda!"},
                {"Dasun", "dasun@example.com", "Hello Dasun!"},
                {"Nevan", "nevan@example.com", "Hello Nevan!"}
        };
    }

    @Test(dataProvider = "validFormData")
    public void TC002(String forename, String email, String message) {
        //Add method to navigate from home page to contact page
        HomePage homePage = new HomePage(driver);
        homePage.navigateToContactPage();

        //Fill mandatory fields and submit the contact form using data provider
        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillMandatoryFields(forename, email, message);
        contactPage.clickSubmit();
        //Verify that error messages are not displayed after successful form submission
        Assert.assertFalse(contactPage.areErrorsDisplayed(), "Success Message should be displayed");

    }

}