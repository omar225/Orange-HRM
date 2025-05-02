package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;


@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {

    @Feature("Login")
    @Story("Orange HRM - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test Login with valid username and password")
    public void testValidLogin() {
        // Starting the test in Allure
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login action");
        loginPage.login("Admin", "admin123");

        Allure.step("Step 3: Validate if Dashboard heading is displayed after login");
        Assert.assertTrue(
                loginPage.isDashboardHeadingDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }


    @Feature("Login")
    @Story("Orange HRM - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid username and invalid password")
    public void testLoginWithInvalidPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("Admin", "wrongpassword" );

        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("Orange HRM - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and valid password")
    public void testLoginWithInvalidUsername() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("wrongusername", "admin123" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }

    @Feature("Login")
    @Story("Orange HRM - Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and invalid password")
    public void testLoginWithInvalidUsernameAndPassword() {
        Allure.step("Step 1: Initialize Login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("WrongUsername", "wrongpassword" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "Login failed: Dashboard heading is not displayed."
        );
    }
}
