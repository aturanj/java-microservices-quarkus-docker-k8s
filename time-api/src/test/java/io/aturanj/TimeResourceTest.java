package io.aturanj;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TimeResourceTest {

    @Test
    public void testTimeEndpoint() {
        given()
                .when()
                .get("/time")
                .then()
                .statusCode(200);
    }
}
