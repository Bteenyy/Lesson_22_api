package tests;

import api.ActionWithBook;
import api.LoginWithApi;
import helpers.WithLogin;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import page.ProfilePage;

public class FirstTest extends TestBase {
    LoginWithApi auth = new LoginWithApi();
    Response authResponse = auth.getAuth();

    @Test
    @WithLogin
    void successfulRegisterTest() {
        ActionWithBook clearBasket = new ActionWithBook();
        clearBasket.deleteAllBook(authResponse);
        clearBasket.addBook(authResponse, "9781449325862");
        clearBasket.deleteBook(authResponse, "9781449325862");
        ProfilePage profilePage = new ProfilePage();
        profilePage.profilePageOpen()
                .weDoIt();
    }
}
