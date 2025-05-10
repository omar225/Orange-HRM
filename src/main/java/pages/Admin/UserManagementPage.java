package pages.Admin;

import org.openqa.selenium.*;
import pages.BasePage;

public class UserManagementPage extends BasePage {

    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private final By userRoleDropdown = By.className("oxd-select-wrapper");
    private final By statusDropdown = By.xpath("(//div[contains(text(), '-- Select --')])[2]");
    private final By userTable = By.xpath("//div[contains(@class,'orangehrm-paper-container')]");
    private final By dropdownOptions = By.xpath("//div[@role='listbox']//span");

    public UserManagementPage(WebDriver driver) {
        super(driver);
    }


    public void clickSearch() {
        click(searchButton);
    }

    public void clickReset() {
        click(resetButton);
    }


    public void clickAdd() {
        click(addButton);
    }


    public void enterUsername(String username) {
        type(usernameField, username);
    }


    public void selectUserRole(String role) {
        selectFromDropdown(userRoleDropdown, role);
    }


    public void selectStatus(String status) {
        selectFromDropdown(statusDropdown, status);
    }


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
