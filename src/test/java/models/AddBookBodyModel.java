package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBookBodyModel {
String id;
    Isbns collectionOfIsbns;
@Data
    public static class Isbns
    {
     String isbn;
    }

}
