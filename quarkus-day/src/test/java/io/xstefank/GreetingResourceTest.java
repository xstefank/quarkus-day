package io.xstefank;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    @TestSecurity(user = "alice", roles = "user")
    public void testHelloEndpoint() {
        given()
          .when().get("/api")
          .then()
             .statusCode(200);
    }

}