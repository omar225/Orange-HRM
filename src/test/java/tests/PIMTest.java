package tests;

import com.beust.ah.A;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import pages.BasePage;
import pages.PIMPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;


@Listeners({AllureTestNg.class})
public class PIMTest extends BaseTest {

    
    @Feature("PIM")
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "verify that the system can successfully import and add multiple employees from a properly formatted CSV", priority = 0)
    public void uploadValidCSV() {
        Allure.step("Step 1: Initialize login Page");
        login();
        Allure.step("Step 2: Initialize PIM Page");
        PIMPage pimPage = new PIMPage(driver);

        Allure.step("Step 3: Click on PIM button");
        pimPage.clickPIMButton();

        Allure.step("Step 4: Click on Employee List button");
        pimPage.clickEmployeeListButton();

        Allure.step("Step 5 : Delete all employees");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (!pimPage.isCounterNumberEqualToOne()) {
            while (!pimPage.isCounterNumberEqualToOne()) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                pimPage.clickSelectAllCheckbox();
                pimPage.clickDeleteButton();
                pimPage.clickConfirmDeleteButton();
            }
        }
        Allure.step("Step 3: Click on Configurations button");
        pimPage.clickConfigurationsButton();

        Allure.step("Step 4: Click on Data Import button");
        pimPage.clickDataImportButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Allure.step("Step 5: Upload CSV file");
        pimPage.validUpload();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Allure.step("Step 6: Click on Upload button");
        pimPage.clickUploadButton();

        Allure.step("Step 7: Verify upload success message");
        Assert.assertTrue(
                pimPage.isUploadSuccessMsgDisplayed(),
                "Upload success message is not displayed"
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}