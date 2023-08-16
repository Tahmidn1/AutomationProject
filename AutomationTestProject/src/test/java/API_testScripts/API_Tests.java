package API_testScripts;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_Tests {


    @BeforeAll
    public static void setUp() {
        // Set base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    //positive test scenario

    @Test
    public void testFetchingData() {

        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0)); // Validate response has data
    }


    //negative test scenario
    @Test
    public void testErrorResponse() {
        String invalidEndpoint = "/asdfadsf";

        given()
                .when()
                .get(invalidEndpoint)
                .then()
                .statusCode(404);
    }

    //positive test for creating a new post


    @Test
    public void testCreatingPost() {
        String requestBody = "{\"title\": \"New Post\",\"body\": \"New Post has been created.\"}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("New Post"));
    }

    //negative test for creating a new post

    @Test
    public void testCreatingPost_NegativeScenario() {
        String invalidRequestBody = "fdasfdsaf";

        given()
                .contentType("application/json")
                .body(invalidRequestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(500); // Expected response code for internal server error
    }










}
