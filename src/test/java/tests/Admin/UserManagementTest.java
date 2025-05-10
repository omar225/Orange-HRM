package tests.Admin;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.Admin.UserManagementPage;
import tests.BaseTest;
import java.time.Duration;

@Feature("User Management")
@Listeners({AllureTestNg.class})
public class UserManagementTest extends BaseTest {

    @Test(description = "Navigate to User Management page")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensure that admin can navigate to the User Management page.")
    public void testNavigateToUserManagementPage() {
        Allure.step("Login as Admin");
        login();
        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();
        Allure.step("Verify User Management table is visible");
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User Management page is not visible.");
    }

    @Test(description = "Search for an existing user")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that searching with an existing username returns results.")
    public void testSearchExistingUser() {
        Allure.step("Login as Admin");
        login();
        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        String existingUsername = "Admin";
        Allure.step("Enter username: " + existingUsername);
        userManagementPage.enterUsername(existingUsername);
        Allure.step("Click Search");
        userManagementPage.clickSearch();
        Allure.step("Verify search results are visible");
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after search.");
    }

    @Test(description = "Filter users by role")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that filtering users by role works as expected.")
    public void testFilterByUserRole() {
        Allure.step("Login as Admin");
        login();

        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        String roleToSelect = "ESS";

        Allure.step("Select user role: " + roleToSelect);
        userManagementPage.selectUserRole(roleToSelect);

        Allure.step("Click Search");
        userManagementPage.clickSearch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userManagementPage.getUserTable()));

        Allure.step("Verify results table is visible");
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after filtering by role.");
    }

    @Test(description = "Filter users by status")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that filtering users by status works as expected.")
    public void testFilterByStatus() {
        Allure.step("Login as Admin");
        login();

        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        Allure.step("Select status: Enabled");
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.selectStatus("Enabled");

        Allure.step("Click Search");
        userManagementPage.clickSearch();

        Allure.step("Verify table is visible");
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after filtering by status.");
    }

    @Test(description = "Reset filter fields")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that reset button clears all filters.")
    public void testResetFilters() {
        Allure.step("Login as Admin");
        login();

        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();


        UserManagementPage userManagementPage = new UserManagementPage(driver);

        Allure.step("Enter filters and reset");
        userManagementPage.enterUsername("Admin");
        userManagementPage.selectUserRole("ESS");
        userManagementPage.selectStatus("Enabled");
        userManagementPage.clickReset();

        Allure.step("Verify table is still visible");
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after reset.");
    }

    @Test(description = "Add user button is clickable")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Add button is clickable and navigates to the add user page.")
    public void testAddButtonClickable() {
        Allure.step("Login as Admin");
        login();

        Allure.step("Navigate to User Management");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        Allure.step("Click Add button");
        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.clickAdd();

        Allure.step("Verify user table is not visible (navigated away)");
        Assert.assertFalse(userManagementPage.isUserTableVisible(), "User table should not be visible after clicking Add.");
    }
}
