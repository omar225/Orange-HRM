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
    private final By buzzFeed = By.xpath("//p[text() = 'Quick Launch']");


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


}