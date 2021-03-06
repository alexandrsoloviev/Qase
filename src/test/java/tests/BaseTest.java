package tests;


import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.ProjectPage;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected LoginPage loginPage;
    protected ProjectPage projectPage;

    @BeforeTest
    public void setUp() {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));

        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
        Configuration.timeout = 10000;

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("incognito");

        loginPage = new LoginPage();
        projectPage = new ProjectPage();

    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        getWebDriver().quit();
    }


}