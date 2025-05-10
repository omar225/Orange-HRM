package tests.Admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin.JobTitlesPage;
import tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class JobTitlesTest extends BaseTest {

    private JobTitlesPage jobTitlesPage;

    @BeforeMethod
    public void setUp() {
        login();
        jobTitlesPage = new JobTitlesPage(driver);
        jobTitlesPage.goToJobTitles();
    }


    @Test
    @Description("Test to verify if Job Titles page is visible")
    @Story("Orange HRM - Employee Management")
    public void testJobTitlesNavigation() {
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible.");
    }

    @Test
    @Description("Test to verify adding a new Job Title")
    @Story("Orange HRM - Employee Management")
    public void testAddJobTitle() {
        jobTitlesPage.clickAddJobTitle();
        jobTitlesPage.typeJobTitle("QA Engineer");
        jobTitlesPage.clickSave();
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving.");
    }

    @Test
    @Description("Test to measure the performance of Job Titles page load time")
    @Story("Orange HRM - Performance Reviews")
    public void testJobTitlesPageLoadPerformance() {
        long startTime = System.currentTimeMillis();
        jobTitlesPage.goToJobTitles();
        long endTime = System.currentTimeMillis();

        long loadTime = endTime - startTime;
        System.out.println("Job Titles page load time: " + loadTime + " milliseconds");

        Assert.assertTrue(loadTime < 3000, "Job Titles page took too long to load: " + loadTime + " milliseconds");
    }

    @Test
    @Description("Test to add multiple job titles")
    @Story("Orange HRM - Employee Management")
    public void testAddMultipleUsers() {
            for (int i = 1; i <= 4; i++) {
                jobTitlesPage.clickAddJobTitle();
                jobTitlesPage.typeJobTitle("OHRM " + i);
                jobTitlesPage.clickSave();
            }
    }

    @Test
    @Description("Test to add job title with an empty field")
    @Story("Orange HRM - Employee Management")
    public void testAddJobTitleWithEmptyField() {
        jobTitlesPage.clickAddJobTitle();
        jobTitlesPage.typeJobTitle("");
        jobTitlesPage.clickSave();
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving with empty field.");
    }
}
