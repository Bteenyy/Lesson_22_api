package api;

import models.AddBookBodyModel;
import models.AddBookResponceModel;
import models.SuccessfulRegisterBodyModel;
import models.SuccessfulRegisterResponseModel;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static spec.AddBookSpec.addBookRequestSpec;
import static spec.AddBookSpec.addBookResponseSpec;
import static spec.SuccessfulRegisterSpec.successfulRequestSpec;
import static spec.SuccessfulRegisterSpec.successfulResponseSpec;

public class LoginWithApi extends TestBase {
    @Test
    void addBooks() {
        AddBookBodyModel addBook = new AddBookBodyModel();
        // addBook.setId();
        addBook.getCollectionOfIsbns().setIsbn("9781449325862");
        AddBookResponceModel responseBook = given(addBookRequestSpec)
                .body(addBook)
                .when()
                .post("BookStore/v1/Books")
                .then()
                .spec(addBookResponseSpec)
                .extract().as(AddBookResponceModel.class);
    }

}
