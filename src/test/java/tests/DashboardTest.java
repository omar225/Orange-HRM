package tests;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

import javax.xml.namespace.QName;

@Listeners({AllureTestNg.class})
public class DashboardTest extends BaseTest {

    @Feature("Dashboard")
    @Story("Dashboard Widgets Visibility")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify all main widgets are visible on the dashboard after login")
    public void testDashboardWidgetsVisibility() {
        Allure.step("Step 1: Log in using valid credentials");
        Login();
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

}