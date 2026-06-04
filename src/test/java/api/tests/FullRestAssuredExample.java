package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FullRestAssuredExample {

    public static void main(String[] args) {

        //  Base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //  Sending request and storing response
        Response response =
                RestAssured
                        .given()  // Request Setup Section

                        //  Headers
                        .header("Content-Type", "application/json")
                        .queryParam("userId", 1)
                        .when()   //  Sending Request

                        .get("/posts")  //  HTTP Method + Endpoint

                        .then()   //  Validations

                        .statusCode(200)   // Check status code

                        .extract()         // Extract response

                        .response();       // Store in Response object


        //  Using response object

        // Print status code
        System.out.println("Status Code: " + response.getStatusCode());

        // Print response body
        System.out.println("Response Body: " + response.getBody().asString());

        // Print specific value
        System.out.println("First Title: " + response.jsonPath().getString("title[0]"));

    }
}

