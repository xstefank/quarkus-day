package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Brno Java Meetup"));
    }

    @Test
    @Disabled
    public void testHelloEndpoint2() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        given()
            .when().get("/api/hello")
            .then()
            .statusCode(200)
            .body(is("Hello from Brno Java Meetup"));
    }


    @Test
    public void testHello2Endpoint() {
        given()
            .when().get("/api/hello2")
            .then()
            .statusCode(200)
            .body(is("Hello 2"));
    }


}