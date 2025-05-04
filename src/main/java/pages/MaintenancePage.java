package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaintenancePage extends BasePage {

    private final By maintenanceTab = By.xpath("//span[text()='Maintenance']");
    private final By passwordField = By.name("password");
    private final By confirmButton = By.xpath("//button[@type='submit']");
    private final By maintenanceHeader = By.xpath("//h6[text()='Maintenance']");
    private final By accessRecords = By.xpath("//a[text()='Access Records']");
    private final By invalidMsg = By.xpath("//p[text()='Invalid credentials']");
    private final By passRequired = By.xpath("//span[text()='Required']");

    public MaintenancePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToMaintenanceTab() {
        click(maintenanceTab);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void confirmPassword() {
        click(confirmButton);
    }

    public boolean isMaintenanceHeaderVisible() {
        return isDisplayed(maintenanceHeader);
    }

    public boolean isEmployeeRecordsLabelVisible() {
        return isDisplayed(accessRecords);
    }

    public void authenticateAndAccess(String password) {
        enterPassword(password);
        confirmPassword();
    }

    public boolean isInvalidMsgDisplayed() {
        return isDisplayed(invalidMsg);
    }

    public boolean isPassRequiredDisplayed() {
        return isDisplayed(passRequired);
    }

}