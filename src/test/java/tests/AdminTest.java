package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;


public class AdminTest extends BaseTest {

    @Test
    public void testUserManagementNavigation() {

        login();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToUserManagement();

        Assert.assertTrue(adminPage.isUserManagementPageVisible(), "User Management page is not visible.");
    }
}