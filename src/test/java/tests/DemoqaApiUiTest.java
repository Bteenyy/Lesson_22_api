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
    ActionWithBook actionWithBook = new ActionWithBook();
    ProfilePage profilePage = new ProfilePage();

    @Test
    @WithLogin
    void successfulRegisterTest() {
        actionWithBook.deleteAllBooks(authResponse);
        actionWithBook.addBook(authResponse, "9781449325862");
        actionWithBook.deleteBook(authResponse, "9781449325862");
        step("Check delete book", () -> {
            profilePage.profilePageOpen()
                    .checkExist();
        });

    }
}
