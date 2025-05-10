package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LeaveRequestPage;
import pages.LoginPage;

@Epic("Leave Management")
@Feature("Leave Request")
@Listeners({AllureTestNg.class})
public class LeaveRequestTest extends BaseTest {

    @Test(description = "Verify successfully navigated to Leave page")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid Leave Page")
    public void testNavigateToLeaveRequest() {
        Allure.step("Step 1: Login to the application with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Allure.step("Step 2: Navigate to the Leave page");
        LeaveRequestPage leaveRequestPage = new LeaveRequestPage(driver);
        leaveRequestPage.openLeavePage();

        Allure.step("Step 3: Verify that the Leave page is opened successfully");
        Assert.assertTrue(leaveRequestPage.checkLeavePageOpened());

    }



    @Test(description = "Leave Assignment with Empty Fields")
    @Severity(SeverityLevel.NORMAL)
    @Story("Required Field Validation - Employee Name")
    public void testLeaveAssignmentWithEmptyFields() {
        Allure.step("Step 1: Login to the application with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        Allure.step("Step 2: Navigate to the Leave page");
        LeaveRequestPage leaveRequestPage = new LeaveRequestPage(driver);
        leaveRequestPage.openLeavePage();


        Allure.step("Step 3: Navigate to assign leave tab");
        leaveRequestPage.navigateToAsignLeave();

        Allure.step("Step 4: Assign some fields not all");
        leaveRequestPage.selectLeaveType();
        leaveRequestPage.clickAssign();

        Allure.step("Step 5: Check the assignment process failed");
        Assert.assertTrue(leaveRequestPage.isAssignmentFailed());

    }
}
