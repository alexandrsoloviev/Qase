import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void login(){
        open("/login");
        $("#inputEmail").sendKeys("sedoi8990@gmail.com");
        $("#inputPassword")
                .setValue("sedoi733640")
                .submit();
        $(By.id("createButton")).shouldBe(visible);
    }
}
