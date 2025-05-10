package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;


@Listeners({AllureTestNg.class})
public class LoginTest extends BaseTest {


    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid username and password",
            priority = 1)
    public void testValidLogin() {
        // Starting the test in Allure
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Step 2: Perform login action");
        loginPage.login("Admin", "admin123");

        Allure.step("Step 3: Validate if Dashboard heading is displayed after login");
        Assert.assertTrue(
                loginPage.isDashboardHeadingDisplayed(),
                "login failed: Dashboard heading is not displayed."
        );
    }


    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid username and invalid password",priority = 2)
    public void testLoginWithInvalidPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("Admin", "wrongpassword" );

        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and valid password",priority = 3)
    public void testLoginWithInvalidUsername() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("wrongusername", "admin123" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with invalid username and invalid password",priority = 4)
    public void testLoginWithInvalidUsernameAndPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("WrongUsername", "wrongpassword" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with empty username and password",priority = 5)
    public void testLoginWithEmptyUsernameAndPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("", "" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isUsernameRequiredErrorMsgDisplayed() && loginPage.isPasswordRequiredErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with empty username and valid password" ,priority = 6)
    public void testLoginWithEmptyUsernameAndValidPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("", "admin123" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isUsernameRequiredErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with valid username and empty password" ,priority = 7)
    public void testLoginWithValidUsernameAndEmptyPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("Admin", "" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isPasswordRequiredErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with case-sensitive password" ,priority = 8)
    public void testLoginWithCaseSensitiveUsernameAndPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("admin", "ADMIN123" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test login with Case-sensitive username" ,priority = 9)
    public void testLoginWithCaseSensitiveUsername() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("AdMiN", "admin123" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertFalse(
                loginPage.isDashboardHeadingDisplayed(),
                "Login should not be successful with case-sensitive username"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test login with special characters in username and password" ,priority = 10)
    public void testLoginWithSpecialCharactersInUsernameAndPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform login action");
        loginPage.login("!@#$%^", "!@#$%^" );
        Allure.step("Step 3: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(
                loginPage.isErrorMsgDisplayed(),
                "login failed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Test Forgot Password link" ,priority = 11)
    public void testForgotPassword() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Click on Forgot Password link");
        loginPage.clickForgotPassword();
        Allure.step("Step 3: Validate if Forgot Password page is displayed");
        Assert.assertTrue(
                loginPage.isForgotPasswordHeaderDisplayed(),
                "Forgot Password page is not displayed"
        );

        Allure.step("Step 4: Enter username in Forgot Password page");
        loginPage.enterForgotPasswordUsername("Admin");
        Allure.step("Step 5: Click on Submit button");
        loginPage.clickForgotPasswordSubmit();
        Allure.step("Step 6: Validate if success message is displayed");
        Assert.assertTrue(
                loginPage.isForgotPasswordSuccessMsgDisplayed(),
                "Forgot Password success message is not displayed"
        );
    }

    @Feature("login")
    @Story("Orange HRM - login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test multiple login attempts with invalid credentials" ,priority = 12)
   public void testMultipleLoginAttemptsWithInvalidCredentials() {
        Allure.step("Step 1: Initialize login Page");
        LoginPage loginPage = new LoginPage(driver);
        Allure.step("Step 2: Perform multiple login attempts with invalid credentials");
        for (int i = 0; i < 20; i++) {
            loginPage.login("wrongusername", "wrongpassword");
        }
        Assert.assertTrue(
                loginPage.isUserLockedOut(),
                "Test failed: User is not locked out after multiple invalid login attempts"
        );
    }
}
