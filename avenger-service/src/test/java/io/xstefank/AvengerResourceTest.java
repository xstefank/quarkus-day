package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.xstefank.model.Avenger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class AvengerResourceTest {

    @Test
    void all() {
        given()
            .when().get("/avenger")
            .then()
            .statusCode(200)
            .body("size()", is(5));
    }

    @Test
    void create() {
        Avenger avenger = new Avenger();
        avenger.name = "Xstefank";
        avenger.civilName = "Martin";
        avenger.snapped = true;
        given()
            .body(avenger)
            .contentType(ContentType.JSON)
            .when().post("/avenger")
            .then()
            .body("name", is(avenger.name))
            .body("id", notNullValue());
    }
}