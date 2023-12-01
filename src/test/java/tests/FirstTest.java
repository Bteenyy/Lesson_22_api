package tests;

import com.codeborne.selenide.Condition;
import models.AddBookBodyModel;
import models.AddBookResponceModel;
import models.SuccessfulRegisterBodyModel;
import models.SuccessfulRegisterResponseModel;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static spec.AddBookSpec.addBookRequestSpec;
import static spec.AddBookSpec.addBookResponseSpec;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;
import static spec.SuccessfulRegisterSpec.successfulResponseSpec;

public class FirstTest extends TestBase {
    @Test
            void checkTest(){
        open("/favicon.ico");
            //getWebDriver().manage().addCookie(new Cookie("userID", response.getUserId()));
         //   getWebDriver().manage().addCookie(new Cookie("expires", response.getExpires()));
           // getWebDriver().manage().addCookie(new Cookie("token", response.getToken()));
           // getWebDriver().manage().addCookie(new Cookie("isbn",responseBook.getIsbn()));
            open("/profile");
            $("#userName-value").shouldHave(Condition.text("Bteeny"));
        }


}
