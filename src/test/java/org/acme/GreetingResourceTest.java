package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.codehaus.plexus.util.CachedMap;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                .get("/hello-resteasy")
                .then()
                .statusCode(403);
    }

    @Test
    void hello() {
        Map<String, ?> map = new HashMap<>();
        given()
                .when()
                .get("/hello-resteasy")
                .then()
                .statusCode(403);
    }

    @Test
    void test1() {
    }
}