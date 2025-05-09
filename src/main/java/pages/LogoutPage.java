package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class LogoutPage extends BasePage {

     private final By userDropdown = By.className("oxd-userdropdown-name");
     private final By logoutOption = By.xpath("//a[contains(.,\"Logout\")]");
     private final By loginPageHeading = By.xpath("//h5[text()='Login']");
     private final By leavePage = By.xpath("//span[text()='Leave']/ancestor::a");
     private final By assignLeave = By.xpath("//a[contains(text(),\"Assign Leave\")]");
     private final By leaveTypeDropdown = By.className("oxd-select-text--after");
     private final By leaveTypeOption = By.xpath("//*[contains(text(),'CAN - Bereavement')]");


    public LogoutPage(WebDriver driver) {
        super(driver);
    }
     public void logout() {
            click(userDropdown);
            waitForPageLoad();
            click(logoutOption);
            waitForPageLoad();
        }

     public boolean isLoginHeadingDisplayed() {
            return isDisplayed(loginPageHeading);
        }

     public void openLeavePage() {
         click(leavePage);
         waitForPageLoad();
        }

     public void fillLeaveFormWithoutSubmitting() {
            click(assignLeave);
            click(leaveTypeDropdown);
            click(leaveTypeOption);
        }

    public boolean isLeaveFormEmpty() {
        waitForElementVisible(leaveTypeDropdown); // ensure dropdown is visible
        return isDisplayed(By.xpath("//*[contains(text(),'Leave Type')]"));
    }

}


