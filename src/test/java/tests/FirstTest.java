package tests;

import com.codeborne.selenide.Condition;
import models.SuccessfulRegisterBodyModel;
import models.SuccessfulRegisterResponseModel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;
import static spec.SuccessfulRegisterSpec.successfulResponseSpec;

public class FirstTest extends TestBase {
    @Test
    void successfulRegisterTest() {
        SuccessfulRegisterBodyModel successfulRegisterBodyModel = new SuccessfulRegisterBodyModel();
        successfulRegisterBodyModel.setUserName("Bteeny");
        successfulRegisterBodyModel.setPassword("Test(111)^");
        SuccessfulRegisterResponseModel response = given(successfulRequestSpec)
                .body(successfulRegisterBodyModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successfulResponseSpec)
                .extract().as(SuccessfulRegisterResponseModel.class);
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
        open("/profile");
        $("#userName-value").shouldHave(Condition.text("Bteeny"));
    }
}
