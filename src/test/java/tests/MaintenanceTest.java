package tests;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MaintenancePage;

@Listeners({AllureTestNg.class})
public class MaintenanceTest extends BaseTest {

    @Feature("Maintenance")
    @Story("Verify access to Maintenance module after authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test maintenance module access after password confirmation", priority = 1)
    public void testAccessToMaintenanceModule() {
        Allure.step("Step 1: Log in using valid credentials");
        login();

        Allure.step("Step 2: Navigate to Maintenance tab");
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.navigateToMaintenanceTab();

        Allure.step("Step 3: Enter password and confirm");
        maintenancePage.authenticateAndAccess("admin123");

        Allure.step("Step 4: Verify access to Maintenance records page");
        Assert.assertTrue(maintenancePage.isMaintenanceHeaderVisible(), "Maintenance header is not visible.");
        Assert.assertTrue(maintenancePage.isEmployeeRecordsLabelVisible(), "Employee records label is not visible.");
    }

    @Feature("Maintenance")
    @Story("Password Verification Failure")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test maintenance module access with invalid password",priority = 2)
    public void testInvalidAccessToMaintenanceModule() {
        Allure.step("Step 1: Log in using valid credentials");
        login();

        Allure.step("Step 2: Navigate to Maintenance tab");
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.navigateToMaintenanceTab();

        Allure.step("Step 3: Enter password and confirm");
        maintenancePage.authenticateAndAccess("admin1233");

        Allure.step("Step 4: Validate if Error message is displayed after login attempt");
        Assert.assertTrue(maintenancePage.isInvalidMsgDisplayed(), "login failed: Invalid credentials.");
    }

    @Feature("Maintenance")
    @Story("Empty Password Submission")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Test access to Maintenance module without entering password", priority = 3)
    public void testAccessWithoutPassword() {
        Allure.step("Step 1: Log in using valid credentials");
        login();

        Allure.step("Step 2: Navigate to Maintenance tab");
        MaintenancePage maintenancePage = new MaintenancePage(driver);
        maintenancePage.navigateToMaintenanceTab();

        Allure.step("Step 3: Click confirm without entering password");
        maintenancePage.confirmPassword();

        Allure.step("Step 4: Verify access is not granted");
        Assert.assertTrue(maintenancePage.isPassRequiredDisplayed(), "Password required.");
    }
}
