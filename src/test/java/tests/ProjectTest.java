package tests;


import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {

    @Test(description = "Valid project creation")
    public void createNewProject() {
        loginPage.openTheSite();
        loginPage.login();
        projectPage.createNewProject();
        $(projectPage.TEST_ARTIFACTS_ABSENCE_TEXT).shouldHave(Condition.text("Looks like you don’t have any suites and cases yet."));
    }

    @Test(description = "Project settings page should be open")
    public void projectSettingsOpening() {
        loginPage.openTheSite();
        loginPage.login();
        projectPage.openProjectSettings();
        $(projectPage.SETTINGS_TITLE).shouldBe(Condition.visible);
    }


}