package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By dashboardHeading = By.className("oxd-topbar-header-breadcrumb");
    private final By timeAtWorkWidget = By.xpath("//p[text() = 'Time at Work']");
    private final By myActions = By.xpath("//p[text() = 'My Actions']");
    private final By employeeDistributionSubUnit = By.xpath("//p[text() = 'Employee Distribution by Sub Unit']");
    private final By employeeDistributionByLocation = By.xpath("//p[text() = 'Employee Distribution by Location']");
    private final By quickLaunchWidget = By.xpath("//p[text() = 'Quick Launch']");
    private final By buzzFeed = By.xpath("//p[text() = 'Buzz Latest Posts']");
    private final By assignLeaveButton = By.xpath("//button[@title='Assign Leave']//*[name()='svg']");
    private final By leaveListButton = By.xpath("//button[@title='Leave List']//*[name()='svg']");
    private final By timeSheetsButton = By.xpath("//button[@title='Timesheets']//*[name()='svg']");
    private final By applyLeaveButton = By.xpath("//button[@title='Apply Leave']//*[name()='svg']");
    private final By myLeaveButton = By.xpath("//button[@title='My Leave']//*[name()='svg']");
    private final By myTimesheetButton = By.xpath("//button[@title='My Timesheet']//*[name()='svg']");
    private final By assignLeave = By.xpath("//h6[normalize-space()='Assign Leave']");
    private final By leaveList = By.xpath("//h5[normalize-space()='Leave List']");
    private final By timesheet = By.xpath("//h6[text()= 'Timesheets Pending Action']");
    private final By applyLeave = By.xpath("//h6[normalize-space()='Apply Leave']");
    private final By myLeave = By.xpath("//h5[normalize-space()='My Leave List']");
    private final By myTimesheet = By.xpath("//h6[normalize-space()='My Timesheet']");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardVisible() {
        return isDisplayed(dashboardHeading);
    }

    public boolean isTimeAtWorkVisible() {
        return isDisplayed(timeAtWorkWidget);
    }

    public boolean isMyActionsVisible() {
        return isDisplayed(myActions);
    }

    public boolean isEmployeeDistributionSubUnitVisible() {
        return isDisplayed(employeeDistributionSubUnit);
    }

    public boolean isEmployeeDistributionByLocationVisible() {
        return isDisplayed(employeeDistributionByLocation);
    }

    public boolean isQuickLaunchVisible() {
        return isDisplayed(quickLaunchWidget);
    }

    public boolean isBuzzFeedVisible() {
        return isDisplayed(buzzFeed);
    }

    public boolean isAssignLeaveVisible() {
        return isDisplayed(assignLeave);
    }

    public boolean isLeaveListVisible() {
        return isDisplayed(leaveList);
    }

    public boolean isTimesheetVisible() {
        return isDisplayed(timesheet);
    }

    public boolean isApplyLeaveVisible() {
        return isDisplayed(applyLeave);
    }

    public boolean isMyLeaveVisible() {
        return isDisplayed(myLeave);
    }

    public boolean isMyTimesheetVisible() {
        return isDisplayed(myTimesheet);
    }

    public void assignLeave() {
        click(assignLeaveButton);
    }

    public void leaveList() {
        click(leaveListButton);
    }

    public void timeSheets() {
        click(timeSheetsButton);
    }

    public void applyLeave() {
        click(applyLeaveButton);
    }

    public void myLeave() {
        click(myLeaveButton);
    }

    public void myTimesheet() {
        click(myTimesheetButton);
    }

}