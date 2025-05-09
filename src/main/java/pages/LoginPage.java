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
    private final By forgotPasswordHeader = By.xpath("//h6[contains(.,'Reset Password')]");
    private final By forgotPasswordUsernameField = By.name("username");
    private final By forgotPasswordSubmitButton = By.cssSelector("button[type='submit']");
    private final By forgotPasswordSuccessMsg = By.xpath("//h6[contains(.,'Reset Password link sent successfully')]");
    private final By usernameRequiredErrorMsg = By.xpath("//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]");
    private final By passwordRequiredErrorMsg = By.xpath("//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]");


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
    public boolean isForgotPasswordHeaderDisplayed() {
        return isDisplayed(forgotPasswordHeader);
    }

    public boolean isForgotPasswordSuccessMsgDisplayed() {
        return isDisplayed(forgotPasswordSuccessMsg);
    }

    public boolean isUserLockedOut() {
        return !isEnabled(usernameField) && !isEnabled(passwordField);
    }


    public void enterForgotPasswordUsername(String username) {
        type(forgotPasswordUsernameField, username);
    }

    public void clickForgotPasswordSubmit() {
        click(forgotPasswordSubmitButton);
    }

    public boolean isUsernameRequiredErrorMsgDisplayed() {
        return isDisplayed(usernameRequiredErrorMsg);
    }
    public boolean isPasswordRequiredErrorMsgDisplayed() {
        return isDisplayed(passwordRequiredErrorMsg);
    }

    public void resetPassword(String username) {
        clickForgotPassword();
        enterForgotPasswordUsername(username);
        clickForgotPasswordSubmit();
    }
}
