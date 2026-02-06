package com.qartzoo.microservices.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InventoryServiceApplicationTests {

	@Container
	@ServiceConnection
	static MySQLContainer<?> mysql =
			new MySQLContainer<>("mysql:8.3.0");

	@LocalServerPort
	private int port;

	@BeforeAll
	void setupRestAssured() {
		RestAssured.baseURI = "http://localhost:" + port;
	}

	@Test
	void shouldReadInventory() {

		RestAssured.given()
				.queryParam("skuCode", "iphone_15")
				.queryParam("quantity", 1)
				.when()
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.body(is("true"));

		RestAssured.given()
				.queryParam("skuCode", "iphone_15")
				.queryParam("quantity", 1000)
				.when()
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.body(is("false"));
	}
}



