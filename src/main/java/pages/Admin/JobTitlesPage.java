package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import java.time.Duration;

public class JobTitlesPage extends BasePage {

    private final By adminTab = By.xpath("//span[contains(.,'Admin')]");
    private final By jobDropdown = By.xpath("//span[contains(.,'Job ')]");
    private final By jobTitlesOption = By.xpath("//a[contains(.,'Job Titles')]");
    private final By addButton = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By jobTitleInput = By.xpath("//label[text()='Job Title']/following::input[1]");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By headerTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");

    private final WebDriverWait wait;

    public JobTitlesPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToJobTitles() {
        click(adminTab);
        waitForElementToBeClickable(jobDropdown);
        click(jobDropdown);
        waitForElementToBeClickable(jobTitlesOption);
        click(jobTitlesOption);
    }

    public boolean isJobTitlesPageVisible() {
        return isDisplayed(headerTitle);
    }

    public void clickAddJobTitle() {
        waitForElementToBeClickable(addButton);
        click(addButton);
    }

    public void typeJobTitle(String title) {
        waitForElementToBeClickable(jobTitleInput);
        type(jobTitleInput, title);
    }

    public void clickSave() {
        waitForElementToBeClickable(saveButton);
        click(saveButton);
    }

    private void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
