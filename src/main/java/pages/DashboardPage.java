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
    private final By assignLeave = By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title");
    private final By leaveList = By.cssSelector(".oxd-text.oxd-text--h5.oxd-table-filter-title");
    private final By timesheet = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-level");
    private final By applyLeave = By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title");
    private final By myLeave = By.cssSelector(".oxd-text.oxd-text--h5.oxd-table-filter-title");
    private final By myTimesheet = By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title");


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

    public void assignLeaveButton() {
        click(assignLeaveButton);
    }

    public void leaveListButton() {
        click(leaveListButton);
    }

    public void timeSheetsButton() {
        click(timeSheetsButton);
    }

    public void applyLeaveButton() {
        click(applyLeaveButton);
    }

    public void myLeaveButton() {
        click(myLeaveButton);
    }

    public void myTimesheetButton() {
        click(myTimesheetButton);
    }

}