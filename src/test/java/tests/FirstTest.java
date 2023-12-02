package tests;

import api.ActionWithBook;
import api.ClearBasket;
import api.LoginWithApi;
import com.codeborne.selenide.Condition;
import helpers.WithLogin;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest extends TestBase {
    LoginWithApi auth = new LoginWithApi();
    Response authResponse = auth.getAuth();

    @Test
    @WithLogin
    void successfulRegisterTest() {

        open("/profile");
        $("#userName-value").shouldHave(Condition.text("Bteeny"));
    }


}
