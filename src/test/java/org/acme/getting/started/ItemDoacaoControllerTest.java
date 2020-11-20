package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;



@QuarkusTest
public class ItemDoacaoControllerTest {

    @Test
    public void inserirTest() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("nome", "Rafael");
        requestParams.put("ativo", true);
        requestParams.put("valorReferencia", 10);

        given()
        .body(requestParams)
        .when().post("/itens")
        .then()
        .statusCode(201);
        //.body("id", notNullValue());
        //.extract().body().jsonPath().getString("id");
  
    }

    @Test
    public void findIdTest(){
        given().param("id", 1).when().get("/itens").then().statusCode(200);
    }

}