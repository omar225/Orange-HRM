package tests;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners({AllureTestNg.class})
public class LogoutTest extends BaseTest {

   //Test Unsaved Data Discarded After Logout
    @Test(description = "Verify unsaved form data is discarded after logout")
    @Feature("Logout")
    @Story("Form Reset on Logout")
    @Severity(SeverityLevel.CRITICAL)
    public void testUnsavedDataDiscardedAfterLogout() {
        Allure.step("Step 1: Login to OrangeHRM with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");


        Allure.step("Step 2: Navigate to Leave > Assign Leave and select a leave type");
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.openLeavePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        logoutPage.fillLeaveFormWithoutSubmitting();



        Allure.step("Step 3: Logout without submitting");
        logoutPage.logout();

        Allure.step("Step 4: Login again");
        loginPage.login("Admin", "admin123");

        Allure.step("Step 5: Navigate again to Apply Leave form");
        logoutPage.openLeavePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));


        Allure.step("Step 6: Verify that form is empty");
        Assert.assertTrue(logoutPage.isLeaveFormEmpty(), "Form data was not cleared after logout.");
    }


    //Test Basic Logout Redirect
    @Test(description = "Verify successful logout redirects to login page")
    @Feature("Logout")
    @Story("Logout Success")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogoutRedirect() {
        Allure.step("Step 1: Login to OrangeHRM with valid credentials");
        Login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100000));


        Allure.step("Step 2: Logout");
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Allure.step("Step 3: Verify login page is shown");
        Assert.assertTrue(logoutPage.isLoginHeadingDisplayed(), "Logout failed or login page not shown.");
    }


}
