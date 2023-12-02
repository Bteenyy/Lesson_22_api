package helpers;

import api.ClearBasket;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import api.LoginWithApi;
import io.restassured.response.Response;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookieBase implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        LoginWithApi loginWithApi = new LoginWithApi();
        Response cookie = loginWithApi.Login();
        ClearBasket clearBasket = new ClearBasket();
        clearBasket.ClearBas(cookie.path("userId"), cookie.path("token"));
        open("/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", cookie.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("expires", cookie.path("expires")));
        getWebDriver().manage().addCookie(new Cookie("token", cookie.path("token")));
    }
}
