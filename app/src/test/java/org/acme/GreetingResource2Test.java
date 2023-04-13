package org.acme;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class GreetingResource2Test {

    private GreetingResource instance;

    @BeforeEach
    public void beforeEach() {
        instance = new GreetingResource();
    }

    @AfterEach
    public void afterEach() {
        instance = null;
    }

    @Test
    public void testHelloEndpoint() {
        Assertions.assertEquals("Hello from RESTEasy Reactive lol", instance.hello());
    }

}