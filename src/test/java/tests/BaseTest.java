package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("baseUrl")
    public void setUp(@Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String baseUrl) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void Login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
