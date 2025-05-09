package pages.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;
import pages.BasePage;
import java.time.Duration;

public class JobTitlesPage extends BasePage {

    private final By adminTab = By.xpath("//span[contains(.,'Admin')]");
    private final By jobDropdown = By.xpath("//span[normalize-space()='Job']");
    private final By jobTitlesOption = By.xpath("//a[normalize-space()='Job Titles']");
    private final By addButton = By.xpath("//button[normalize-space()='Add']");
    private final By jobTitleInput = By.xpath("//label[text()='Job Title']/following::input[1]");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By headerTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    private final By deleteSingleButton = By.name("oxd-icon bi-x oxd-sidepanel-header-close");

    public final By jobTitleRowByName(String title) {
        return By.xpath("//a[normalize-space()='" + title + "']");
    }

    private final By deleteIconForTitle(String title) {
        return By.xpath("//a[normalize-space()='" + title + "']//following-sibling::button[contains(@class,'delete-button')]");
    }

    private final WebDriverWait wait;

    public JobTitlesPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Navigating to Job Titles page")
    public void goToJobTitles() {
        click(adminTab);
        waitForElementToBeClickable(jobDropdown);
        click(jobDropdown);
        waitForElementToBeClickable(jobTitlesOption);
        click(jobTitlesOption);
    }

    @Step("Checking if Job Titles page is visible")
    public boolean isJobTitlesPageVisible() {
        return isDisplayed(headerTitle);
    }

    @Step("Clicking on Add Job Title button")
    public void clickAddJobTitle() {
        click(addButton);
    }

    @Step("Typing Job Title")
    public void typeJobTitle(String title) {
        type(jobTitleInput, title);
    }

    @Step("Clicking Save button after typing job title")
    public void clickSave() {
        scrollToElement(saveButton);
        click(saveButton);
    }

    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Deleting Job Title with name: {title}")
    public void deleteJobTitle(String title) {
        click(deleteIconForTitle(title));
    }

    private void waitForElementToBeClickable(By locator) {
        wait.until(driver -> driver.findElement(locator).isDisplayed());
    }
}
