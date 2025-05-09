package tests.Admin;

import io.qameta.allure.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.Admin.UserManagementPage;
import tests.BaseTest;

import java.time.Duration;

@Epic("Admin")
@Feature("User Management")
public class UserManagementTest extends BaseTest {

    @Test(description = "Navigate to User Management page")
    @Story("Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Ensure that admin can navigate to the User Management page.")
    public void testNavigateToUserManagementPage() {
        login();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User Management page is not visible.");
    }

    @Test(description = "Search for an existing user")
    @Story("Search")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that searching with an existing username returns results.")
    public void testSearchExistingUser() {
        login();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        String existingUsername = "Admin";

        userManagementPage.enterUsername(existingUsername);
        userManagementPage.clickSearch();

        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after search.");
    }

    @Test(description = "Filter users by role")
    @Story("Filter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that filtering users by role works as expected.")
    public void testFilterByUserRole() {
        login();

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        String roleToSelect = "ESS";

        userManagementPage.selectUserRole(roleToSelect);
        userManagementPage.clickSearch();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userManagementPage.getUserTable()));

        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after filtering by role.");
    }

    @Test(description = "Filter users by status")
    @Story("Filter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that filtering users by status works as expected.")
    public void testFilterByStatus() {
        login();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.selectStatus("Enabled");
        userManagementPage.clickSearch();

        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after filtering by status.");
    }

    @Test(description = "Reset filter fields")
    @Story("Reset")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that reset button clears all filters.")
    public void testResetFilters() {
        login();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.enterUsername("Admin");
        userManagementPage.selectUserRole("ESS");
        userManagementPage.selectStatus("Enabled");
        userManagementPage.clickReset();

        Assert.assertTrue(userManagementPage.isUserTableVisible(), "User table not visible after reset.");
    }

    @Test(description = "Add user button is clickable")
    @Story("Add User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Add button is clickable and navigates to the add user page.")
    public void testAddButtonClickable() {
        login();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        UserManagementPage userManagementPage = new UserManagementPage(driver);
        userManagementPage.clickAdd();

        Assert.assertFalse(userManagementPage.isUserTableVisible(), "User table should not be visible after clicking Add.");
    }
}
