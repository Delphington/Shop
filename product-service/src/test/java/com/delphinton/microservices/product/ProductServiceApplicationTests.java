package com.delphinton.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection //чтобы руками путь не писать
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private Integer port;

    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }



    @Test
    void shouldCreateProduct() {
        String requestBody = """
                    {
                    "name" : "iPhone 15",
                    "description" : "Something",
                    "price": 1000
                   }
                """;
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("iPhone 15"))
                .body("description", Matchers.equalTo("Something"))
                .body("price", Matchers.equalTo(1000));
    }
}
