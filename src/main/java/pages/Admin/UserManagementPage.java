package pages.Admin;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import pages.BasePage;

public class UserManagementPage extends BasePage {

    // Locators
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private final By userRoleDropdown = By.className("oxd-select-wrapper");
    private final By employeeNameField = By.className("oxd-autocomplete-wrapper");
    private final By statusDropdown = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')]");
    private final By userTable = By.xpath("//div[contains(@class,'orangehrm-paper-container')]");
    private final By dropdownOptions = By.xpath("//div[@role='listbox']//span");
    private final By addUserTable = By.className("orangehrm-card-container");

    public UserManagementPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Search Button")
    public void clickSearch() {
        click(searchButton);
    }

    @Step("Click Reset Button")
    public void clickReset() {
        click(resetButton);
    }

    @Step("Click Add Button")
    public void clickAdd() {
        click(addButton);
    }

    @Step("Enter Username: {username}")
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    @Step("Enter Employee Name: {name}")
    public void enterEmployeeName(String name) {
        type(employeeNameField, name);
    }

    @Step("Select User Role: {role}")
    public void selectUserRole(String role) {
        selectFromDropdown(userRoleDropdown, role);
    }

    @Step("Select Status: {status}")
    public void selectStatus(String status) {
        selectFromDropdown(statusDropdown, status);
    }

    @Step("Check if User Table is Visible")
    public boolean isUserTableVisible() {
        return isDisplayed(userTable);
    }

    private void selectFromDropdown(By dropdownLocator, String visibleText) {
        click(dropdownLocator);
        for (WebElement option : driver.findElements(dropdownOptions)) {
            if (option.getText().trim().equalsIgnoreCase(visibleText)) {
                option.click();
                return;
            }
        }
        throw new RuntimeException("Option not found in dropdown: " + visibleText);
    }

    public By getUserTable() {
        return userTable;
    }
}
