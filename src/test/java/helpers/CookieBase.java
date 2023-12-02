package helpers;

import api.ActionWithBook;
import api.ClearBasket;
import api.LoginWithApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookieBase implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        LoginWithApi loginWithApi = new LoginWithApi();
        Response cookie = loginWithApi.getAuth();
        ClearBasket clearBasket = new ClearBasket();
        ActionWithBook actionWithBook = new ActionWithBook();
        clearBasket.ClearBas(cookie);
        actionWithBook.addBook(cookie, "9781449365035");
        open("/images/gplaypattern.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", cookie.path("userId")));
        getWebDriver().manage().addCookie(new Cookie("expires", cookie.path("expires")));
        getWebDriver().manage().addCookie(new Cookie("token", cookie.path("token")));
    }
}
