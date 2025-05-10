package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LeaveRequestPage extends BasePage {

    private final By leavePage = By.xpath("//span[text()='Leave']/ancestor::a");
    private final By assignLeave = By.xpath("//a[contains(text(),\"Assign Leave\")]");
    private final By leaveTypeDropdown = By.className("oxd-select-text--after");
    private final By leaveTypeOption = By.xpath("//*[contains(text(),'CAN - Bereavement')]");
    private final By leaveTitle = By.xpath("//*[contains(text(),\"Leave\")]");

    private final By assignButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button");
    private final By requiredField = By.className("oxd-form-actions");


    public LeaveRequestPage(WebDriver driver) {
        super(driver);
    }

    public void openLeavePage() {
        click(leavePage);
        waitForPageLoad();
    }

    public boolean checkLeavePageOpened(){
        waitForPageLoad();
        return isDisplayed(leaveTitle);
    }

    public void navigateToAsignLeave(){
        click(assignLeave);
        waitForPageLoad();
    }


    public void selectLeaveType() {
        click(leaveTypeDropdown);
        waitForPageLoad();
        click(leaveTypeOption);
    }

    public void clickAssign() {
        click(assignButton);
        waitForPageLoad();
    }


    public boolean isAssignmentFailed() {
        return isDisplayed(requiredField);
    }
}
