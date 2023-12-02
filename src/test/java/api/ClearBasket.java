package api;

import static io.restassured.RestAssured.given;
import static spec.ClearBasketSpec.clearBasketRequestSpec;
import static spec.ClearBasketSpec.clearBasketResponseSpec;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;

public class ClearBasket {
    public void ClearBas(String userID, String token) {
        given(successfulRequestSpec)
                .body(clearBasketRequestSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("BookStore/v1/Books?UserId=" + userID)
                .then()
                .spec(clearBasketResponseSpec)
                .extract();
    }
}
