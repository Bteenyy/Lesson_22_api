package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static spec.ClearBasketSpec.clearBasketResponseSpec;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;

public class ClearBasket {
    public void ClearBas(Response auth) {
        given(successfulRequestSpec)
                .header("Authorization", "Bearer " + auth.path("token"))
                .when()
                .delete("BookStore/v1/Books?UserId=" + auth.path("userId"))
                .then()
                .spec(clearBasketResponseSpec)
                .extract();
    }
}
