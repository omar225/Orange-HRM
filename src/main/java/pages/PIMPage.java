package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMPage extends BasePage {


    private final By PIMButton = By.xpath("//a[contains(.,'PIM')]");
    private final By configurationsButton = By.cssSelector(".oxd-icon.bi-chevron-down");
    private final By dataImportButton = By.xpath("//a[contains(.,'Data Import')]");
    private final By dataImportUploadField = By.cssSelector("input[type='file']");
    private final By uploadButton = By.xpath("//button[@type='submit']");
    private final By uploadSuccessMsg = By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body orangehrm-success-message']");
    private final By uploadErrorMsg = By.xpath("(//p[contains(@class, 'orangehrm-error-message')])[1]");
    private final By dataImportHeading = By.xpath("//p[contains(.,'Data Import')]");
    private final By employeeListButton = By.xpath("//a[contains(.,'Employee List')]");
    private final By selectAllCheckbox = By.cssSelector("div.oxd-table-header .oxd-checkbox-wrapper");
    private final By deleteButton = By.xpath("//button[contains(.,'Delete Selected')] ");
    private final By confirmDeleteButton = By.xpath("//button[contains(.,'Yes, Delete')] ");
    private final By recordsFoundElement = By.cssSelector("div.orangehrm-horizontal-padding.orangehrm-vertical-padding span.oxd-text.oxd-text--span");

    // File paths for CSV files
    private String validCSVFile = System.getProperty("user.dir") + "/src/main/resources/DataImportFiles/OHRMData.csv";
    private String CSVFileWithMissingData = System.getProperty("user.dir") + "/src/main/resources/DataImportFiles/MissingRequiredFieldsData.csv";
    private String CSVFileWithDataExceedingLimits = System.getProperty("user.dir") + "/src/main/resources/DataImportFiles/EmployeeData110.csv";
    private String CSVFileWithDupeIds = System.getProperty("user.dir") + "/src/main/resources/DataImportFiles/DupeIdsData.csv";
    private String CSVFileJustUnder1MB = System.getProperty("user.dir") + "/src/main/resources/DataImportFiles/employee_data_under_1mb.csv";

    // Constructor
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with the page
    public void clickPIMButton() {
        click(PIMButton);
    }

    public void clickConfigurationsButton() {
        click(configurationsButton);
    }

    public void clickDataImportButton() {
        click(dataImportButton);
    }

    public void validUpload() {
        uploadFile(dataImportUploadField, validCSVFile);
    }

    public void missingDataUpload()
    {
        uploadFile(dataImportUploadField, CSVFileWithMissingData);
    }

    public void dataExceedingLimitsUpload()
    {
        uploadFile(dataImportUploadField, CSVFileWithDataExceedingLimits);
    }

    public void dupeIdsUpload()
    {
        uploadFile(dataImportUploadField, CSVFileWithDupeIds);
    }

    public void justUnder1MBUpload()
    {
        uploadFile(dataImportUploadField, CSVFileJustUnder1MB);
    }

    public void clickUploadButton() {
        click(uploadButton);
    }

    public boolean isUploadSuccessMsgDisplayed() {
        return isDisplayed(uploadSuccessMsg);
    }

    public boolean isUploadErrorMsgDisplayed() {
        return isDisplayed(uploadErrorMsg);
    }


    public boolean isDataImportHeadingDisplayed() {
        return isDisplayed(dataImportHeading);
    }

    public void clickEmployeeListButton() {
        click(employeeListButton);
    }

    public void clickSelectAllCheckbox() {
        click(selectAllCheckbox);
    }

    public void clickDeleteButton() {
        click(deleteButton);
    }

    public void clickConfirmDeleteButton() {
        click(confirmDeleteButton);
    }

    public boolean isDeleteButtonDisplayed() {
        return isDisplayed(deleteButton);
    }

    public int getRecordsFoundCount() {
        WebElement element = driver.findElement(recordsFoundElement);
        String text = element.getText(); // e.g., "(98) Records Found"
        String number = text.replaceAll("[^0-9]", "");
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
    public boolean isCounterNumberEqualToOne() {
        return getRecordsFoundCount() == 1;
    }


}
