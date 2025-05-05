package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;


@Listeners({AllureTestNg.class})
public class DashboardTest extends BaseTest {

    @Feature("Dashboard")
    @Story("Dashboard Widgets Visibility")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify all main widgets are visible on the dashboard after login",priority = 1)
    public void testDashboardWidgetsVisibility() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Verify Time at Work widget is visible");
        Assert.assertTrue(dashboardPage.isTimeAtWorkVisible(), "Time at Work widget is not visible.");


        Allure.step("Step 5: Verify My Actions widget is visible");
        Assert.assertTrue(dashboardPage.isMyActionsVisible(), "My Actions widget is not visible.");


        Allure.step("Step 6: Verify Employee Distribution by Sub Unit is visible");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionSubUnitVisible(), "Employee Distribution by Sub Unit is not visible.");


        Allure.step("Step 7: Verify Employee Distribution by Location is visible");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionByLocationVisible(), "Employee Distribution by Location is not visible.");


        Allure.step("Step 8: Verify Quick Launch widget is visible");
        Assert.assertTrue(dashboardPage.isQuickLaunchVisible(), "Quick Launch widget is not visible.");


        Allure.step("Step 9: Verify Buzz Feed is visible");
        Assert.assertTrue(dashboardPage.isBuzzFeedVisible(), "Buzz Feed is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Assign Leave Link",priority = 2)
    public void testAssignLeaveLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click Assign Leave link");
        dashboardPage.assignLeave();


        Allure.step("Step 5: Verify Assign Leave is visible");
        Assert.assertTrue(dashboardPage.isAssignLeaveVisible(), "Assign Leave is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Leave List Link",priority = 3)
    public void testLeaveListLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click Leave list link");
        dashboardPage.leaveList();


        Allure.step("Step 5: Verify Assign Leave is visible");
        Assert.assertTrue(dashboardPage.isLeaveListVisible(), "Leave list is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Time Sheet Link",priority = 4)
    public void testTimesheetLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click My Timesheet link");
        dashboardPage.timeSheets();


        Allure.step("Step 5: Timesheets is visible");
        Assert.assertTrue(dashboardPage.isTimesheetVisible(), "Timesheet is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Apply Leave Link",priority = 5)
    public void testApplyLeaveLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click Apply Leave link");
        dashboardPage.applyLeave();


        Allure.step("Step 5: Apply Leave is visible");
        Assert.assertTrue(dashboardPage.isApplyLeaveVisible(), "Apply Leave is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify My Leave Link", priority = 6)
    public void testMyLeaveLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click My Leave link");
        dashboardPage.myLeave();


        Allure.step("Step 5: My Leave List is visible");
        Assert.assertTrue(dashboardPage.isMyLeaveVisible(), "My Leave List is not visible.");

    }

    @Feature("Dashboard")
    @Story("Quick Launch Links Navigation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify My Timesheet Link",priority = 7)
    public void testMyTimesheetLink() {
        Allure.step("Step 1: Log in using valid credentials");
        login();
        Allure.step("Step 2: Initialize Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(driver);


        Allure.step("Step 3: Verify Dashboard heading is visible");
        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard heading is not visible.");


        Allure.step("Step 4: Click My Timesheet link");
        dashboardPage.myTimesheet();


        Allure.step("Step 5: My Timesheet is visible");
        Assert.assertTrue(dashboardPage.isMyTimesheetVisible(), "My Timesheet is not visible.");

    }
}