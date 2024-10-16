package org.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testGetEndpoint() {
        // Фиктивный базовый URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1))
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")); // Пример значений
    }

    @Test
    public void testPostEndpoint() {
        // Фиктивный базовый URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";


        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/posts")
                        .then()
                        .statusCode(201)
                        .extract().response();


        System.out.println("Response: " + response.asString());
    }
}
