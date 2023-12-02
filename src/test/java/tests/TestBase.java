package tests;

import api.LoginWithApi;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAff() {
        Configuration.baseUrl="https://demoqa.com";
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.pageLoadStrategy= "eager";
      //  RestAssured.basePath = "/login";
    }
}
