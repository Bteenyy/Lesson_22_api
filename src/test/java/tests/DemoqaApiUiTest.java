package tests;

import api.ActionWithBook;
import api.LoginWithApi;
import helpers.WithLogin;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import page.ProfilePage;

import static io.qameta.allure.Allure.step;

public class DemoqaApiUiTest extends TestBase {
    LoginWithApi auth = new LoginWithApi();
    Response authResponse = auth.getAuth();

    @Test
    @WithLogin
    void successfulRegisterTest() {
        ActionWithBook actionWithBook = new ActionWithBook();
        actionWithBook.deleteAllBooks(authResponse);
        actionWithBook.addBook(authResponse, "9781449325862");
        actionWithBook.deleteBook(authResponse, "9781449325862");
        ProfilePage profilePage = new ProfilePage();
        step("Check delete book", () -> {
            profilePage.profilePageOpen()
                    .weDoIt();
        });

    }
}
