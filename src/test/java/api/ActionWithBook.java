package api;

import io.restassured.response.Response;
import models.AddBookBodyModel;
import models.DeleteBookBodyModel;

import static io.restassured.RestAssured.given;
import static spec.RegAndResSpec.requestSpec;
import static spec.RegAndResSpec.responseSpec;

public class ActionWithBook {
    public static void deleteAllBook(Response auth) {
        given(requestSpec)
                .header("Authorization", "Bearer " + auth.path("token"))
                .when()
                .delete("BookStore/v1/Books?UserId=" + auth.path("userId"))
                .then()
                .spec(responseSpec)
                .statusCode(204)
                .extract();
    }

    public static void addBook(Response authResponse, String isbn) {
        AddBookBodyModel addBookModel = new AddBookBodyModel();
        AddBookBodyModel.CollectionInfo collectionInfo = new AddBookBodyModel.CollectionInfo();
        collectionInfo.setIsbn(isbn);
        addBookModel.getCollectionOfIsbns().add(collectionInfo);
        addBookModel.setUserId(authResponse.path("userId"));
        given(requestSpec)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .body(addBookModel)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec)
                .statusCode(201);
    }

    public static void deleteBook(Response authResponse, String isbn) {
        DeleteBookBodyModel deleteBookBodyModel = new DeleteBookBodyModel();
        deleteBookBodyModel.setIsbn(isbn);
        deleteBookBodyModel.setUserId(authResponse.path("userId"));
        given(requestSpec)
                .header("Authorization", "Bearer " + authResponse.path("token"))
                .body(deleteBookBodyModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(responseSpec)
                .statusCode(204);
    }
}
