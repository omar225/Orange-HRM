package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By forgotPasswordLink = By.xpath("//p[contains(., 'Forgot your password')]");
    private final By dashboardHeading = By.xpath("//h6[contains(.,'Dashboard')]");
    private final By errorMsg = By.xpath("//p[contains(., 'Invalid credentials')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public boolean isDashboardHeadingDisplayed() {
        return isDisplayed(dashboardHeading);
    }
    public boolean isErrorMsgDisplayed() {
        return isDisplayed(errorMsg);
    }
}
