package api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePostTest {

    @Test
    public void updatePost() {

        // Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.useRelaxedHTTPSValidation();
        // Request body (Java 8 compatible)
        String body = "{\n" +
                "\"id\": 1,\n" +
                "\"title\": \"Updated Title\",\n" +
                "\"body\": \"Updated Content\",\n" +
                "\"userId\": 1\n" +
                "}";

        // PUT request
        given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Title"))
                .body("body", equalTo("Updated Content"))
                .body("userId", equalTo(1));
    }
}