package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

    private final By adminTab = By.xpath("//span[text()='Admin']");
    private final By userManagementOption = By.xpath("//span[normalize-space()='User Management']");
    private final By usersOption = By.className("oxd-topbar-body-nav-tab-link");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By addButton = By.xpath("//button[@type='submit']");
    private final By usernameField = By.xpath("//label[text()='Username']/following::input[1]");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void goToUserManagement() {
        click(adminTab);
        click(userManagementOption);
        click(usersOption);
    }

    public boolean isUserManagementPageVisible() {
        return isDisplayed(searchButton);
    }

    public void clickAddUser() {
        click(addButton);
    }

    public void typeUsername(String username) {
        type(usernameField, username);
    }
}
