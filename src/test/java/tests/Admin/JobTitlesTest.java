package tests.Admin;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Admin.JobTitlesPage;
import tests.BaseTest;

@Feature("Job Titles Page")
@Listeners({AllureTestNg.class})
public class JobTitlesTest extends BaseTest {

    @Test
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify if Job Titles page is visible")
    public void testJobTitlesNavigation() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.goToJobTitles();

        Allure.step("Verifying Job Titles page visibility");
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible.");
    }

    @Test
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify adding a new Job Title")
    public void testAddJobTitle() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.goToJobTitles();

        Allure.step("Clicking on Add Job Title button");
        jobTitlesPage.clickAddJobTitle();

        Allure.step("Typing job title as 'QA Engineer'");
        jobTitlesPage.typeJobTitle("QA Engineer");

        Allure.step("Clicking on Save button");
        jobTitlesPage.clickSave();

        Allure.step("Verifying the Job Titles page is visible after saving");
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving.");
    }

    @Test
    @Story("Orange HRM - Performance Reviews")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to measure the performance of Job Titles page load time")
    public void testJobTitlesPageLoadPerformance() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);

        Allure.step("Measuring load time of Job Titles page");
        long startTime = System.currentTimeMillis();
        jobTitlesPage.goToJobTitles();
        long endTime = System.currentTimeMillis();

        long loadTime = endTime - startTime;
        System.out.println("Job Titles page load time: " + loadTime + " milliseconds");

        Allure.step("Asserting the load time is below 3000 milliseconds");
        Assert.assertTrue(loadTime < 3000, "Job Titles page took too long to load: " + loadTime + " milliseconds");
    }

    @Test
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to add multiple job titles")
    public void testAddMultipleUsers() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.goToJobTitles();

        for (int i = 1; i <= 4; i++) {
            String title = "OHRM " + i;

            Allure.step("Clicking on Add Job Title button for: " + title);
            jobTitlesPage.clickAddJobTitle();

            Allure.step("Typing job title: " + title);
            jobTitlesPage.typeJobTitle(title);

            Allure.step("Clicking on Save button");
            jobTitlesPage.clickSave();

            Allure.step("Verifying that the Job Titles page is visible after adding: " + title);
            Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after adding: " + title);
            }
    }

    @Test
    @Story("Orange HRM - Employee Management")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to add job title with an empty field")
    public void testAddJobTitleWithEmptyField() {
        JobTitlesPage jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.goToJobTitles();

        Allure.step("Clicking on Add Job Title button");
        jobTitlesPage.clickAddJobTitle();

        Allure.step("Typing empty job title");
        jobTitlesPage.typeJobTitle("");

        Allure.step("Clicking on Save button");
        jobTitlesPage.clickSave();

        Allure.step("Verifying the Job Titles page is visible after saving with empty field");
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving with empty field.");
    }
}
