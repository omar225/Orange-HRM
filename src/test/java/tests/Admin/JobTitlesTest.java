package tests.Admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin.JobTitlesPage;
import tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

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
    @Story("As a user, I want to check if Job Titles page is visible after navigation")
    @TmsLink("https://jira.company.com/browse/HR-101")
    public void testJobTitlesNavigation() {
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible.");
    }

    @Test
    @Description("Test to verify adding a new Job Title")
    @Story("As a user, I want to add a new Job Title")
    @TmsLink("https://jira.company.com/browse/HR-102")
    public void testAddJobTitle() {
        jobTitlesPage.clickAddJobTitle();
        jobTitlesPage.typeJobTitle("QA Engineer");
        jobTitlesPage.clickSave();
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving.");
    }

    @Test
    @Description("Test to verify deleting a Job Title")
    @Story("As a user, I want to delete a Job Title")
    @TmsLink("https://jira.company.com/browse/HR-103")
    public void testDeleteJobTitle() {
        jobTitlesPage.deleteJobTitle("QA Engineer");
        Assert.assertFalse(driver.findElements(jobTitlesPage.jobTitleRowByName("QA Engineer")).isEmpty(), "Job Title was not deleted.");
    }

    @Test
    @Description("Test to measure the performance of Job Titles page load time")
    @Story("As a user, I want to ensure that the Job Titles page loads quickly")
    @TmsLink("https://jira.company.com/browse/HR-104")
    public void testJobTitlesPageLoadPerformance() {
        long startTime = System.currentTimeMillis();
        jobTitlesPage.goToJobTitles();
        long endTime = System.currentTimeMillis();

        long loadTime = endTime - startTime;
        System.out.println("Job Titles page load time: " + loadTime + " milliseconds");

        Assert.assertTrue(loadTime < 2000, "Job Titles page took too long to load: " + loadTime + " milliseconds");
    }

    @Test
    @Description("Test to add multiple job titles")
    @Story("As a user, I want to add multiple job titles quickly")
    @TmsLink("https://jira.company.com/browse/HR-105")
    public void testAddMultipleUsers() {
        try {
            for (int i = 1; i <= 4; i++) {
                jobTitlesPage.clickAddJobTitle();
                jobTitlesPage.typeJobTitle("OHRM " + i);
                jobTitlesPage.clickSave();
            }
        } catch (Exception e) {
            Assert.fail("Adding multiple users failed.");
        }
    }

    @Test
    @Description("Test to add job title with an empty field")
    @Story("As a user, I want to test adding job title with an empty field")
    @TmsLink("https://jira.company.com/browse/HR-106")
    public void testAddJobTitleWithEmptyField() {
        jobTitlesPage.clickAddJobTitle();
        jobTitlesPage.typeJobTitle("");
        jobTitlesPage.clickSave();
        Assert.assertTrue(jobTitlesPage.isJobTitlesPageVisible(), "Job Titles page is not visible after saving with empty field.");
    }
}
