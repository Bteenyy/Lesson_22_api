package api;

import io.restassured.response.Response;
import models.SuccessfulRegisterBodyModel;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;
import static spec.SuccessfulRegisterSpec.successfulResponseSpec;

public class LoginWithApi extends TestBase {
    public Response Login() {
        SuccessfulRegisterBodyModel successfulRegisterBodyModel = new SuccessfulRegisterBodyModel();
        successfulRegisterBodyModel.setUserName("Bteeny");
        successfulRegisterBodyModel.setPassword("Test(111)^");
        return given(successfulRequestSpec)
                .body(successfulRegisterBodyModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successfulResponseSpec)
                .extract().response();
    }

}
