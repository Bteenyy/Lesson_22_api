package tests;

import com.codeborne.selenide.Condition;
import helpers.WithLogin;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FirstTest extends TestBase {
    @Test
    @WithLogin
    void successfulRegisterTest() {
        open("/profile");
        $("#userName-value").shouldHave(Condition.text("Bteeny"));
    }


}
