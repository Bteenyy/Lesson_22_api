package api;


import io.restassured.response.Response;
import models.AddBookBodyModel;

import static io.restassured.RestAssured.given;
import static spec.AddBookSpec.addBookRequestSpec;
import static spec.AddBookSpec.addBookResponseSpec;

public class ActionWithBook {
    public void addBook(Response authResponse, String isbn){

        AddBookBodyModel addBookModel = new AddBookBodyModel();
        AddBookBodyModel.Collection collectionInfo = new AddBookBodyModel.Collection();
        collectionInfo.setIsbn(isbn);
        addBookModel.getIsbnInfo().add(collectionInfo);
        addBookModel.setId(authResponse.path("userId"));

        given(addBookRequestSpec)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .body(addBookModel)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(addBookResponseSpec)
                .statusCode(201);
    }
}
