Test Automation Suite for Jupiter Toys Website
----------------------------------------------

--  Overview  --

This repository contains automated UI test cases for the Jupiter Toys website. 
The test cases are implemented using Selenium with Java, utilizing TestNG and the Page Object Model (POM) design pattern. 
The solution is designed for execution within a CI/CD pipeline (Jenkins) and integrates with GitHub/GitLab for automated test execution.

-- Technology Stack --

      Automation Tool: Selenium WebDriver
    
      Programming Language: Java
    
      Test Framework: TestNG
    
      Design Pattern: Page Object Model (POM)
    
      Build Tool: Maven
    
      CI/CD Integration: Jenkins
    
      IDE: IntelliJ IDEA

-- Test Cases --

Test Case 1: Contact Form Error Validation

        Navigate to the Contact page from the home page.
        
        Click the Submit button without filling in any fields.
        
        Verify error messages appear for mandatory fields.
        
        Populate all mandatory fields.
        
        Validate that the error messages disappear after entering valid inputs.

Test Case 2: Contact Form Successful Submission

      Navigate to the Contact page from the home page.
      
      Fill in all mandatory fields.
      
      Click the Submit button.
      
      Validate that the successful submission message appears.
      
      Execute this test 5 times to ensure a 100% pass rate.

Test Case 3: Shopping Cart Verification

    Add the following items to the cart:
    
    2 Stuffed Frog
    
    5 Fluffy Bunny
    
    3 Valentine Bear
    
    Navigate to the Cart page.
    
    Verify that the subtotal for each product is correctly calculated.
    
    Validate that the price displayed for each product is correct.
    
    Ensure that the total amount equals the sum of all subtotals.

-- Setup and Execution --

-- Prerequisites --

    Install Java (JDK 11 or later)
    
    Install Maven
    
    Install IntelliJ IDEA (or any preferred IDE)
    
    Install Selenium WebDriver dependencies via Maven
    
    Set up TestNG in the project
    
    Configure Jenkins for test execution (optional)

   -- Steps to Run the Tests Locally -- 

    1. Clone the repository:
        git clone https://github.com/SamithaM91/Jupiter_Toys_TestAutomation.git
        cd <project-directory>
        
    2. Install dependencies:
        mvn clean install
        
    3.  Execute tests using Maven:
        mvn test
