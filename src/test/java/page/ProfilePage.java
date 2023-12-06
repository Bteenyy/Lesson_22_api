package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    SelenideElement bookID = $("[href*='/profile?book=9781449325862']"),
            userName = $("#userName-value");

    public ProfilePage profilePageOpen() {
        open("/profile");
        userName.shouldHave(text("Bteeny"));
        return this;
    }

    public ProfilePage checkExist() {
        bookID.shouldNotBe(exist);
        return this;
    }
}
